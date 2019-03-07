/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Fabian Hupe
 */
@Entity
public class Hotel implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToMany(mappedBy="hotel")
    List<Hotelausstattung> hotelausstattung = new ArrayList<>();

    private String hotelname;
    private String ort;
    private int preisProNacht;
    private int anzahlZimmer;
    private int sterne;
    private int entfernung;

    public Hotel() {
    }
    
    public Hotel(String hotelname, String ort, int preisProNacht, int anzahlZimmer, int sterne, int entfernung){
        this.hotelname = hotelname;
        this.ort = ort;
        this.preisProNacht = preisProNacht;
        this.anzahlZimmer = anzahlZimmer;
        this.sterne = sterne;
        this.entfernung = entfernung;
    }
    
    public Long getId() {
        return id;
    }

    public List<Hotelausstattung> getHotelausstattung() {
        return hotelausstattung;
    }

    public String getHotelname() {
        return hotelname;
    }

    public String getOrt() {
        return ort;
    }

    public int getPreisProNacht() {
        return preisProNacht;
    }

    public int getAnzahlZimmer() {
        return anzahlZimmer;
    }

    public int getSterne() {
        return sterne;
    }

    public int getEntfernung() {
        return entfernung;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setHotelausstattung(List<Hotelausstattung> hotelausstattung) {
        this.hotelausstattung = hotelausstattung;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setPreisProNacht(int preisProNacht) {
        this.preisProNacht = preisProNacht;
    }
   
    public void setAnzahlZimmer(int anzahlZimmer) {
        this.anzahlZimmer = anzahlZimmer;
    }

    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    public void setEntfernung(int entfernung) {
        this.entfernung = entfernung;
    }
    
    public Object getHotelAusstattung() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
