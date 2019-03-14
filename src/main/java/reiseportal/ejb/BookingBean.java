/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import reiseportal.jpa.Booking;
import reiseportal.jpa.Hotel;
import reiseportal.jpa.Useraccount;

/**
 *
 * @author Marwa Alqataa
 */
@Stateless
public class BookingBean {
    
    @PersistenceContext
    protected EntityManager em;
    
    public Booking createNewBooking(Hotel hotel, Useraccount user, Date ankunft, Date ausreise, int personenanzahl, boolean cancel ){
        Booking booking = new Booking(hotel, user, ankunft, ausreise, personenanzahl, cancel);
        em.persist(booking);
        return em.merge(booking);
    }
    
     public Booking findById(long id) {
        return em.find(Booking.class, id);
    }
 
    public List<Booking> findBookingByUseraccount(Useraccount useraccount){
        return em.createQuery("SELECT b FROM Booking b " + " WHERE b.useraccount = :useraccount ")
                .setParameter("useraccount", useraccount)
                .getResultList();
    }
    
   public Booking updateBooking(Booking booking) {
        return em.merge(booking);
    }
    
    public void deleteBooking(Booking booking) {
        
        em.remove(booking);
    }
    
}
