/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Fabian Hupe
 */
@Entity
public class Booking implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;
    
    @ManyToOne
    private Hotel hotelId = null;
    
    @ManyToOne
    private Useraccount userId = null;
    
    private Date ankunft;
    private Date ausreise;
    private int personenanzahl;
    private boolean cancel;

    public Booking(Hotel hotelId,Useraccount userId, Date ankunft, Date ausreise, int personenanzahl, boolean cancel) {
        this.hotelId = hotelId;
        this.userId = userId;
        this.ankunft = ankunft;
        this.ausreise = ausreise;
        this.personenanzahl = personenanzahl;
        this.cancel = cancel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public Useraccount getUserId() {
        return userId;
    }

    public void setUserId(Useraccount userId) {
        this.userId = userId;
    }

    public Date getAnkunft() {
        return ankunft;
    }

    public void setAnkunft(Date ankunft) {
        this.ankunft = ankunft;
    }

    public Date getAusreise() {
        return ausreise;
    }

    public void setAusreise(Date ausreise) {
        this.ausreise = ausreise;
    }

    public int getPersonenanzahl() {
        return personenanzahl;
    }

    public void setPersonenanzahl(int personenanzahl) {
        this.personenanzahl = personenanzahl;
    }
    
    
    
    
    
    
    
    
    
}
