/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import reiseportal.jpa.Useraccount;

/**
 *
 * @author Marwa Alqataa
 */
    @WebServlet(name = "BookingViewServlet", urlPatterns = {"/bookingview"})
     public class BookingViewServlet extends HttpServlet{
      public static final String URL = "/bookingview";
        
       @EJB
       BookingBean bookingBean;
     
       @Override
       public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Useraccount usr = (Useraccount) session.getAttribute("usr");
        List<Booking> bookingList;
        bookingList = bookingBean.findBookingByUseraccount(usr);
        String  error;
         
        if(bookingList == null){
         error= "Sie haben kein Hotel gebucht";
         request.setAttribute("bookinglist.hotelname", "" );
         request.setAttribute("bookinglist.ort", "" );
         request.setAttribute("bookinglist.sterne", "" );
        }else{
         Iterator<Booking> iter = bookingList.listIterator();
         List<Hotel> bookingHotelList = new ArrayList<>();
            while(iter.hasNext()){ 
                  Hotel hotel =  iter.next().getHotel();
                  bookingHotelList.add(hotel);
        }
         request.setAttribute("bookinglist", bookingHotelList );
         error = "";
        }
        
        request.setAttribute("error", error);
        request.getRequestDispatcher("/WEB-INF/bookingview.jsp").forward(request, response);
        }
       
        @Override
         public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
           response.sendRedirect(request.getContextPath() + EvaluationServlet.URL);
    }
  }