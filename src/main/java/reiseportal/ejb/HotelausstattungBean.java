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
import reiseportal.jpa.Hotelausstattung;

/**
 *
 * @author jonas
 */
@Stateless
public class HotelausstattungBean {
    
    @PersistenceContext
    protected EntityManager em;
    
    //returns a list of Hotelausstattung for a given hotel
    public List<Hotelausstattung> findHotelausstattungByHotel(Hotel hotel){
        return em.createQuery("SELECT ha FROM Hotelausstattung ha WHERE ha.hotel = :hotelid")
                .setParameter("hotelid", hotel)
                .getResultList();
    }
}
