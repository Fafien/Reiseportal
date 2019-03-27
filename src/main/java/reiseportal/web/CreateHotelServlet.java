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
import reiseportal.jpa.Useraccount;

/**
 * 
 * @author belizbalim
 * 
 * Diese Klasse regelt die Hotelanlage. Der Admin kann ein neues Hotel anlegen. 
 */
@WebServlet(name="CreateHotelServlet", urlPatterns = {"/createhotel"})
public class CreateHotelServlet extends HttpServlet {
    
    public static final String URL = "/createhotel";
    
    @EJB
    HotelBean hotelbean;
    
    HttpSession session;
    ArrayList <String> error;
   
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Wenn der angemeldete User kein Admin ist, wird er zu der Index-Seite geleitet.
       session = request.getSession();
        
       try{
            Useraccount usr = (Useraccount) session.getAttribute("usr");
            if(!usr.isAdmn()){
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
        }catch(NullPointerException e){
            
        }
       
        /*Wenn der Benutzer das Form schon einmal mit unerlaubten Werten gepostet hat, 
          werden die schon eingegebenen und gemerkten Werten angezeigt*/
      
      if (hotelname!= null){
          request.setAttribute("hotelname", this.hotelname);
      }
      if (ort != null){
          request.setAttribute("ort", this.ort);
      }
      if (preisProNacht!= null){
          request.setAttribute("preisProNacht", this.preisProNacht);
      }
      if (anzahlZimmer!= null){
          request.setAttribute("anzahlZimmer", this.anzahlZimmer);
      }
      if (sterne!= null){
          request.setAttribute("sterne", this.sterne);
      }
      if (entfernung!= null){
          request.setAttribute("entfernung", this.entfernung);
      }
      if (error!= null){
          request.setAttribute("error", this.error);
      }
   
    request.getRequestDispatcher("/WEB-INF/createhotel.jsp").forward(request, response); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
       /*Einzelne Felder des Formulars werden gelesen und überprüft, 
       ggf. die entsprechende Fehlermedungen werden angezeigt.*/
       
       error = new ArrayList<String> ();
       
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
            response.sendRedirect(request.getContextPath() + CreateHotelServlet.URL);
        }
        else {
            //Wenn die Prüfung ohne Fehler abgewickelt wird, wird das Hotel erzeugt. 
            hotelbean.createNewHotel(hotelname, ort, ppn, az, st, ent);
            response.sendRedirect(request.getContextPath() + HotelAdministrationServlet.URL);
        }   
           
    }
}