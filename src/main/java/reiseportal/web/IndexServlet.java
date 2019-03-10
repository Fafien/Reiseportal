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
        
        session = request.getSession();
        request.setAttribute("errors", session.getAttribute("errors"));
        request.setAttribute("fromDate", session.getAttribute("fromDateOriginal"));
        request.setAttribute("untilDate", session.getAttribute("untilDateOriginal"));
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        String VonD = request.getParameter("fromDate");
        String BisD = request.getParameter("untilDate");
        
        String VonE = VonD.substring(0,2) + "/" + VonD.substring(3,5) + "/" + VonD.substring(6,10);
        String BisE = BisD.substring(0,2) + "/" + BisD.substring(3,5) + "/" + BisD.substring(6,10);
        
        try {
            von = new SimpleDateFormat("dd/MM/yyyy").parse(VonE);
        } catch (ParseException ex) {
            error = "Bitte geben sie gültige Daten ein";
            session.setAttribute("errors", error);
            response.sendRedirect(request.getContextPath() + IndexServlet.URL);
        }
        try {
            bis = new SimpleDateFormat("dd/MM/yyyy").parse(BisE);
        } catch (ParseException ex) {
            error = "Bitte geben sie gültige Daten ein";
            session.setAttribute("errors", error);
            response.sendRedirect(request.getContextPath() + IndexServlet.URL);
        }
        
        session.setAttribute("location", request.getParameter("location"));
        session.setAttribute("fromDateOriginal", request.getParameter("fromDate"));
        session.setAttribute("untilDateOriginal", request.getParameter("untilDate"));
        session.setAttribute("fromDate", von);
        session.setAttribute("untilDate", bis);
        session.setAttribute("persons", request.getParameter("persons"));
        
        if(!request.getParameter("fromDate").trim().isEmpty() && !request.getParameter("location").trim().isEmpty() && !request.getParameter("untilDate").trim().isEmpty() && !request.getParameter("persons").trim().isEmpty()) {
            
            hotellist = hotelbean.findHotelsByInputOrderByPreis(request.getParameter("location"), von, bis, request.getParameter("persons"));
            session.setAttribute("PreisSelected", "selected");
            session.setAttribute("EntfernungSelected", "");
            session.setAttribute("BewertungSelected", "");
            
            if(hotellist.isEmpty()) {
                error = "Zu ihren Suchdaten gibt es keine passenden Ergebnisse";
                session.setAttribute("errors", error);
                response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            } else {
                error = "";
                session.setAttribute("errors", error);
                session.setAttribute("hotels", hotellist);
                response.sendRedirect(request.getContextPath() + SelectionServlet.URL);
            }
        } else {
            error = "Bitte geben sie gültige Daten ein";
            session.setAttribute("errors", error);
            response.sendRedirect(request.getContextPath() + IndexServlet.URL);
        }
    }
}
