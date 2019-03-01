/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.HotelBean;
import reiseportal.jpa.Useraccount;
import reiseportal.jpa.Hotel;

/**
 *
 * @author belizbalim
 */
@WebServlet(name="CreateHotelServlet", urlPatterns = {"/createhotel"})
public class CreateHotelServlet extends HttpServlet {
    
    public static final String URL = "/createhotel";
    
    @EJB
    HotelBean hotelbean;
    
   
    //HttpSession session;
    String error;
   
    Hotel hotel;
    /*String hotelname;
    String ort;
    String preisProNacht;
    String anzahlZimmer;
    String sterne;
    String entfernung;
    */
    
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //session = request.getSession();
        /*try{
            if(!session.getAttribute("usr").admn == true){
                request.getRequestDispatcher("/WEB-INF/createhotel.jsp").forward(request, response);
            }
        }catch(NullPointerException e){
            
        }
        */
       if (hotel != null) { 
       request.setAttribute("hotelname", hotel.getHotelname());
       request.setAttribute("ort", hotel.getOrt());
       request.setAttribute("preisProNacht", hotel.getPreisProNacht());
       request.setAttribute("anzahlZimmer", hotel.getPreisProNacht());
       request.setAttribute("sterne", hotel.getSterne());
       request.setAttribute("entfernung", hotel.getEntfernung());
       request.setAttribute("error", error);
       }
      
       request.getRequestDispatcher("/WEB-INF/createhotel.jsp").forward(request, response); 
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
       String hotelname = request.getParameter("hotelname");
       String ort = request.getParameter("ort");
        
       String preisProNacht = request.getParameter("preisProNacht");
        if (preisProNacht.isEmpty()) {
            preisProNacht = "0";
        }
        
       
        String anzahlZimmer =  request.getParameter("anzahlZimmer");
        if (anzahlZimmer.isEmpty()) {
            anzahlZimmer = "0";
        }
        
        String sterne = request.getParameter("sterne");
        if (sterne.isEmpty()) {
            sterne  = "0";
        }
            
        String entfernung = request.getParameter("entfernung");
        if (entfernung.isEmpty()) {
            entfernung = "0";
        }
        
                //TODO Exception beim parseInt!
        
        hotel = new Hotel (hotelname.trim(), ort.trim(), Integer.parseInt(preisProNacht.trim()), 
            Integer.parseInt(anzahlZimmer.trim()), Integer.parseInt(sterne.trim()), Integer.parseInt(entfernung.trim()));

        if (hotelname.isEmpty() || ort.isEmpty() || preisProNacht.equals("0") || 
                anzahlZimmer.equals("0")  || sterne.equals("0") || entfernung.equals("0")) {
            error = "Bitte alle Felder ausfüllen";
            response.sendRedirect(request.getContextPath() + this.URL);
        }
        else {
            hotelbean.createNewHotel(hotelname.trim(), ort.trim(), Integer.parseInt(preisProNacht.trim()), 
            Integer.parseInt(anzahlZimmer.trim()), Integer.parseInt(sterne.trim()), Integer.parseInt(entfernung.trim()));
            //response.sendRedirect("/");
        }
       
        

                
                    
                    
                  
                
            
            
        
        
        
       
    }
    
}
