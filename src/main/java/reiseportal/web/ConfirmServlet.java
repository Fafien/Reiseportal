/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

/**
 *
 * @author Marwa Alqataa
 */


import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.BookingBean;
import reiseportal.ejb.HotelBean;
import reiseportal.jpa.Hotel;
import reiseportal.jpa.Useraccount;

/**
 *
 * @author Marwa Alqataa
 */
@WebServlet(name = "ConfirmServlet", urlPatterns = {"/confirm"})
public class ConfirmServlet extends HttpServlet {
    
    public static final String URL = "/confirm";
    
    @EJB
    HotelBean hotelbean;
    
    @EJB
    BookingBean bookingBean;  

    HttpSession session;
    
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
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Das Speicher in den Datenbank funktioniert nicht ein Problem mit dem Datum
//            session = request.getSession();
            Hotel hotel = (Hotel) session.getAttribute("viewHotel"); 
            Useraccount usr = (Useraccount) session.getAttribute("usr");
            Date anfahrt = (Date) session.getAttribute("fromDate");
            Date abreise =(Date) session.getAttribute("untilDate");
            int personen = (int)   session.getAttribute("persons");
         
        this.bookingBean.createNewBooking(hotel, usr, anfahrt, abreise  ,personen, true);
       
         //response.sendRedirect(request.getContextPath() + BookingViewServlet.URL);
         //response.sendRedirect(request.getContextPath() + EvaluationServlet.URL);
         response.sendRedirect(request.getContextPath() + AfterConfirmServlet.URL);
    }
}
