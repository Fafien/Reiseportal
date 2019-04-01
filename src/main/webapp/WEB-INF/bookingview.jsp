<%-- 
    Content    : Anzeige aller gebuchten Hotels, mit Bewerten-Button zu jedem gebuchten Hotel 
    Document   : BookingView
    Created on : 10.03.2019, 18:40:22
    Author     : Marwa Alqataa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <form method="POST" name="bewerten">
           <%-- <c:if test = "${bewertenTest == false}"> --%>
                <c:forEach items="${bookingEvaluationList}" var="bookingEvaluationList">
                <div>
                    <label>
                        Hotelname: <c:out value="${bookingEvaluationList.hotel.hotelname}"></c:out>
                    </label>
                   
                    <label>
                        Ort: <c:out value="${bookingEvaluationList.hotel.ort}"></c:out>
                    </label>
                    
                    <label>
                        Sterne: <c:out value="${bookingEvaluationList.hotel.sterne}"></c:out>
                    </label>
     
                    <%-- TODO: If( abreise < heute) --%>
                    <%--<c:if test = "${ abreise > heute }"> --%>
                    <button name="buttonEvaluation" value="${bookingEvaluationList.id}">
                       Bewerten
                    </button>
                    <%-- </c:if> --%>
                         </br>
                        </c:forEach>
                </form>
                <div class="error">
                    <c:out value="${error}"></c:out>
                    </br>
                </div>
               </div>
                    <%-- </c:if> --%>
    </jsp:attribute>
</template:base>
