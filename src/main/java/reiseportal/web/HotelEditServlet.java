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
    boolean delete = false;
    
    ArrayList <String> error;
   
  
    @EJB
    HotelBean hotelbean;
   
    
  
   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        session = request.getSession();  
        foundhotel = (Hotel) session.getAttribute("foundhotel");
        
        // Anzeige der Attribute der gefundenen Hotel & ggf. Fehlermeldungen
        request.setAttribute("hotelname", foundhotel.getHotelname());
        request.setAttribute("ort", foundhotel.getOrt());
        request.setAttribute("preisProNacht", foundhotel.getPreisProNacht());
        request.setAttribute("anzahlZimmer", foundhotel.getAnzahlZimmer());
        request.setAttribute("sterne", foundhotel.getSterne());
        request.setAttribute("anzahlZimmer", foundhotel.getEntfernung());
        request.setAttribute("disabled", disabled);
        request.setAttribute ("delete", delete);
        
        if (error != null) {
            request.setAttribute("error", error);
        }
        
        request.getRequestDispatcher("/WEB-INF/edithotel.jsp").forward(request, response);
    } 
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       //foundhotel = (Hotel) session.getAttribute("foundhotel");
       error = new ArrayList <String> ();
       
   
       
       //Ermittlung auf welches Button geklickt wurde
        switch(request.getParameter("button")){
            
            //Bei Bearbeitung die Input Felder unsperren
            case "bearbeiten":
               disabled = false;
               delete = false;
               response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
               break;
            
            /*Die eingegebenen Werte überprüfen, ggf. Fehlermeldungen anzeigen.
               Wenn keine Fehlermeldung vorhanden ist, das Hotel in Datenbank aktualiseren*/  
               
            case "speichern":
                delete = false;
                //Einlesen der Formulareingaben
                String hotelname = request.getParameter("hotelname");
                String ort = request.getParameter("ort"); 
                String preisProNacht = request.getParameter("preisProNacht");   
                String anzahlZimmer =  request.getParameter("anzahlZimmer");  
                String sterne = request.getParameter("sterne");   
                String entfernung = request.getParameter("entfernung");
                
                int ppn;
                int az;
                int st;
                int ent;
                
                //Prüfung ob alle Felder belegt sind & ob für die Felder außer Hotelname und Ort nur Nummer eingeben wurde
                if (hotelname.isEmpty()) {
                    error.add("Bitte geben Sie ein Hotelname ein");
                }
                else {
                   foundhotel.setHotelname(hotelname);
                } 
                if (ort.isEmpty()) {
                    error.add("Bitte geben Sie ein Ort ein");
                }
                
                else {
                   foundhotel.setOrt(ort);
                }
                try {
                    ppn = Integer.parseInt(preisProNacht.trim());
                    foundhotel.setPreisProNacht(ppn);
                }
                    catch (NumberFormatException nfe) {
                        error.add ("Bitte geben Sie eine Nummer für den Preis pro Nacht ein");
                    }
                try {
                     az = Integer.parseInt(anzahlZimmer.trim());
                     foundhotel.setAnzahlZimmer(az);
                     }
                    catch (NumberFormatException nfe) {
                        error.add("Bitte geben Sie eine Nummer für den Anzahl der Zimmer ein");
                    }
                   
                try {
                        st = Integer.parseInt(sterne.trim());
                         foundhotel.setSterne(st);
                    }
                    catch (NumberFormatException nfe) {
                        error.add("Bitte geben Sie eine Nummer für die Sterne ein");
                    }
                try {
                        ent = Integer.parseInt(entfernung.trim());
                        foundhotel.setEntfernung(ent);
                    }
                    catch (NumberFormatException nfe) {
                        error.add("Bitte geben Sie eine Nummer für die Entfernung ein");
                    }
                
                if (error.isEmpty()) {
                    disabled = true;
                    foundhotel = hotelbean.updateHotel(foundhotel);  
                }
                session.setAttribute("foundhotel", foundhotel);
                response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
           break;
           
           //Zurück zur Suche
            case "zuruck":
                disabled = true;
                delete = false;
                response.sendRedirect(request.getContextPath() + HotelAdministrationServlet.URL);
                break;
                
            //Das Hotel von der Datenbank löschen. Vor dem Löschen noch mal fragen, ob der Anwender wirklich das Hotel löschen will.   
            case "loeschen":
               disabled = true;
               delete = true;
               response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
               break;
            case "loeschenja":
                disabled = true;
                delete = false;
                hotelbean.deleteHotel(foundhotel.getId());
                response.sendRedirect(request.getContextPath() + HotelAdministrationServlet.URL);
                break;
            case "loeschennein":
                delete = false;
                response.sendRedirect(request.getContextPath() + HotelEditServlet.URL);
                break;
               
               
           
                
        }
    
    }  
    
}
