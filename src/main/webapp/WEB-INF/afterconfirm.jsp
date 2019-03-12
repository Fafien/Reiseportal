<%-- 
    Document   : afterConfirm
    Created on : 10.03.2019, 17:39:59
    Author     : dar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
<jsp:attribute name="main">
        <form method="POST" >
            <div>
                <label class="erfolgreich">
                   Ihre Buchung war erfolgreich!
                </label>
                </br>
                <label>
                    Hotelname: <c:out value="${hotel.hotelname}"></c:out>
                </label>
                </br>
                <label>
                    Ort: <c:out value="${hotel.ort}"></c:out>
                </label>
                </br>
                <label>
                    Preis / Nacht: <c:out value="${hotel.preisProNacht}"></c:out>€
                </label>
                </br>
                <label>
                    Anzahl der Personen:<c:out value="${persons}"></c:out>
                </label>
                </br>              
                <label>
                    Ankunft: <c:out value="${ankunft}"></c:out>
                </label>
                </br>
                <label>
                    Abreise: <c:out value="${abreise}"></c:out>
                </label>
                </br>
            </div>
            </br>
        </form>
    </jsp:attribute>
</template:base>