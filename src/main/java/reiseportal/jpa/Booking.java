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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marwa Alqataa
 */
@Entity
public class Booking implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;
    
    @ManyToOne
    private Hotel hotel = null;
    
    @ManyToOne
    private Useraccount userAccount = null;
    
    @Temporal(TemporalType.DATE)
    private Date ankunft= new Date();
    
    @Temporal(TemporalType.DATE)
    private Date ausreise= new Date();
    private int personenanzahl;
    private boolean cancel= false;
    
    
    public Booking(){
        
    }

    public Booking(Hotel hotel, Useraccount userAccount, Date ankunft, Date ausreise, int personenanzahl, boolean cancel) {
        this.hotel = hotel;
        this.userAccount = userAccount;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Useraccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Useraccount userAccount) {
        this.userAccount = userAccount;
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
