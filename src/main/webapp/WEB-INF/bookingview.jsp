<%-- 
    Document   : BookingView
    Created on : 10.03.2019, 18:40:22
    Author     : dar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <form method="POST" name="bewerten">
            <c:forEach items="${bookinglist}" var="hotel">
                <div>
                    <label>
                        Hotelname: <c:out value="${bookinglist.hotelname}"></c:out>
                    </label>
                   
                    <label>
                        Ort: <c:out value="${bookinglist.ort}"></c:out>
                    </label>
                    
                    <label>
                        Sterne: <c:out value="${bookinglis.sterne}"></c:out>
                    </label>
                    <button name="buttonEvaluation" value="${bookinghotel.id}">
                        Bewerten
                    </button>
                </div>
                    </br>
            </c:forEach>
        </form>
    </jsp:attribute>
</template:base>
