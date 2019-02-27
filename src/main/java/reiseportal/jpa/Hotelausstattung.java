/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

import javax.persistence.OneToMany;

/**
 *
 * @author jonas
 */
class Hotelausstattung {
    @OneToMany
    private Hotel hotel;
    
    @OneToMany
    private Ausstattung ausstattung;
    
    public Hotelausstattung(){
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Ausstattung getAusstattung() {
        return ausstattung;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setAusstattung(Ausstattung ausstattung) {
        this.ausstattung = ausstattung;
    }
}
