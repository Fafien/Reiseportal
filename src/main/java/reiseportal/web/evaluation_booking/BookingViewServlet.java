/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.web.evaluation_booking;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reiseportal.ejb.BookingBean;
import reiseportal.jpa.Booking;
import reiseportal.jpa.Useraccount;

/**
 *
 * @author Marwa Alqataa
 */
@WebServlet(name = "BookingViewServlet", urlPatterns = {"/bookingview"})
public class BookingViewServlet extends HttpServlet{
   public static final String URL = "/bookingview";
        
    @EJB
    BookingBean bookingBean;
       
    String evaluationButtonId;
    HttpSession session;
    String  error;
       
   @Override
       public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        Useraccount usr = (Useraccount) session.getAttribute("usr");
        List<Booking> bookingList;
        bookingList = bookingBean.findBookingByUseraccount(usr);
         
        if(bookingList == null){
            session.setAttribute("bookingEvaluationList", "");
            error = "Sie haben kein Hotel gebucht";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/bookingview.jsp").forward(request, response);
         }else{
            session.setAttribute("bookingEvaluationList", bookingList);    
            request.getRequestDispatcher("/WEB-INF/bookingview.jsp").forward(request, response);
        }
      }
       
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
             
        session.setAttribute("evaluationButtonId", request.getParameter("buttonEvaluation"));
        response.sendRedirect(request.getContextPath() + EvaluationServlet.URL);
    }
 }