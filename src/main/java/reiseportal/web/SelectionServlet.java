/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
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
 * @author jonas
 */
@WebServlet(name = "Selection", urlPatterns = {"/selection"})
public class SelectionServlet extends HttpServlet {
    
    public static final String URL = "/selection";
    
    @EJB
    HotelBean hotelbean;
    
    List<Hotel> hotellist;
    HttpSession session;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        String ort = (String) session.getAttribute("location");
        Date from = (Date) session.getAttribute("fromDate");
        Date until = (Date) session.getAttribute("untilDate");
        int person = (int) session.getAttribute("persons");
        
        //TODO
        //alle Hotels mit den session-Daten finden & anzeigen
        //wenn die Liste leer ist, soll eine Fehlermeldung angezeigt werden & Weiterleitung auf index.html
        //hotellist = new ArrayList<Hotel>();
        hotellist = hotelbean.findHotels(ort);
        
        request.getRequestDispatcher("/WEB-INF/selection.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        switch (request.getParameter("button"))
//            case "hotel1":
        session.setAttribute("viewHotel", request.getParameter("buttonOverview"));
        
        response.sendRedirect(request.getContextPath() + OverviewServlet.URL);
    }
}
