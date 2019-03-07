/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jonas
 */
@Entity
public class Hotelausstattung implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Hotel hotel = null;

    private Ausstattung ausstattung = null;
    private int anzahl = 0;
    
    public Hotelausstattung(){
    }
    
    public Hotelausstattung(Hotel hotel, Ausstattung ausstattung, int anzahl) {
        this.hotel = hotel;
        this.ausstattung = ausstattung;
        this.anzahl = anzahl;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Ausstattung getAusstattung() {
        return ausstattung;
    }
    
    public int getAnzahl() {
        return anzahl;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setAusstattung(Ausstattung ausstattung) {
        this.ausstattung = ausstattung;
    }
    
    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
}
