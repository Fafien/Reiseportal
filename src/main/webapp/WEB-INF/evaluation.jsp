<%-- 
    Document   : valuation
    Created on : 19.02.2019, 16:39:45
    Author     : Marwa Alqataa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <div class="center">
            <form method="POST">
                <div class="titel_evaluation">
                    Kundenbewertung
                 </div>
                  </br>
                  <p> Wie zufrieden waren Sie mit Ihrem Hotel?</p>
                  <p><span class="sternebewertung"> 
                  <input type="radio" id="stern5" name="bewertung" value="5"><label for="stern5" title="5 Sterne">5 Sterne</label> 
                  <input type="radio" id="stern4" name="bewertung" value="4"><label for="stern4" title="4 Sterne">4 Sterne</label> 
                  <input type="radio" id="stern3" name="bewertung" value="3"><label for="stern3" title="3 Sterne">3 Sterne</label> 
                  <input type="radio" id="stern2" name="bewertung" value="2"><label for="stern2" title="2 Sterne">2 Sterne</label> 
                  <input type="radio" id="stern1" name="bewertung" value="1"><label for="stern1" title="1 Sterne">1 Stern</label> 
                  </p> </br> </br> </br>
                  <p> Was hat Ihnen gut und was hat Ihnen weniger gut gefallen? </p>
                  <textarea type="text" class="text_box" name="bewertungstext" value="${bewertungstext}"></textarea>
                  </br></br>
                <button name="button_evaluation" value="${bookingHotel}">Absenden</button>
            </form>
                  <div class="error">
                    <c:out value="${error}"></c:out>
                    </br>
                </div>
        </div>
    </jsp:attribute>
</template:base> 