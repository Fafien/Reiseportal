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
    
    public Booking createNewBooking(Hotel hotelId, Useraccount userId, Date ankunft, Date ausreise, int personenanzahl, boolean cancel ){
        Booking booking = new Booking(hotelId, userId, ankunft, ausreise, personenanzahl, cancel);
        em.persist(booking);
        return em.merge(booking);
    }
    
     public Booking findById(long id) {
        return em.find(Booking.class, id);
    }
     
     // ich bin mir nicht sich, ob wir die wirklich brauchen werden 
    public List<Booking> findBookingByUserId(Long userId){
        return em.createQuery("SELECT b FROM Booking WHERE b.userID LIKE :userID ")
                .setParameter("userId", userId)
                .getResultList();
    }
    
   public Booking update(Booking booking) {
        return em.merge(booking);
    }
    
    public void delete(Booking booking) {
        em.remove(booking);
    }
    
    
    
   //muss ich die Methode zum Befüllen cancel-Felder hier schreiben 
   //if auf den Button Stornieren gedrückt wurde ist es "true" else immer "no"
}
