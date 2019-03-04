/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import reiseportal.jpa.Booking;
import reiseportal.jpa.UserValuation;

/**
 *
 * @author Marwa Alqataa
 */
@Stateless
public class UserValuationBean {
    
    @PersistenceContext
    protected EntityManager em;
    
    public UserValuation findBy(UserValuation id){
       return em.find(UserValuation.class, id);
    }
    
    public UserValuation createNewValuation(Booking buchungId, int sterne, char bewertungstext){
        UserValuation valuation = new UserValuation(buchungId, sterne, bewertungstext);
           em.persist(valuation);
        return em.merge(valuation);
    }
    
}
