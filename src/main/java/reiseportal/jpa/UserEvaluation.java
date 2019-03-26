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
import javax.persistence.OneToOne;

/**
 *
 * @author Marwa Alqataa
 */
@Entity
public class UserEvaluation implements Serializable{
    @Id
    @GeneratedValue ()
    private Long id;
    
    @OneToOne
    private Booking buchung = null;
    
    private int punkte;
    private String bewertungstext;

    public UserEvaluation(Booking buchung, int punkte, String bewertungstext) {
        this.buchung= buchung;
        this.punkte = punkte;
        this.bewertungstext = bewertungstext;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBuchung() {
        return buchung;
    }

    public void setBuchung(Booking buchung) {
        this.buchung = buchung;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public String getBewertungstext() {
        return bewertungstext;
    }

    public void setBewertungstext(String bewertungstext) {
        this.bewertungstext = bewertungstext;
    }  
}