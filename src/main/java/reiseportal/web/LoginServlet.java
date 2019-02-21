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
    
    List<Useraccount> userlist;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        userlist = this.userbean.findUserByEmailOrUsername(" ", request.getParameter("username"));
        
        if(userlist.get(0).getPassword().compareTo(request.getParameter("password")) == 0){
            HttpSession session = request.getSession();  
            session.setAttribute("name", userlist.get(0).getFirstname());
            request.setAttribute("session", session);
            request.setAttribute("name", userlist.get(0).getFirstname());
            
            response.sendRedirect(request.getContextPath() + IndexServlet.URL);
        }
        else{
            //Rückgabe: Unter den Angaben konnte kein Konto gefunden werden
            response.sendRedirect(request.getContextPath() + LoginServlet.URL);
        }
        
    }
}
