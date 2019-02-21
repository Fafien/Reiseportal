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
        <form method="POST" class="square">
            <table>
                <tr>
                    <td>
                        <label for="username">Username:</label>
                    </td>
                    <td>
                        <input name="username" value="${user_form.username}"
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Passwort:</label>
                    </td>
                    <td>
                        <input type="password" name="password" value="${user_form.username}"
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button>Anmelden</button>
                    </td>
                </tr>
            </table>
        </form>
        <div>
            Passwort vergessen                
        </div>
        <div>
            <a href="<c:url value="/registration"/>">Sie haben noch keinen Account? Hier geht es zur Registrierung</a>              
        </div>
    </jsp:attribute>
</template:base>
