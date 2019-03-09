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
import reiseportal.ejb.HotelausstattungBean;
import reiseportal.jpa.Hotel;
import reiseportal.jpa.Hotelausstattung;

/**
 *
 * @author jonas
 */
@WebServlet(name = "Selection", urlPatterns = {"/selection"})
public class SelectionServlet extends HttpServlet {
    
    public static final String URL = "/selection";
    
    @EJB
    HotelBean hotelbean;
    @EJB
    HotelausstattungBean hotausbean;
    
    List<Hotel> hotellist;
    List<String> sortlist;
    Hotel hotel;
    HttpSession session;
    String error = new String();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        request.setAttribute("hotellist", session.getAttribute("hotels"));
        request.getRequestDispatcher("/WEB-INF/selection.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        String anwenden = request.getParameter("button1");
//        String sort = request.getParameter("sorting");
        String str = request.getParameter("button");
        
        if(str.equals("Anwenden")) {
            String location = (String) session.getAttribute("location");
            String from = (String) session.getAttribute("fromDate");
            String until = (String) session.getAttribute("untilDate");
            String persons = (String) session.getAttribute("persons");
            //hotellist.clear();
            
            String sort = request.getParameter("sorting");
            
            switch(sort) {
                case"Preis":
                    hotellist = hotelbean.findHotelsByInputOrderByPreis(location, from, until, persons);
                    break;
                case "Entfernung":
                    hotellist = hotelbean.findHotelsByInputOrderByEntfernung(location, from, until, persons);
                    break;
                case "Bewertung":
                    hotellist = hotelbean.findHotelsByInputOrderByBewertung(location, from, until, persons);
                    break;
            }
            
            if(hotellist.isEmpty()) {
                error = "Zu ihren Suchdaten gibt es keine passenden Ergebnisse";
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            } else {
                error = "";
                session.setAttribute("hotels", hotellist);
                response.sendRedirect(request.getContextPath() + SelectionServlet.URL);
            }
        } else {
            Long id = Long.parseLong(str);
            hotel = hotelbean.findHotelById(id);
            List<Hotelausstattung> hotelaus = hotausbean.findHotelausstattungByHotel(hotel);
        
            session.setAttribute("viewHotel", hotel);
            session.setAttribute("HotelAusstattung", hotelaus);
        
            response.sendRedirect(request.getContextPath() + OverviewServlet.URL);
        }
    }
}
