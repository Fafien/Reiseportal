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
 * @author Fabian Hupe
 */
@Entity
public class UserValuation implements Serializable{
    @Id
    @GeneratedValue ()
    private Long id;
    
    @OneToOne
    private Booking buchungId = null;
    
    private int sterne;
    private char bewertungstext;

    public UserValuation(Booking buchungId, int sterne, char bewertungstext) {
        this.buchungId = buchungId;
        this.sterne = sterne;
        this.bewertungstext = bewertungstext;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBuchungId() {
        return buchungId;
    }

    public void setBuchungId(Booking buchungId) {
        this.buchungId = buchungId;
    }

    public int getPunkte() {
        return sterne;
    }

    public void setPunkte(int punkte) {
        this.sterne = punkte;
    }

    public char getBewertungstext() {
        return bewertungstext;
    }

    public void setBewertungstext(char bewertungstext) {
        this.bewertungstext = bewertungstext;
    }
     
            
    
    
}
