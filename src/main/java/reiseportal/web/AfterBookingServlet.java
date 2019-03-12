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
import reiseportal.ejb.BookingBean;
import reiseportal.ejb.HotelBean;
import reiseportal.jpa.Booking;
import reiseportal.jpa.Hotel;

/**
 *
 * @author dar
 */
public class AfterBookingServlet {
    @WebServlet(name = "AfterBookingServlet", urlPatterns = {"/afterBooking"})
public class ConfirmServlet extends HttpServlet {
    
    public static final String URL = "/afterBooking";
    
    @EJB
    HotelBean hotelbean;
    
    HttpSession session;
    Hotel hotel;
      
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        request.setAttribute("hotel", session.getAttribute("viewHotel"));
        request.setAttribute("persons", session.getAttribute("persons"));
        request.setAttribute("ankunft", session.getAttribute("fromDate"));
        request.setAttribute("abreise", session.getAttribute("untilDate"));
        request.getRequestDispatcher("/WEB-INF/confirm.jsp").forward(request, response);
        
    }

    
}
}