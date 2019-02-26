/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    HttpSession session;
    ArrayList<Integer> error = new ArrayList<Integer>();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        usr = (Useraccount) session.getAttribute("useraccount");
  
        if(usr != null){
            session.setAttribute("firstname", usr.getFirstname());
            session.setAttribute("lastname", usr.getLastname());
            session.setAttribute("email", usr.getEmail());
            session.setAttribute("username", usr.getUsername());
            request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usr = new Useraccount(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("username"));

        if(usr.checkValues()){
            if(userBean.findUserByEmailOrUsername(request.getParameter("email"), request.getParameter("username")).isEmpty()){

                userBean.createNewUser(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("username"));
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);

            }
            else{
                //Meldung: Username oder E-Mail schon verwendet
                error.add(1);
            }
            if(request.getParameter("email").equals(request.getParameter("emailb"))){
                //Meldung: E-Mails stimmen nicht überein 
                error.add(2);
            }
            if(request.getParameter("password").equals(request.getParameter("passwordb"))){
                //Passwörter passen nicht überein
                error.add(3);
        }
        }
        else{
            //Meldung: Bitte alle Felder ausfüllen
            error.add(4);
        }
        if(error.size() > 0){
            for(int i = 0; i < error.size(); i++){
                switch(error.get(i)){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
            session = request.getSession();
            session.setAttribute("useraccount", usr);
            response.sendRedirect(request.getContextPath() + RegistrationServlet.URL);
        }
    }
    
}
