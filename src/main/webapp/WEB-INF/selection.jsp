<%-- 
    Document   : selection
    Created on : 19.02.2019, 16:32:41
    Author     : Fabian Hupe
    Content    : shows the list of hotels after search
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <form method="POST" name="select">
            <div>
                <label>
                    Sortierung
                </label>
                <select id="sorting" name="sorting">
                    <option <c:out value="${PreisSelected}"></c:out> value="Preis">
                        Preis
                    </option>
                    <option <c:out value="${EntfernungSelected}"></c:out> value="Entfernung">
                        Entfernung
                    </option>
                    <option <c:out value="${BewertungSelected}"></c:out> value="Bewertung">
                        Sterne
                    </option>
                </select>
                <label class="filterLabel">
                    Filter: 
                </label>
                <c:forEach items="${filterLabel}" var="filter">
                    <label for="${filter.filterLabel}" class="filterLabel">
                        ${filter.filterLabel}
                    </label>
                    <input type="checkbox" id="${filter.filterLabel}" name="${filter.filterLabel}" ${filter.filterChecked} value="${filter.filterLabel}">
                </c:forEach>
                <button class="button" name="button" id="anwenden" value="Anwenden">
                    Anwenden
                </button>
            </div>
            </br>
            <div class="hotellist">
                <c:forEach items="${hotellist}" var="hotel">
                    <div class="hotelzeile">
                        <div class="hotelelement">
                            <div class="bild">
                                <img src="KeinBild.jpg" alt=""/>
                            </div>
                            <div class="hotel">
                                <label class="left_width">
                                    Hotelname: 
                                </label>
                                <label>
                                    <c:out value="${hotel.hotelname}"></c:out>
                                </label>
                                </br>
                                <label class="left_width">
                                    Ort: 
                                </label>
                                <lable>
                                    <c:out value="${hotel.ort}"></c:out>
                                </lable>
                                </br>
                                <label class="left_width">
                                    Sterne:
                                </label>
                                <label>
                                    <c:out value="${hotel.sterne}"></c:out> Sterne
                                </label>
                                </br>
                                <label class="left_width">
                                    Entfernung:
                                </label>
                                <label>
                                    <c:out value="${hotel.entfernung}"></c:out>km (zum Zentrum)
                                </label>
                                </br>
                                <label class="left_width">
                                    Preis / Nacht: 
                                </label>
                                <label>
                                    <c:out value="${hotel.preisProNacht}"></c:out>€
                                </label>
                                </br>
                                <button name="button" id="buttonAnzeigen" value="${hotel.id}">
                                    Anzeigen
                                </button>
                                </br>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </form>
    </jsp:attribute>
</template:base>
