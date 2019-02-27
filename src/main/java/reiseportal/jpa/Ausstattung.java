/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

/**
 *
 * @author jonas
 */
class Ausstattung {
    @Id
    @GeneratedValue
    private Long id;
    
    private String bezeichnung;
    
    @ManyToOne
    private Hotelausstattung hotelausstattung;
    
    public Ausstattung() {
    }

    public Long getId() {
        return id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public Hotelausstattung getHotelausstattung() {
        return hotelausstattung;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setHotelausstattung(Hotelausstattung hotelausstattung) {
        this.hotelausstattung = hotelausstattung;
    }
}
