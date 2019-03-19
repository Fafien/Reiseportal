/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.UserBean;
import reiseportal.jpa.Useraccount;



@WebServlet(name = "UseraccountServlet", urlPatterns = {"/useraccount"})
public class UseraccountServlet extends HttpServlet {

    HttpSession session;
    Useraccount usr;
    ArrayList<String> errors;
    
    @EJB
    UserBean userbean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        session = request.getSession();
        
        try{
            Useraccount usr = (Useraccount) session.getAttribute("usr");
            if(!usr.isAdmn()){
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
        }catch(NullPointerException e){
            
        }
        
        session.removeAttribute("edit");
        session.removeAttribute("password");
        session.removeAttribute("delete");
        try{
            session.getAttribute("usr");           
        }catch(NullPointerException e){
            //Kann ignoriert werden das dies nur als Bestätigung verwendet wird, das man nicht eingeloggt ist.
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }
        
        request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usr = (Useraccount) session.getAttribute("usr");
        
        switch(request.getParameter("button")){
            case "delete":
                session.setAttribute("delete", true);
                request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
                break;
            case "deletey":
                userbean.deleteUser(usr.getId());
                session.invalidate();
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                break;
            case "deleten":
                session.removeAttribute("delete");
                request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
                break;
            case "edit":
                session.setAttribute("edit", true);
                request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
                break;
            case "password":
                session.setAttribute("password", true);
                request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
                break;
            case "save":
                usr.setFirstname(request.getParameter("usr_form_firstname"));
                usr.setLastname(request.getParameter("usr_form_lastname"));
                usr.setEmail(request.getParameter("usr_form_email"));
                session.setAttribute("usr", usr);
                userbean.updateUser(usr);
                session.removeAttribute("edit");
                request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
                break;
            case "savep":
                errors = new ArrayList<String>();
                if(request.getParameter("usr_form_passwordo").equals(usr.getPassword())){
                    if(request.getParameter("usr_form_password").equals("usr_form_passwordb")){
                        usr.setPassword(request.getParameter("usr_form_password"));
                        session.setAttribute("usr", usr);
                        userbean.updateUser(usr);
                        session.removeAttribute("password");
                        session.removeAttribute("errors");
                        request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
                    }
                    errors.add("Neue Passwörter stimmen nicht überein");
                }
                else{
                    errors.add("Altes Passwort stimmt nicht");
                }
                session.setAttribute("errors", errors);
                request.getRequestDispatcher("/WEB-INF/useraccount.jsp").forward(request, response);
                break;
        }
        
    }
}
