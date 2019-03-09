/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

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
  
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();  
        founduser = (Useraccount) session.getAttribute("founduser");
        
        request.setAttribute("founduser", founduser);
        request.getRequestDispatcher("/WEB-INF/useradministration.jsp").forward(request, response);
        
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       founduser = (Useraccount) session.getAttribute("founduser");
        
        switch(request.getParameter("button")){
            case "admin":
               userbean.setAdmin(founduser, true); 
               response.sendRedirect(request.getContextPath() + this.URL);
               break;
            case "noadmin":
              userbean.setAdmin(founduser, false); 
              response.sendRedirect(request.getContextPath() + this.URL);
                break;
            case "sperren":
                userbean.setBlocked(founduser, true); 
                response.sendRedirect(request.getContextPath() + this.URL);
                break;
            case "entsperren":
                userbean.setBlocked(founduser, false);
                response.sendRedirect(request.getContextPath() + this.URL);
                break;
            case "loeschen":
                userbean.deleteUser(founduser.getId());
                response.sendRedirect(request.getContextPath() + UserSearch.URL);
                break;
        }
        
       
           
    }
}
