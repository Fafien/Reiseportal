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
import reiseportal.jpa.Hotel;


/**
 *
 * @author belizbalim
 */
@WebServlet(name = "HotelAdministrationServlet", urlPatterns = {"/hoteladministration"})
public class HotelAdministrationServlet extends HttpServlet {

   public static final String URL = "/hoteladministration";
     
    @EJB
    HotelBean hotelbean;
    
    HttpSession session;
    
  
    List<Hotel> hotellist;
    String hotelname;
    String ort;
    String error;
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        
        /*try{
            session.getAttribute("usr");           
        }catch(NullPointerException e){
            //Kann ignoriert werden das dies nur als Bestätigung verwendet wird, das man nicht eingeloggt ist.
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }*/
        
         if(hotelname!=null){
            request.setAttribute("hotelname",hotelname);
        }
        if(ort!=null){
            request.setAttribute("ort",ort);
        }
        if(error!=null){
            request.setAttribute("error",error);
        }
        request.getRequestDispatcher("/WEB-INF/hoteladministration.jsp").forward(request, response);
   }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        /* Wenn der Benutzer ein neues Hotel anlegen wollte, wird er zu dem Hotelanlage-Formular weitergeleitet 
        Wenn der Benutzer das Feld Name oder Ort einfüllt und die Suche startet, wird aus der Datenbank 
        der entsprechende Datensatz gefunden und angezeigt. Wenn kein Datensatz gefunden wurde, wird Fehler angezeigt.
        */
        
        switch(request.getParameter("button")){
            
            //Neues Hotelanlage
            case "neu":
               response.sendRedirect(request.getContextPath() + CreateHotelServlet.URL);
               break;
               
            //Hotelsuche   
            case "suche":
               hotelname = request.getParameter("hotelname");
               ort = request.getParameter("ort");
               hotellist = hotelbean.findHotelByNameOrPlace(hotelname, ort);
               
               if (hotellist.isEmpty()) {
                    error = "Kein Hotel gefunden";
                    request.setAttribute("error", error);
                    request.setAttribute("hotelname", hotelname);
                    request.setAttribute("ort", ort);
                    response.sendRedirect(request.getContextPath() + this.URL);
                }
               
               else {
                    session.setAttribute ("foundhotel", hotellist.get(0));
                     response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
                 }
               
               break;
       
    }
    }
    
    }

