/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import reiseportal.jpa.Hotel;

/**
 *
 * @author jonas
 */
@Stateless
public class HotelBean {
    
    @PersistenceContext
    protected EntityManager em;
    
//    TODO
//    bei Hotelsuche auch die dazugehörigen Ausstattungen anzeigen    
    public Hotel findHotelById(Long id){
        if (id == null) {
            return null;
        }
        return em.find(Hotel.class, id);
    }
    
    public List<Hotel> findHotelByNameOrPlace (String hotelname, String ort) {
         return em.createQuery("SELECT h FROM Hotel h WHERE h.hotelname = :hotelname OR h.ort = :ort")
                .setParameter("hotelname", hotelname)
                .setParameter("ort", ort)
                .getResultList();
    }
    
    public List<Hotel> findHotelsByInputOrderByPreis(String location, String from, String until, String persons){
        return em.createQuery("SELECT h FROM Hotel h WHERE h.ort LIKE :ort ORDER BY h.preisProNacht")
                .setParameter("ort", location)
//                TODO -> mit Buchungstabelle joinen
//                .setParameter("von", from)
//                .setParameter("bis", until)
//                .setParameter("personen", persons)
                .getResultList();
    }
    
    public List<Hotel> findHotelsByInputOrderByEntfernung(String location, String from, String until, String persons){
        return em.createQuery("SELECT h FROM Hotel h WHERE h.ort LIKE :ort ORDER BY h.entfernung")
                .setParameter("ort", location)
//                TODO -> mit Buchungstabelle joinen
//                .setParameter("von", from)
//                .setParameter("bis", until)
//                .setParameter("personen", persons)
                .getResultList();
    }
    
    public List<Hotel> findHotelsByInputOrderByBewertung(String location, String from, String until, String persons){
        return em.createQuery("SELECT h FROM Hotel h WHERE h.ort LIKE :ort ORDER BY h.sterne")
                .setParameter("ort", location)
//                TODO -> mit Buchungstabelle joinen
//                .setParameter("von", from)
//                .setParameter("bis", until)
//                .setParameter("personen", persons)
                .getResultList();
    }
    
    public Hotel createNewHotel(String hotelname, String ort, int preisProNacht, int anzahlZimmer, int sterne, int entfernung) {
        Hotel hotel = new Hotel(hotelname, ort, preisProNacht, anzahlZimmer, sterne, entfernung);
        em.persist(hotel);
        return em.merge(hotel);
    }
        
    public Hotel deleteHotel(long id) {
        Hotel hotel = em.find(Hotel.class, id);
        
        if (hotel != null) {
            em.remove(hotel);
        }
        
        return hotel;
    }
    
}
