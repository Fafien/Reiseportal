<%-- 
    Document   : registration
    Created on : 19.02.2019, 16:33:49
    Author     : Fabian Hupe
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
                    Neuen Account anlegen
                </div>
                <input id="firstname" placeholder="Vorname" class="field_top" name="firstname" value="${firstname}">
                </br>
                <input id="lastname" placeholder="Nachname" class="field_middle" name="lastname" value="${lastname}">
                </br>
                <input id="email" placeholder="E-Mail" class="field_middle" type="email" name="email" value="${email}">
                </br>
                <input id="emailb" placeholder="E-Mail bestätigen" class="field_middle" type="email" name="emailb" value="${emailb}">
                </br>
                <input id="username" placeholder="Username" class="field_middle" name="username" value="${username}">
                </br>
                <input id="password" placeholder="Passwort" class="field_middle" type="password" name="password" value="${password}">
                </br>
                <input id="passwordb" placeholder="Passwort bestätigen" class="field_bottom" type="password" name="passwordb" value="${passwordb}">
                </br>
                <button id="registration_submit" class="button">
                    Account anlegen
                </button>
            </form>
        
            <div class="error">
                <c:forEach items="${errors}" var="error">
                    <label><c:out value="${error}"></c:out></br></label>
                </c:forEach>
            </div>
        </div>
    </jsp:attribute>
</template:base>
