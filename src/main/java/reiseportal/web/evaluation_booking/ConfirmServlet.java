/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web.evaluation_booking;

/**
 *
 * @author Marwa Alqataa
 */


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        
        //alle daten zum gewählten Hotel weitergeben       
        request.setAttribute("hotel", session.getAttribute("viewHotel"));
        request.setAttribute("gesamterPreis", session.getAttribute("gesamterPriseStr"));
        request.setAttribute("persons", session.getAttribute("persons"));
        request.setAttribute("ankunft", session.getAttribute("fromDateOriginal"));
        request.setAttribute("abreise", session.getAttribute("untilDateOriginal"));
        request.getRequestDispatcher("/WEB-INF/confirm.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            session = request.getSession();
           
            //allle gewählten Daten auslesen
            Hotel hotel = (Hotel) session.getAttribute("viewHotel"); 
            Useraccount usr = (Useraccount) session.getAttribute("usr");
            String ankunft = (String) session.getAttribute("fromDateOriginal");
            String abreise = (String) session.getAttribute("untilDateOriginal");
            
            //Datum in das richtige Format umwandeln
            String ankunftE = ankunft.substring(0,2) + "/" + ankunft.substring(3,5) + "/" + ankunft.substring(6,10);
            String abreiseE = abreise.substring(0,2) + "/" + abreise.substring(3,5) + "/" + abreise.substring(6,10);
            
            Date ankunftDatum = new Date();
            Date abreiseDatum = new Date();
            
        try {
            ankunftDatum = new SimpleDateFormat("dd/MM/yyyy").parse(ankunftE);
            abreiseDatum = new SimpleDateFormat("dd/MM/yyyy").parse(abreiseE);
             
        } catch (ParseException ex) {
           //Parsing ist immer erfolgreich, da die eingegebenen Daten durch den Datepicker immer das richtige Format haben
        }
            
        String personen = (String) session.getAttribute("persons");
        int personenInt = Integer.parseInt(personen);
        
        //Datensatz der Buchung in Datenbank speichern 
        this.bookingBean.createNewBooking(hotel, usr, ankunftDatum, abreiseDatum  ,personenInt, false);
        
        //Danach Weiterleitung zum AfterConfirmServlet
        response.sendRedirect(request.getContextPath() + AfterConfirmServlet.URL);
    }
}
