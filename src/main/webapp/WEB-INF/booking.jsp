<%-- 
    Document   : booking
    Created on : 08.03.2019, 13:55:48
    Author     : Marwa Alqataa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<template:base>
<jsp:attribute name="main">
        <form method="POST" name="select">
            <div>
                <label>
                    Hotelname: <c:out value="${hotel.hotelname}"></c:out>
                </label>
                </br>
                <label>
                    Ausstattung: 
                </label>
                </br>
                <c:forEach items="${hotelaus}" var="hotelausstattung">
                    <ul>
                        <li>
                            <c:out value="${hotelausstattung.ausstattung}"></c:out> (<c:out value="${hotelausstattung.anzahl}"></c:out>x)
                        </li>
                    </ul>
                </c:forEach>
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
                <button name="buttonBooking" value="buttonBooking">
                    Buchen
                </button>
            </div>
            </br>
        </form>
    </jsp:attribute>
</template:base>