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
    EntityManager em;
    
    public List<Hotel> findHotels(String ort){
        return em.createQuery("SELECT h FROM Hotel h WHERE h.ort LIKE :ort")
                .setParameter("ort", ort)
                .getResultList();
    }
    
    public Hotel createNewHotel(String hotelname, String ort, int preisProNacht, int anzahlZimmer, int sterne, int entfernung) {
        Hotel hotel = new Hotel(hotelname, ort, preisProNacht, anzahlZimmer, sterne, entfernung);
        em.persist(hotel);
        return em.merge(hotel);
    }
    
    public Hotel updateHotel(Hotel hotel){
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
