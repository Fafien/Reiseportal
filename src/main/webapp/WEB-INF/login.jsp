<%-- 
    Document   : login
    Created on : 21.02.2019, 13:09:55
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
                    Einloggen
                </div>
                <input id="username" class="field_top" placeholder="Username" name="username" value="${user_form.username}">
                </br>
                <input id="password" class="field_bottom" placeholder="Passwort" type="password" name="password" value="${user_form.username}">
                </br>
                <button id="login_submit" class="button">Anmelden</button>
            </form>
            <div id="zusatztext">
                <div class="error">
                    <c:out value="${error}"></c:out>
                </div>
                    Passwort vergessen 
                    </br>
                    <a href="<c:url value="/registration"/>">Sie haben noch keinen Account? Hier geht es zur Registrierung</a>              
            </div>
        </div>
    </jsp:attribute>
</template:base>
