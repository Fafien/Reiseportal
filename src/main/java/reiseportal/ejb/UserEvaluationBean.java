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
import reiseportal.jpa.UserEvaluation;

/**
 *
 * @author Marwa Alqataa
 */
@Stateless
public class UserEvaluationBean {
    
    @PersistenceContext
    protected EntityManager em;
    
    public UserEvaluation findBy(UserEvaluation id){
       return em.find(UserEvaluation.class, id);
    }
    
    public UserEvaluation createNewEvaluation( Booking buchungId,int sterne, String bewertungstext){
        UserEvaluation evaluation = new UserEvaluation( buchungId ,sterne, bewertungstext);
           em.persist(evaluation);
        return em.merge(evaluation);
    }
    
     public void deleteEvalaution(UserEvaluation evaluation) {
        em.remove(evaluation);
     }
        
     public UserEvaluation updateEvaluation(UserEvaluation evaluation) {
        return em.merge(evaluation);
    }
       
}
