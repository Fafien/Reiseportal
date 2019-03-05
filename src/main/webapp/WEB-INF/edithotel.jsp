<%-- 
    Document   : edithotel
    Created on : Mar 1, 2019, 4:24:58 PM
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
                <p>${error}
                </br>
                <label> Hotelname </label>
                <input  class="field_top" name="hotelname" value="${hotelname}">
                </br>
                <label> Ort </label>
                <input class="field_middle" name="ort" value="${ort}">
                </br>
                <label> Preis Pro Nacht </label>
                <input class="field_middle" name="preisProNacht" value="${preisProNacht}">
                </br>
                <label> Anzahl Zimmer </label>
                <input placeholder="" class="field_middle" name="anzahlZimmer" value="${anzahlZimmer}">
                </br>
                <label> Anzahl Sterne </label>
                <input class="field_middle" name="sterne" value="${sterne}">
                </br>
                <label> Entfernung zu der Stadtmitte </label>
                <input class="field_middle" name="entfernung" value="${entfernung}">
                </br>
                <button class="button"> Aktualisieren </button>
            </form> 
        </div>
    </jsp:attribute>
</template:base>

