/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Fabian Hupe
 */
@Entity
public class Useraccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue()
    private Long id;
    private String username;
    private String email;
    private String lastname;
    private String firstname;
    private String password;
    private boolean admin;
    private boolean blocked;
    private boolean activated;


//<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Useraccount(){
        
    }
    
    public Useraccount(String firstname, String lastname, String email, String password, String username){
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.admin = false;
        this.blocked = false;
        this.activated = false;
        
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Setter & Getter">
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public boolean isAdmn() {
        return admin;
    }
    
    public void setAdmn(boolean admin) {
        this.admin = admin;
    }
    
    public boolean isBlocked() {
        return blocked;
    }
    
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
//</editor-fold>
    
    public boolean checkValues(){
        if(firstname.trim().isEmpty() || lastname.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
