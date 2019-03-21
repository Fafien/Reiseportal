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
import reiseportal.jpa.Useraccount;

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
    Useraccount usr;
    String error= new String();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        //gewähltes Hotel mit der dazugehörigen Ausstattung weitergeben
        request.setAttribute("hotel", session.getAttribute("viewHotel"));
        request.setAttribute("hotelaus", session.getAttribute("HotelAusstattung"));
       
        request.getRequestDispatcher("/WEB-INF/overview.jsp").forward(request, response);
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //User muss angemeldet sein, um ein Hotel buchen zu können
        usr = (Useraccount) session.getAttribute("usr");
        if(usr == null){
            error = "Bitte loggen Sie sich erst ein"; 
            session.setAttribute("error", error);
            response.sendRedirect(request.getContextPath() + LoginServlet.URL);
        } else{
            //wenn User angemeldet, dann Weiterleitung zum Buchungs-Serblet
            response.sendRedirect(request.getContextPath() + ConfirmServlet.URL);
    }
    }
}
