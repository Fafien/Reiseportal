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
import reiseportal.ejb.HotelBean;

/**
 *
 * @author belizbalim
 */
@WebServlet(name = "HotelAdministrationServlet", urlPatterns = {"/hoteladministration"})
public class HotelAdministrationServlet extends HttpServlet {

   
     
    @EJB
    HotelBean hotelbean;
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         request.getRequestDispatcher("/WEB-INF/hoteladministration.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        //Fehlermeldungen TODO
        //if(request.getParameter("formtype").equals("createhotel"))
       // request.getRequestDispatcher("/WEB-INF/.jsp").forward(request, response);
        
        //request.getParameter("")
        //hotelbean.createNewHotel(hotelname, ort, 0, 0, 0, 0)createNewHotel(String hotelname, String ort, int preisProNacht, int anzahlZimmer, int sterne, int entfernung)
    }

    
    
    
    
    
    
    
}
