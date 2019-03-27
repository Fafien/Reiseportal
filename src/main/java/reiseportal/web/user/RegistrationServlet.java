/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web.user;

import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.UserBean;
import reiseportal.jpa.Useraccount;
import reiseportal.web.IndexServlet;

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
    ArrayList<String> error;
    
    //Variablen für Mail-Versand
    String toMail;
    String contentEmail;
    String registrationLink;
    
    
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
        
        try{
            if(!request.getParameter("registrationConfirmation").isEmpty()){
                try{
                    usr = userBean.findUserbyID(Long.parseLong(request.getParameter("registrationConfirmation"), 2));
                    if(usr != null){
                        usr.setActivated(true);
                        userBean.updateUser(usr);
                        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                    }
                }catch(Exception e){
                    //Erstmal ignorieren
                }
            }
        }catch(Exception ex){
            
        }
  
        if(usr != null){
            request.setAttribute("firstname", usr.getFirstname());
            request.setAttribute("lastname", usr.getLastname());
            request.setAttribute("email", usr.getEmail());
            request.setAttribute("username", usr.getUsername());
            request.setAttribute("errors", error);
            request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
        }
        else{
            request.setAttribute("errors", error);
            request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
        }
       
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usr = new Useraccount(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("username"));
        usr.setPassword(usr.getPassword());
        error = new ArrayList<String>();
        
        if(usr.checkValues()){
            if(!request.getParameter("email").equals(request.getParameter("emailb"))){
                error.add("E-Mails stimmen nicht überein");
            }
            if(!request.getParameter("password").equals(request.getParameter("passwordb"))){
                error.add("Passwörter stimmen nicht überein");
            }
            if(userBean.findUserByEmailOrUsername(request.getParameter("email"), request.getParameter("username")).isEmpty()){
                if(error.isEmpty()){
                    usr = userBean.createNewUser(usr.getFirstname(), usr.getLastname(), usr.getEmail(), usr.getPassword(), usr.getUsername());
                    
                    toMail = usr.getEmail();
                    registrationLink = "http://localhost:8080/Reiseportal/registration?registrationConfirmation="+ Long.toBinaryString(usr.getId());
                    
                    contentEmail = "Vielen Dank " + usr.getFirstname() + " für deine Registrierung.<br>" 
                            + "Dein Username lautet: " + usr.getUsername() + "<br>"
                            + "Um die Registrierung abzuschließen und somit den Account freizuschalten klicke bitte auf folgenden Link:<br>"
                            + "<a href='"
                            + registrationLink
                            + "'>Link</a><br><br>"
                            + "Mit freundlichen Grüßen<br>"
                            + "Ihr Reiseportal";
                    
                    EmailUtil.sendEmail(toMail, "Registrierung Reiseportal", contentEmail);
                    
                    session.invalidate();
                    usr = null;
                    
                    response.sendRedirect(request.getContextPath() + IndexServlet.URL);
                }
            }
            else{
                error.add("Username oder E-Mail schon verwendet");
            }
        }
        else{
            error.add("Bitte alle Felder ausfüllen");
        }
        
        if(!error.isEmpty()){
            //session.setAttribute("errors", error);
            response.sendRedirect(request.getContextPath() + RegistrationServlet.URL);
        }
    }
    
}
