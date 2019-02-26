/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.ejb;

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
    
    public Hotel createNewHotel(String hotelname, String ort, int preisProNacht, int anzahlZimmer, int sterne, int entfernung) {
        Hotel hotel = new Hotel(hotelname, ort, preisProNacht, anzahlZimmer, sterne, entfernung);
        em.persist(hotel);
        return em.merge(hotel);
    }
    
    
}
