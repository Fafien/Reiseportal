/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import reiseportal.jpa.Ausstattung;
import reiseportal.jpa.Filter;
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
    Hotel hotel;
    HttpSession session;
    String error = "";
    Ausstattung[] facilities = Ausstattung.values();
    Filter[] facilitiesLabel;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        if(facilitiesLabel == null || facilitiesLabel.length == 0) {
            int i = 0;
            facilitiesLabel = new Filter[facilities.length];
            while(i < facilities.length) {
                Filter fil = new Filter();
                fil.setFilterLabel(facilities[i].getLabel());
                fil.setFilterChecked("");
                facilitiesLabel[i] = fil;
                i++;
            }
        }
        
        request.setAttribute("filterLabel", facilitiesLabel);
        request.setAttribute("hotellist", session.getAttribute("hotels"));
        request.setAttribute("PreisSelected", session.getAttribute("PreisSelected"));
        request.setAttribute("EntfernungSelected", session.getAttribute("EntfernungSelected"));
        request.setAttribute("BewertungSelected", session.getAttribute("BewertungSelected"));
        request.getRequestDispatcher("/WEB-INF/selection.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String requestButton = request.getParameter("button");
        
        if(requestButton.equals("Anwenden")) {
            String location = (String) session.getAttribute("location");
            Date from = (Date) session.getAttribute("fromDate");
            Date until = (Date) session.getAttribute("untilDate");
            String persons = (String) session.getAttribute("persons");
            
            String sort = request.getParameter("sorting");
            facilitiesLabel = new Filter[facilities.length];
            
            switch(sort) {
                case"Preis":
                    hotellist = hotelbean.findHotelsByInputOrderByPreis(location, from, until, persons);
                    session.setAttribute("PreisSelected", "selected");
                    session.setAttribute("EntfernungSelected", "");
                    session.setAttribute("BewertungSelected", "");
                    break;
                case "Entfernung":
                    hotellist = hotelbean.findHotelsByInputOrderByEntfernung(location, from, until, persons);
                    session.setAttribute("PreisSelected", "");
                    session.setAttribute("EntfernungSelected", "selected");
                    session.setAttribute("BewertungSelected", "");
                    break;
                case "Bewertung":
                    hotellist = hotelbean.findHotelsByInputOrderByBewertung(location, from, until, persons);
                    session.setAttribute("PreisSelected", "");
                    session.setAttribute("EntfernungSelected", "");
                    session.setAttribute("BewertungSelected", "selected");
                    break;
            }
            
            int i = 0;
            while(i < facilities.length) {
                Filter fil = new Filter();
                fil.setFilterLabel(facilities[i].getLabel());
                fil.setFilterChecked("");
                facilitiesLabel[i] = fil;
                i++;
            }
            List<String> requiredFacilities = new ArrayList<>();
            int j = 0;
            while(j < facilities.length) {
                if(request.getParameter(facilitiesLabel[j].getFilterLabel()) == null) {
                    facilitiesLabel[j].setFilterChecked("");
                } else {
                    requiredFacilities.add(facilities[j].toString());
                    facilitiesLabel[j].setFilterChecked("checked");
                }
                j++;
            }
            
            List<Hotel> hotellist2 = new ArrayList<>();
            hotellist2.addAll(hotellist);
            Iterator<Hotel> iter = hotellist2.listIterator();
            while(iter.hasNext()) {
                Hotel h = iter.next();
                int found = 0;
                List<Hotelausstattung> hotelausstattung = hotausbean.findHotelausstattungByHotel(h);
                for(Hotelausstattung ha : hotelausstattung) {
                    String help = ha.getAusstattung().toString();
                    for(String s : requiredFacilities) {
                        if(s.equals(help)) {
                            found++;
                        }
                    }
                }
                if(found != requiredFacilities.size()) {
                    iter.remove();
                }
            }
            
            if(hotellist2.isEmpty()) {
                error = "Für die gewählten Filtern gibt es keine passenden Ergebnisse";
                session.setAttribute("errors", error);
                facilitiesLabel = null;
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            } else {
                error = "";
                session.setAttribute("errors", error);
                session.setAttribute("hotels", hotellist2);
                session.setAttribute("filter", facilitiesLabel);
                response.sendRedirect(request.getContextPath() + SelectionServlet.URL);
            }
        } else {
            Long id = Long.parseLong(requestButton);
            hotel = hotelbean.findHotelById(id);
            List<Hotelausstattung> hotelaus = hotausbean.findHotelausstattungByHotel(hotel);
        
            session.setAttribute("viewHotel", hotel);
            session.setAttribute("HotelAusstattung", hotelaus);
        
            response.sendRedirect(request.getContextPath() + OverviewServlet.URL);
        }
    }
}
