/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.BookingBean;
import reiseportal.ejb.UserEvaluationBean;
import reiseportal.jpa.Booking;
import reiseportal.jpa.UserEvaluation;

/**
 *
 * @author Marwa Alqataa
 */

@WebServlet(name = "EvaluationServlet", urlPatterns = {"/evaluation"})
public class EvaluationServlet extends HttpServlet {
    
    public static final String URL = "/evaluation";
    
    @EJB
    UserEvaluationBean evaluationBean;
    
    @EJB
     BookingBean bookingbean;
            
    
    HttpSession session;
    Booking booking;
    String error;
    
    
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException{
        session = request.getSession();
        request.setAttribute("error", error);
        request.getRequestDispatcher("/WEB-INF/evaluation.jsp").forward(request, response);
          }
    
   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         
         
        try {
            if(request.getParameter("bewertung").isEmpty() || request.getParameter("bewertungstext").isEmpty()){
             error = "Bitte alle Felder ausfühlen";
             session.setAttribute("error", error);  
            response.sendRedirect(request.getContextPath() + EvaluationServlet.URL);}
       
         else{
             error = "";
              String sterneWert = request.getParameter("bewertung");
              if ("5".equals(sterneWert)) {
                  session.setAttribute("bewertung", "5");
              } else{
                     if("4".equals(sterneWert)) {
                  session.setAttribute("bewertung", "4"); 
                    }else{
                       if ("3".equals(sterneWert)) {
                  session.setAttribute("bewertung", "3");
                    }else{
                         if ("2".equals(sterneWert)) {
                  session.setAttribute("bewertung", "2");
                       }else{
                  session.setAttribute("bewertung", "1");
                            }
                        }
                        }
                     response.sendRedirect(request.getContextPath() + IndexServlet.URL);   
                    }
              String sterneInt = (String) session.getAttribute("bewertung");
              int sterneResult = Integer.parseInt(sterneInt);
              String bewertungsarea = request.getParameter("bewertungstext");
              String buttonBookingId = (String) session.getAttribute("evaluationButtonId");
              Long id = Long.parseLong(buttonBookingId);
              
            booking = bookingbean.findById(id);
             evaluationBean.createNewEvaluation(booking, sterneResult, bewertungsarea);
             
    }
         } catch (Exception e) {
                error = "Bitte alle Felder ausfühlen";
                 session.setAttribute("error", error);  
            response.sendRedirect(request.getContextPath() + EvaluationServlet.URL);
               } 
}   
}   
            