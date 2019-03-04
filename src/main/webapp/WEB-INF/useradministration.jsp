<%-- 
    Document   : administrationBenutzer
    Created on : Feb 28, 2019, 1:16:05 PM
    Author     : belizbalim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <form method="POST" name="adminuseredit">
        <table>
            <tr>
                <td>
                    Vorname:
                </td>
                <td>
                    <c:out value="${usr.firstname}"></c:out>
                </td>
            </tr>
            <tr>
                <td>
                    Nachname:
                </td>
                <td>
                    <c:out value="${usr.lastname}"></c:out>
                </td>
            </tr>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    <c:out value="${usr.username}"></c:out>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button name="button" value="admin">Zum Admin ernennen</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button name="button" value="sperren">Sperren</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button name="button" value="löschen">Löschen</button>
                </td>
            </tr>          
        </table>
        </form>
    </jsp:attribute>
</template:base>

