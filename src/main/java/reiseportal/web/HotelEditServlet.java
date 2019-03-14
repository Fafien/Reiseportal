/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.util.ArrayList;
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
    
    ArrayList <String> error;
   
  
    @EJB
    HotelBean hotelbean;
   
    /*Eingegebene Variablen gespeichert, für die Vorbelegung des Formulars*/
    String hotelname;
    String ort;
    String preisProNacht;
    String anzahlZimmer;
    String sterne;
    String entfernung;
    
    //Hotelattribute nach dem Überprüfung und Konvertierung
    // ppn = preisProNacht, az = anzahlZimmer...
    int ppn;
    int az;
    int st;
    int ent;
  
   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();  
        foundhotel = (Hotel) session.getAttribute("foundhotel");
        
        request.setAttribute("hotelname", foundhotel.getHotelname());
        request.setAttribute("ort", foundhotel.getOrt());
        request.setAttribute("preisProNacht", foundhotel.getPreisProNacht());
        request.setAttribute("anzahlZimmer", foundhotel.getAnzahlZimmer());
        request.setAttribute("sterne", foundhotel.getSterne());
        request.setAttribute("anzahlZimmer", foundhotel.getEntfernung());
        
        request.setAttribute("disabled", disabled);
        request.setAttribute("error", error);
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
                error = new ArrayList <String> ();
                
                //Einlesen der Formulareingaben
                hotelname = request.getParameter("hotelname");
                ort = request.getParameter("ort"); 
                preisProNacht = request.getParameter("preisProNacht");   
                anzahlZimmer =  request.getParameter("anzahlZimmer");  
                sterne = request.getParameter("sterne");   
                entfernung = request.getParameter("entfernung");
                
                //Prüfung ob alle Felder belegt sind & ob für die Felder außer Hotelname und Ort nur Nummer eingeben wurde
                if (hotelname.isEmpty()) {
                    error.add("Bitte geben Sie ein Hotelname ein");
                }
                if (ort.isEmpty()) {
                    error.add("Bitte geben Sie ein Ort ein");
                }
                if (!hotelbean.findHotelByNameAndPlace(hotelname, ort).isEmpty()) {
                    error.add("Ein Hotel mit dem gleichen Namen und Ort schon vorhanden");
                }
        
                else {
                    try {
                        ppn = Integer.parseInt(preisProNacht.trim());
                    }
                    catch (NumberFormatException nfe) {
                        preisProNacht = null;
                        error.add ("Bitte geben Sie eine Nummer für den Preis pro Nacht ein");
                    }   
                    try {
                        az = Integer.parseInt(anzahlZimmer.trim());
                     }
                    catch (NumberFormatException nfe) {
                        anzahlZimmer = null;
                        error.add("Bitte geben Sie eine Nummer für den Anzahl der Zimmer ein");
                    }
                    try {
                        st = Integer.parseInt(sterne.trim());
                    }
                    catch (NumberFormatException nfe) {
                        sterne= null;
                        error.add("Bitte geben Sie eine Nummer für die Sterne ein");
                    }
                    try {
                        ent = Integer.parseInt(entfernung.trim());
                    }
                    catch (NumberFormatException nfe) {
                        entfernung = null;
                        error.add("Bitte geben Sie eine Nummer für die Entfernung ein");
                    }
                }
                if (!error.isEmpty()) {  
                }
                else {
                    disabled = true;
                    Hotel hotel = new Hotel (hotelname, ort, ppn, az, st, ent);
                    foundhotel = hotelbean.updateHotel(hotel);
                    session.setAttribute("foundhotel", foundhotel);
                } 
                response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
           break;
            
           case "loeschen":
                disabled = true;
                hotelbean.deleteHotel(foundhotel.getId());
                response.sendRedirect(request.getContextPath() + HotelAdministrationServlet.URL);
                break;
           
                
        }
    
    }  
    
}
