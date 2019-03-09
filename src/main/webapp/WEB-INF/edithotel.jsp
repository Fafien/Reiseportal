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
                <input  class="field_top" name="hotelname" value="<c:out value="${foundhotel.hotelname}"></c:out>">
                </br>
                <label> Ort </label>
                <input class="field_middle" name="ort" value="<c:out value="${foundhotel.ort}"></c:out>">
                </br>
                <label> Preis Pro Nacht </label>
                <input class="field_middle" name="preisProNacht" value="<c:out value="${foundhotel.preisProNacht}"></c:out>">
                </br>
                <label> Anzahl Zimmer </label>
                <input placeholder="" class="field_middle" name="anzahlZimmer" value="<c:out value="${foundhotel.anzahlZimmer}"></c:out>">
                </br>
                <label> Anzahl Sterne </label>
                <input class="field_middle" name="sterne" value="<c:out value="${foundhotel.sterne}"></c:out>">
                </br>
                <label> Entfernung zu der Stadtmitte </label>
                <input class="field_middle" name="entfernung" value="<c:out value="${foundhotel.entfernung}"></c:out>">
                </br>
                <button type="submit" class="button" name="button" value="aktualisieren"> Aktualisieren </button>
                </br>
                <button type="submit" class="button" name="button" value="Löschen"> Löschen </button>
            </form> 
        </div>
    </jsp:attribute>
</template:base>

