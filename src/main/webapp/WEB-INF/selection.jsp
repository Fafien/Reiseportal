<%-- 
    Document   : selection
    Created on : 19.02.2019, 16:32:41
    Author     : Fabian Hupe
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
                <div>
                    <label>
                        Sortierung
                    </label>
                    <select name="sorting" type="submit">
                        <option <c:out value="${PreisSelected}"></c:out> value="Preis">
                            Preis
                        </option>
                        <option <c:out value="${EntfernungSelected}"></c:out> value="Entfernung">
                            Entfernung
                        </option>
                        <option <c:out value="${BewertungSelected}"></c:out> value="Bewertung">
                            Bewertung
                        </option>
                    </select>
                    <label>
                        Filter: 
                    </label>
                    <c:forEach items="${filterLabel}" var="filter">
                        <label for="${filter.filterLabel}">
                            ${filter.filterLabel}
                        </label>
                        <input type="checkbox" name="${filter.filterLabel}" ${filter.filterChecked} value="${filter.filterLabel}">
                    </c:forEach>
                    <button name="button" value="Anwenden">
                        Anwenden
                    </button>
                </div>
                </br>
                <c:forEach items="${hotellist}" var="hotel">
                    <div>
                        <label>
                            Hotelname: <c:out value="${hotel.hotelname}"></c:out>
                        </label>
                        </br>
                        <label>
                            Ort: <c:out value="${hotel.ort}"></c:out>
                        </label>
                        </br>
                        <label>
                            Sterne: <c:out value="${hotel.sterne}"></c:out>
                        </label>
                        </br>
                        <label>
                            Entfernung zum Zentrum: <c:out value="${hotel.entfernung}"></c:out>km
                        </label>
                        </br>
                        <label>
                            Preis / Nacht: <c:out value="${hotel.preisProNacht}"></c:out>€
                        </label>
                        </br>
                        <button name="button" value="${hotel.id}">
                            Anzeigen
                        </button>
                    </div>
                        </br>
                </div>
            </c:forEach>
        </form>
    </jsp:attribute>
</template:base>
