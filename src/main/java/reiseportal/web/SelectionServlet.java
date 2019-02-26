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
import reiseportal.ejb.HotelBean;
import reiseportal.jpa.Hotel;

/**
 *
 * @author jonas
 */
@WebServlet(name = "Selection", urlPatterns = {"/selection"})
public class SelectionServlet extends HttpServlet {
    public static final String URL = "/selection.html";
    
    @EJB
    HotelBean hotelbean;
    
    List<Hotel> hotellist;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/selection.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        hotellist = this.hotelbean.findHotels(request.getParameter("location"));
        
        response.sendRedirect(request.getContextPath() + OverviewServlet.URL);
        
    }
}
