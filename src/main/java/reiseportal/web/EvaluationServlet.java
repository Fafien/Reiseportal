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
    
    public final String URL = "/evaluation";
    
    @EJB
    UserEvaluationBean evaluationBean;
    
    @EJB
     BookingBean bookingbean;
            
    
    HttpSession session;
    Booking booking;
    
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException{
        session = request.getSession();
        
        request.getRequestDispatcher("/WEB-INF/evaluation.jsp").forward(request, response);
          }
    
   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         String error;
         if(request.getParameter("bewertung").isEmpty() || request.getParameter("bewertungsarea").isEmpty()){
             error = "Bitte alle Felder ausfühlen";
             
             //TODO:
             // String Eingabe beschränken
             
         }else{
             error = "";
             String str = request.getParameter("button_evaluation");
              Long id = Long.parseLong(str);
              booking = bookingbean.findById(id);
             int bewertung = Integer.parseInt(request.getParameter("bewertung"));
             String bewertungsarea = request.getParameter("bewertungsarea");

             evaluationBean.createNewEvaluation(booking, bewertung, bewertungsarea);
         }
           request.setAttribute("error", error);   
           response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            }
                
        }

    
    
    

            