<%-- 
    Document   : createhotel
    Created on : Feb 28, 2019, 3:57:02 PM
    Author     : belizbalim
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
                <div class="title">
                    Neues Hotel anlegen
                </div>
                 <c:forEach items="${error}" var="error">
                    <p><c:out value="${error}"></c:out></br>
                </c:forEach>   
                </br>
                <label> Hotelname </label>
                <input  class="field_top" name="hotelname" value="${hotelname}">
                </br>
                <label> Ort </label>
                <input class="field_middle" name="ort" value="${ort}">
                </br>
                <label> Preis Pro Nacht </label>
                <input class="field_middle" type="preisProNacht" name="preisProNacht" value="${preisProNacht}">
                </br>
                <label> Anzahl Zimmer </label>
                <input placeholder="" class="field_middle" type="anzahlZimmer" name="anzahlZimmer" value="${anzahlZimmer}">
                </br>
                <label> Anzahl Sterne </label>
                <input class="field_middle" name="sterne" value="${sterne}">
                </br>
                <label> Entfernung zu der Stadtmitte </label>
                <input class="field_middle" type="entfernung" name="entfernung" value="${entfernung}">
                </br>
                <button class="button">
                    Hotel anlegen
                </button>
            </form> 
        </div>
    </jsp:attribute>
</template:base>

