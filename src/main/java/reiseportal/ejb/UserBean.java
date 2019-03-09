/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.ejb;

import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import reiseportal.jpa.Useraccount;

/**
 *
 * @author Fabian Hupe
 */
@Stateless  
@DeclareRoles({"Admin", "Member"})
public class UserBean {

    @PersistenceContext
    EntityManager em;
    

    public Useraccount createNewUser(String firstname, String lastname, String email, String password, String username) {
        Useraccount user = new Useraccount(firstname, lastname, email, password, username);
        em.persist(user);
        return em.merge(user);
    }
    
    public Useraccount findUserbyID(long id) {
        return em.find(Useraccount.class, id);
    }
    
    public List<Useraccount> findUserByEmailOrUsername(String email, String username){
        return em.createQuery("SELECT u FROM Useraccount u WHERE u.email = :email OR u.username = :username")
                .setParameter("email", email)
                .setParameter("username", username)
                .getResultList();
    }
    
    public Useraccount deleteUser(long id) {
        Useraccount user = em.find(Useraccount.class, id);
        
        if (user != null) {
            em.remove(user);
        }
        
        return user;
    }
    
    public Useraccount updateUser(Useraccount user) {
        return em.merge(user);
    }
    
    //TODO
    public Useraccount setAdmin(Useraccount user, boolean set) {
       if (set == true) {
            user.setAdmn(true);
            return updateUser(user);
       }
       else {
           user.setAdmn(false);
           return updateUser(user);
       } 
    }
    
   
    public Useraccount setBlocked (Useraccount user, boolean block) {
        if (block == true) {
            user.setBlocked(true);
            return updateUser(user);
       }
       else {
           user.setBlocked(false);
           return updateUser(user);
       } 
    }
    
    


}
