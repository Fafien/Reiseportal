/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import reiseportal.web.evaluation_booking.ConfirmServlet;
import reiseportal.web.useraccount.LoginServlet;

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
    String gesamterPriseStr;
    
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
        
        //Gesamten Preis der Buchung berechnen
        Hotel hotel = (Hotel) session.getAttribute("viewHotel"); 
        String ankunft = (String) session.getAttribute("fromDateOriginal");
        String abreise = (String) session.getAttribute("untilDateOriginal");
        String ankunftSt = ankunft.substring(0,2) + "/" + ankunft.substring(3,5) + "/" + ankunft.substring(6,10);
        String abreiseSt = abreise.substring(0,2) + "/" + abreise.substring(3,5) + "/" + abreise.substring(6,10);
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        long diff;
        try {
            Date date1 = myFormat.parse(ankunftSt);
            Date date2 = myFormat.parse(abreiseSt);
            diff = date2.getTime() - date1.getTime();
        } catch (ParseException ex) {
           throw new ServletException();
        }
            
        int preis = hotel.getPreisProNacht();
        int gesamteTage =  (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) ;
        int gesamterPreis = gesamteTage * preis;
        
        session.setAttribute("gesamterPriseStr", gesamterPreis);
        
        //User muss angemeldet sein, um ein Hotel buchen zu können
        usr = (Useraccount) session.getAttribute("usr");
        if(usr == null){
            error = "Bitte loggen Sie sich erst ein"; 
            session.setAttribute("error", error);
            response.sendRedirect(request.getContextPath() + LoginServlet.URL);
        } else{
            //wenn User angemeldet, dann Weiterleitung zum Buchungs-Servlet
            session.removeAttribute("filter");
            session.removeAttribute("filterLabel");
            response.sendRedirect(request.getContextPath() + ConfirmServlet.URL);
        }
    }
}
