/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reiseportal.ejb.UserBean;
import reiseportal.jpa.Useraccount;

/**
 *
 * @author Fabian Hupe
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    
    public static final String URL = "/registration";
    
    @EJB
    UserBean userBean;
    
    Useraccount usr;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("email").equals(request.getParameter("emailb"))){
            //Meldung: E-Mails stimmen nicht überein
            response.sendRedirect(request.getContextPath() + RegistrationServlet.URL);
        }
        if(request.getParameter("password").equals(request.getParameter("passwordb"))){
            //Passwörter passen nicht überein
            response.sendRedirect(request.getContextPath() + RegistrationServlet.URL);
        }
        usr = new Useraccount(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("username"));
        if(usr.checkValues()){
            if(userBean.findUserByEmailOrUsername(request.getParameter("email"), request.getParameter("username")).isEmpty()){

                userBean.createNewUser(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("username"));
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);

            }
            else{
                //Meldung: Username oder E-Mail schon verwendet
                response.sendRedirect(request.getContextPath() + RegistrationServlet.URL);
            }
        }
        else{
            //Meldung: Bitte alle Felder ausfüllen
            response.sendRedirect(request.getContextPath() + RegistrationServlet.URL);
        }
    }
    
}
