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
import reiseportal.ejb.HotelBean;
import reiseportal.jpa.Hotel;

/**
 *
 * @author Fabian Hupe
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {

    public static final String URL = "/index.html";
        
    @EJB
    HotelBean hotelbean;
        
    List<Hotel> hotellist;
    HttpSession session;
    String error = new String();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("errors", error);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        session.setAttribute("location", request.getParameter("location"));
        session.setAttribute("fromDate", request.getParameter("fromDate"));
        session.setAttribute("untilDate", request.getParameter("untilDate"));
        session.setAttribute("persons", request.getParameter("persons"));
        
        if(!request.getParameter("fromDate").trim().isEmpty() && !request.getParameter("location").trim().isEmpty() && !request.getParameter("untilDate").trim().isEmpty() && !request.getParameter("persons").trim().isEmpty()) {
            
            hotellist = hotelbean.findHotelsByInput(request.getParameter("location"), request.getParameter("fromDate"), request.getParameter("untilDate"), request.getParameter("persons"));
            
            if(hotellist.isEmpty()) {
                error = "Zu ihren Suchdaten gibt es keine passenden Ergebnisse";
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            } else {
                error = "";
                session.setAttribute("hotels", hotellist);
                response.sendRedirect(request.getContextPath() + SelectionServlet.URL);
            }
        } else {
            error = "Bitte geben sie gültige Daten ein";
            response.sendRedirect(request.getContextPath() + IndexServlet.URL);
        }
    }
}
