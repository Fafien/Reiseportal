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
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.HotelBean;
import reiseportal.jpa.Hotel;

/**
 *
 * @author Fabian Hupe
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {

    public static final String URL = "/index.html";
        
    @EJB
    HotelBean hotelbean;
        
    List<Hotel> hotellist;
    HttpSession session;
    String error = "";
    Date von;
    Date bis;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Daten aus der Session auslesen & an die JSP weitergeben
        session = request.getSession();
        request.setAttribute("errors", session.getAttribute("errors"));
        session.removeAttribute("filter");
        session.removeAttribute("errors");
        request.setAttribute("fromDate", session.getAttribute("fromDateOriginal"));
        request.setAttribute("untilDate", session.getAttribute("untilDateOriginal"));
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        //Suchdaten in der Session speichern
        session.setAttribute("location", request.getParameter("location").trim());
        session.setAttribute("fromDateOriginal", request.getParameter("fromDate"));
        session.setAttribute("untilDateOriginal", request.getParameter("untilDate"));
        session.setAttribute("persons", request.getParameter("persons").trim());
        
        //wenn ein Feld nicht gefüllt, dann Fehler ausgeben
        if(request.getParameter("fromDate").trim().isEmpty() || request.getParameter("location").trim().isEmpty() || request.getParameter("untilDate").trim().isEmpty() || request.getParameter("persons").trim().isEmpty()) {
            error = "Bitte geben sie gültige Daten ein";
            session.setAttribute("errors", error);
            response.sendRedirect(request.getContextPath() + IndexServlet.URL);
        } else {
            //Datumsformat umwandeln
            String vonDatum = request.getParameter("fromDate");
            String bisDatum = request.getParameter("untilDate");
            von = WebUtils.parseDate(vonDatum);
            bis = WebUtils.parseDate(bisDatum);
            if (von == null || bis == null) {
                error = "Das Datum muss dem Format dd.mm.yyyy entsprechen.";
                session.setAttribute("errors", error);
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);
                return;
            }
        
            session.setAttribute("fromDate", von);
            session.setAttribute("untilDate", bis);
            
            //passende Hotels suchen und speichern
            //default-Sortierung: Preis
            hotellist = hotelbean.findHotelsByInputOrderByPreis(request.getParameter("location").trim(), von, bis, request.getParameter("persons").trim());
            session.setAttribute("PreisSelected", "selected");
            session.setAttribute("EntfernungSelected", "");
            session.setAttribute("BewertungSelected", "");
            
            //Fehler ausgeben, wenn keine Hotels mit gewünschten Daten verfügbar
            if(hotellist.isEmpty()) {
                error = "Zu ihren Suchdaten gibt es keine passenden Ergebnisse";
                session.setAttribute("errors", error);
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            } else {
                error = "";
                session.setAttribute("errors", error);
                //Weitergabe der hotellist & Weiterleitung auf Selection-Servlet
                session.setAttribute("hotels", hotellist);
                response.sendRedirect(request.getContextPath() + SelectionServlet.URL);
            }
        }
    }
}
