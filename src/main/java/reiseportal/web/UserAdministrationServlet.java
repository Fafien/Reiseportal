/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
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
@WebServlet(name = "UserAdministrationServlet", urlPatterns = {"/useradministration"})
public class UserAdministrationServlet extends HttpServlet{

    public static final String URL = "/useradministration";
    
    HttpSession session;
    Useraccount usr;
    Useraccount founduser;
  
    @EJB
    UserBean userbean;
    
    boolean delete = false;
  
    //Gesuchte und gefundene Benutzer mit seinen Attributen angezeigt. 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        try{
            Useraccount usr = (Useraccount) session.getAttribute("usr");
            if(!usr.isAdmn()){
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
        }
        catch(NullPointerException e){
            
        }
        
        founduser = (Useraccount) session.getAttribute("founduser");
        
        request.setAttribute("founduser", founduser);
        request.setAttribute ("delete", delete);
        request.getRequestDispatcher("/WEB-INF/useradministration.jsp").forward(request, response);
      
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       founduser = (Useraccount) session.getAttribute("founduser");
        
        //Ermittlung auf welches Button geklickt wurde
        switch(request.getParameter("button")){
            // Den benutzer zum Admin ernennen
            case "admin":
               userbean.setAdmin(founduser, true); 
               response.sendRedirect(request.getContextPath() + this.URL);
               break;
            // Die Adminrechte des Benutzers entfernen   
            case "noadmin":
              userbean.setAdmin(founduser, false); 
              response.sendRedirect(request.getContextPath() + this.URL);
                break;
            //Den Benutzer sperren    
            case "sperren":
                userbean.setBlocked(founduser, true); 
                response.sendRedirect(request.getContextPath() + this.URL);
                break;
            // Den Benutzer entsperren    
            case "entsperren":
                userbean.setBlocked(founduser, false);
                response.sendRedirect(request.getContextPath() + this.URL);
                break;
            // Den Benutzer löschen     
            case "loeschen":
                delete = true;
                response.sendRedirect(request.getContextPath() + UserAdministrationServlet.URL);
                break;
            case "loeschenja":
                delete = false;
                userbean.deleteUser(founduser.getId());
                response.sendRedirect(request.getContextPath() + UserSearch.URL);
                break;
            case "loeschennein":
                delete = false;
                response.sendRedirect(request.getContextPath() + UserAdministrationServlet.URL);
                break;
        }      
    }
}
