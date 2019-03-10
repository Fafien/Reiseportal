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
import reiseportal.jpa.Hotel;

/**
 *
 * @author jonas
 */
@Stateless
public class HotelBean {
    
    @PersistenceContext
    protected EntityManager em;
     
    public Hotel findHotelById(Long id){
        if (id == null) {
            return null;
        }
        return em.find(Hotel.class, id);
    }
    
    public List<Hotel> findHotelsByInputOrderByPreis(String location, Date from, Date until, String persons) {
        return em.createQuery("SELECT h FROM Hotel h WHERE h.ort LIKE :ort ORDER BY h.preisProNacht")
                .setParameter("ort", location)
//        int person = Integer.parseInt(persons);
//        location = "%" + location + "%";
//        return em.createQuery(  "SELECT h "
//                                + "FROM Hotel h "
//                                + "WHERE h.id NOT IN ("
//                                    + "SELECT help.hotelId "
//                                    + "FROM ( "
//                                        + "SELECT h2.id AS hotelId, SUM(b.personenanzahl) AS Personenanzahl, h2.anzahlZimmer AS anzahlzimmer "
//                                        + "FROM Hotel h2, Booking b "
//                                            + "WHERE h2 = b.hotelId "
//                                            + "AND h2.ort LIKE :ort "
//                                            + "AND b.ausreise >= :von "
//                                            + "AND b.ankunft <= :bis "
//                                            + "GROUP BY h2.id, h2.anzahlZimmer "
//                                        + ") help "
//                                        + "WHERE ((help.anzahlzimmer*2) - help.Personenanzahl) < :persons "
//                                    + ") "
//                                + "ORDER BY h.preisProNacht", Hotel.class)
//                .setParameter("ort", location)
//                .setParameter("von", from)
//                .setParameter("bis", until)
//                .setParameter("persons", person)
                .getResultList();
    }
    
    public List<Hotel> findHotelsByInputOrderByEntfernung(String location, Date from, Date until, String persons){
        return em.createQuery("SELECT h FROM Hotel h WHERE h.ort LIKE :ort ORDER BY h.entfernung")
                .setParameter("ort", location)
//                TODO -> mit Buchungstabelle joinen
//                .setParameter("von", from)
//                .setParameter("bis", until)
//                .setParameter("personen", persons)
                .getResultList();
    }
    
    public List<Hotel> findHotelsByInputOrderByBewertung(String location, Date from, Date until, String persons){
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
