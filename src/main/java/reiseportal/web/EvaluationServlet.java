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
import reiseportal.ejb.UserEvaluationBean;
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
    
    
    UserEvaluation evaluation;
    
    HttpSession session;
    ArrayList<String> error;
    
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException{
          session = request.getSession();
          
          request.getRequestDispatcher("/WEB-INF/evaluation.jsp").forward(request, response);
              }

         public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
     
            if(request.getParameter("button_evaluation").equals("absenden")){
               if(request.getParameter("bewertung").isEmpty() || request.getParameter("bewertungstext").isEmpty()){
                 error.add("Bitte alle Felder ausfüllen");
           /* }else{
                   
                evaluationBean.createNewValuation(734685, request.getParameter("bewertung"), request.getParameter("bewertungstext"));
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }
                    session.invalidate();*/
                    response.sendRedirect(request.getContextPath() + IndexServlet.URL);
            }
                
        }
}}    
    
    
    

            