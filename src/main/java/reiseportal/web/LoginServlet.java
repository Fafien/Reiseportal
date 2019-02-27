/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.UserBean;
import reiseportal.jpa.Useraccount;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    public static final String URL = "/login";
    
    @EJB
    UserBean userbean;
    HttpSession session;
    List<Useraccount> userlist;
    String error = new String();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        try{
            if(!session.getAttribute("usr").equals(new Useraccount())){
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
        }catch(NullPointerException e){
            //Kann ignoriert werden das dies nur als Bestätigung verwendet wird, das man nicht eingeloggt ist.
        }
        
        request.setAttribute("error", error);
        
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("username").trim().isEmpty() || request.getParameter("password").trim().isEmpty()){
            error = "Bitte alle Felder füllen";
            response.sendRedirect(request.getContextPath() + LoginServlet.URL);
        }
        else{
            userlist = this.userbean.findUserByEmailOrUsername(" ", request.getParameter("username"));
        
        if(userlist.size() > 0){
        
            if(userlist.get(0).getPassword().compareTo(request.getParameter("password")) == 0){
                session = request.getSession();  
                session.setAttribute("usr", userlist.get(0));

                response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            }
            else{
                //Rückgabe: Unter den Angaben konnte kein Konto gefunden werden
                error = "Unter den Angaben konnte kein Konto gefunden werden";
                response.sendRedirect(request.getContextPath() + LoginServlet.URL);
            }
        
        }
        else{
            //Rückgabe: Unter den Angaben konnte kein Konto gefunden werden
            error = "Unter den Angaben konnte kein Konto gefunden werden";
            response.sendRedirect(request.getContextPath() + LoginServlet.URL);
        }
        }
    }
}

