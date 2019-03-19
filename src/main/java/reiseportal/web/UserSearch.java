/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
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
 * @author belizbalim
 */
@WebServlet(name = "UserSearch", urlPatterns = {"/usersearch"})
public class UserSearch extends HttpServlet {
    
    public static final String URL = "/usersearch";
    
    @EJB
    UserBean userbean;
    HttpSession session;
    
  
    List<Useraccount> userlist;
    String username;
    String email;
    String error;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        session = request.getSession();

        /*try{
            session.getAttribute("usr");           
        }catch(NullPointerException e){
            //Kann ignoriert werden das dies nur als Bestätigung verwendet wird, das man nicht eingeloggt ist.
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }*/
        
        // Von dem Benutzer bereits angegebene Daten anzeigen
        if(username!=null){
            request.setAttribute("username",username);
        }
        if(email!=null){
            request.setAttribute("email",email);
        }
        if(error!=null){
            request.setAttribute("error",error);
        }
        request.getRequestDispatcher("/WEB-INF/usersearch.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Den vom Admin eingegebene Benutzer in der Datenbank suchen,ggf. Fehlermeldung anzeigen
        username = request.getParameter("username");
        email = request.getParameter("email");
        userlist = userbean.findUserByEmailOrUsername(email, username);

        
       if (userlist.isEmpty()) {
            error = "Kein Benutzer gefunden";
            request.setAttribute("error",error);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            response.sendRedirect(request.getContextPath() + this.URL);
        }
        else {
           session.setAttribute ("founduser", userlist.get(0));
           response.sendRedirect(request.getContextPath() + UserAdministrationServlet.URL);
          
        }
        
    }
    
}
