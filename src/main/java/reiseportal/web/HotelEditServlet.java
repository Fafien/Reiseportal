/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.UserBean;
import reiseportal.jpa.Hotel;

/**
 *
 * @author belizbalim
 */
public class HotelEditServlet {


@WebServlet(name = "UserSearch", urlPatterns = {"/hotelsearch"})
public class HotelSearchServlet extends HttpServlet {
    
    public static final String URL = "/hotelsearch";
    
    @EJB
    UserBean hotelbean;
    HttpSession session;
    
  
    List<Hotel> hotellist;
    //String username;
    //String email;
    //String error;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        session = request.getSession();

        /*try{
            session.getAttribute("usr");           
        }catch(NullPointerException e){
            //Kann ignoriert werden das dies nur als Bestätigung verwendet wird, das man nicht eingeloggt ist.
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }*/
        
        /*if(username!=null){
            request.setAttribute("username",username);
        }
        if(email!=null){
            request.setAttribute("email",email);
        }
        if(error!=null){
            request.setAttribute("error",error);
        }
        request.getRequestDispatcher("/WEB-INF/usersearch.jsp").forward(request, response);
*/
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    
        /*username = request.getParameter("username");
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
*/
        
    }
    
}  
}
