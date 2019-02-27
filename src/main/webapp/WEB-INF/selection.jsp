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
            <c:forEach items="${hotellist}" var="hotel">
                <div>
                    <label>
                        <c:out value="${hotel.hotelname}"></c:out>
                    </label>
                    </br>
                    <label>
                        <c:out value="${hotel.ort}"></c:out>
                    </label>
                    </br>
                    <label>
                        <c:out value="${hotel.sterne}"></c:out>
                    </label>
                    </br>
                    <label>
                        <c:out value="${hotel.entfernung}"></c:out>
                    </label>
                    </br>
                    <label>
                        <c:out value="${hotel.preisProNacht}"></c:out>
                    </label>
                    <button name="buttonOverview" value="<c:out value="${hotel.id}"></c:out>">
                        Anzeigen
                    </button>
                </div>
                    </br>
            </c:forEach>
        </form>
    </jsp:attribute>
</template:base>
