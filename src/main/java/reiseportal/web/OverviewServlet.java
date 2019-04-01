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
        int ankunftTag = Integer.parseInt(ankunft.substring(0,2));
        int ankunftMonat = Integer.parseInt(ankunft.substring(3,5));
        int ankunftJahr = Integer.parseInt(ankunft.substring(6,10));
        int abreisTag = Integer.parseInt(abreise.substring(0,2));
        int abreiseMonat = Integer.parseInt(abreise.substring(3,5));
        int abreiseJahr = Integer.parseInt(abreise.substring(6,10));           
        int gebuchteTage = Math.abs(abreisTag - ankunftTag);
        int gebuchteMonate =  Math.abs(abreiseMonat - ankunftMonat);
        int gebuchteJahre = Math.abs(abreiseJahr - ankunftJahr) ;
        int gesamteTage;
        
        if(gebuchteJahre == 0){
            if(gebuchteMonate == 0){
                gesamteTage = gebuchteTage;
            }else{
                gesamteTage = (gebuchteMonate - 1)*30 + gebuchteTage;
            }
        }else{
            if(gebuchteMonate == 0){
                gesamteTage = (gebuchteJahre) * 356 + gebuchteTage;
            }else{
            gesamteTage = (gebuchteJahre - 1) * 356 +(gebuchteMonate - 1)*30 + gebuchteTage;
        }
        }
            
        int preis = hotel.getPreisProNacht();
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
