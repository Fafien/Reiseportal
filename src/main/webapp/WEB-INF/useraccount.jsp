<%-- 
    Document   : useraccount
    Created on : 19.02.2019, 16:34:40
    Author     : Fabian Hupe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <div class="padding10">
        <div class="center">
        <form method="POST" name="edit">
            <table class="text_left">
            <c:choose>
                <c:when test="${delete}">
                    <div id="question">Wollen Sie den Account wirklich löschen?</div>
                    <tr>
                        <td>
                            <button id="delete_submit" name="button" value="deletey" class="delete_button">Ja</button>
                        </td>
                        <td>
                            <button name="button" value="deleten" class="delete_button">Nein</button>
                        </td>
                    </tr>
                </c:when>
            <c:when test="${edit}">
            <tr>
                <td>
                    Vorname:
                </td>
                <td>
                    <input id="firstname" name="usr_form_firstname" value="<c:out value="${usr.firstname}"></c:out>">
                </td>
            </tr>
            <tr>
                <td>
                    Nachname:
                </td>
                <td>
                    <input id="lastname" name="usr_form_lastname" value="<c:out value="${usr.lastname}"></c:out>">
                </td>
            </tr>
            <tr>
                <td>
                    E-Mail-Adresse:
                </td>
                <td>
                    <input id="email" name="usr_form_email" value="<c:out value="${usr.email}"></c:out>">
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
                    <button id="save_usersettings" class="button" name="button" value="save">Speichern</button>
                </td>
            </tr>
            </c:when>
            <c:when test="${password}">
            <tr>
                <td>
                    Altes Passwort:
                </td>
                <td>
                    <input id="passworda" type="password" name="usr_form_passwordo">
                </td>
            </tr>
            <tr>
                <td>
                    Neues Passwort:
                </td>
                <td>
                    <input id="password" type="password" name="usr_form_password">
                </td>
            </tr>
            <tr>
                <td>
                    Neues Passwort bestätigen:
                </td>
                <td>
                    <input id="passwordb" type="password" name="usr_form_passwordb">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button id="save_password" class="button" name="button" value="savep">Speichern</button>
                </td>
            </tr>
            <div class="error">
            <c:forEach items="${errors}" var="error">
                <label><c:out value="${error}"></c:out></br></label>
            </c:forEach>
            </div>
            </c:when>
            <c:otherwise>
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
                    E-Mail-Adresse:
                </td>
                <td>
                    <c:out value="${usr.email}"></c:out>
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
                    <button id="edit" class="button" name="button" value="edit">Bearbeiten</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button id="change_pw" class="button" name="button" value="password">Passwort ändern</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button id="delete" class="button" name="button" value="delete">Löschen</button>
                </td>
            </tr>
            </c:otherwise>
            </c:choose>
        </table>
        </form>
        </div>
        </div>
    </jsp:attribute>
</template:base>
