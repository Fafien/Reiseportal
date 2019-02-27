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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fabian Hupe
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {

    public static final String URL = "/index.html";
    
    HttpSession session;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        if(!request.getParameter("fromDate").trim().isEmpty() && !request.getParameter("location").trim().isEmpty() && !request.getParameter("untilDate").trim().isEmpty() && !request.getParameter("persons").trim().isEmpty()) {
            
            session.setAttribute("location", request.getParameter("location"));
            session.setAttribute("fromDate", request.getParameter("fromDate"));
            session.setAttribute("untilDate", request.getParameter("untilDate"));
            session.setAttribute("persons", request.getParameter("persons"));
            
            response.sendRedirect(request.getContextPath() + SelectionServlet.URL);
        } else {
            //TODO
            //Poop-Up mit Fehlermeldung
            response.sendRedirect(request.getContextPath() + IndexServlet.URL);
        }
    }
}
