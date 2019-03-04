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
import reiseportal.ejb.UserBean;
import reiseportal.jpa.Useraccount;

/**
 *
 * @author belizbalim
 */
@WebServlet(name = "UserAdministrationServlet", urlPatterns = {"/useradministration"})
public class UserAdministrationServlet extends HttpServlet{
HttpSession session;
    
    Useraccount usr;
  
    @EJB
    UserBean userbean;
  
    
   
}
