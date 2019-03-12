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
 * @author belizbalim
 */
@WebServlet(name = "HotelEditServlet", urlPatterns = {"/edithotel"})
public class HotelEditServlet extends HttpServlet {
    
    public static final String URL = "/edithotel";
    
    HttpSession session;
    Useraccount usr;
    Hotel foundhotel;
    
    boolean disabled = true;
  
    @EJB
    HotelBean hotelbean;
  
   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();  
        foundhotel = (Hotel) session.getAttribute("foundhotel");
        
        request.setAttribute("foundhotel", foundhotel);
        request.setAttribute("disabled", disabled);
        request.getRequestDispatcher("/WEB-INF/edithotel.jsp").forward(request, response);
    } 
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       foundhotel = (Hotel) session.getAttribute("foundhotel");
        
        switch(request.getParameter("button")){
            case "bearbeiten":
               disabled = false;
               response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
               break;
            case "speichern":
                disabled = true;
                //TODO speichern in DB
                response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
            case "loeschen":
                hotelbean.deleteHotel(foundhotel.getId());
                response.sendRedirect(request.getContextPath() + HotelAdministrationServlet.URL);
                break;
        }
    
    }  
    
}
