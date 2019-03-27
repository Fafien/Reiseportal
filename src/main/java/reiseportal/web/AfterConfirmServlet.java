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
 * @author Marwa Alqataa
 */

    @WebServlet(name = "AfterConfirmServlet", urlPatterns = {"/afterconfirm"})
public class AfterConfirmServlet extends HttpServlet {
    
    public static final String URL = "/afterconfirm";
    
    HttpSession session;
    Hotel hotel;
      
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        request.setAttribute("hotel", session.getAttribute("viewHotel"));
        request.setAttribute("persons", session.getAttribute("persons"));
        request.setAttribute("ankunft", session.getAttribute("fromDateOriginal"));
        request.setAttribute("abreise", session.getAttribute("untilDateOriginal"));
        request.getRequestDispatcher("/WEB-INF/afterconfirm.jsp").forward(request, response);
        
    }
    }