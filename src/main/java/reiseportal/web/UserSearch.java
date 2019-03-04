/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author belizbalim
 */
@WebServlet(name = "UserSearch", urlPatterns = {"/usersearch"})
public class UserSearch extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /*try{
            session.getAttribute("usr");           
        }catch(NullPointerException e){
            //Kann ignoriert werden das dies nur als Bestätigung verwendet wird, das man nicht eingeloggt ist.
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }*/
        
        request.getRequestDispatcher("/WEB-INF/usersearch.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/useradministration.jsp").forward(request, response);
    }
    
}
