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
import reiseportal.ejb.HotelBean;
import reiseportal.jpa.Hotel;

/**
 *
 * @author jonas
 */
@WebServlet(name = "OverviewServlet", urlPatterns = {"/overview"})
public class OverviewServlet extends HttpServlet {
    
    public static final String URL = "/overview";
    
    @EJB
    HotelBean hotelbean;
    
    HttpSession session;
    Hotel hotel;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        request.setAttribute("hotel", session.getAttribute("viewHotel"));
        request.setAttribute("hotelaus", session.getAttribute("HotelAusstattung"));
        request.getRequestDispatcher("/WEB-INF/overview.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //TODO
        //Weiterleitung zur Buchungsseite
        //response.sendRedirect(request.getContextPath() + BookingServlet.URL);
    }
}
