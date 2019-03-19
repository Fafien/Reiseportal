<%-- 
    Document   : administrationBenutzer
    Created on : Feb 28, 2019, 1:16:05 PM
    Author     : belizbalim
--%>
<%--  Diese JSP wird verwendet, wenn der Admin Benutzer verwalten will. --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <div class="center"> 
            <form method="POST" name="useradministration">   
                <table>
                    <c:choose> 
                        <c:when test="${delete}">
                            <div id="question">Wollen Sie den Benutzer wirklich löschen?</div>
                                <tr>
                                    <td>
                                        <button name="button" value="loeschenja" class="delete_button">Ja</button>
                                    </td>
                                    <td>
                                        <button name="button" value="loeschennein" class="delete_button">Nein</button>
                                    </td>
                                </tr>
                        </c:when>
                        <c:otherwise> 
                            <tr>
                                <div class="title">
                                    User Informationen
                                </div>
                            </tr>
                            <tr>
                                <td>Vorname:</td>
                                <td>
                                    <c:out value="${founduser.firstname}"></c:out>
                                </td>
                            </tr>
                            <tr>
                                <td>Nachname:</td>
                                <td>
                                    <c:out value="${founduser.lastname}"></c:out>
                                </td>
                            </tr>
                            <tr>
                                <td>Username:</td>
                                <td>
                                    <c:out value="${founduser.username}"></c:out>
                                </td>
                            </tr>
                            <tr>
                                <td>Username:</td>
                                <td>
                                    <c:out value="${founduser.username}"></c:out>
                                </td>
                            </tr>
                            <tr>    
                                <td>Admin:</td>
                                <td>
                                    <c:out value="${founduser.admn}"></c:out>
                                </td>
                            </tr>
                            <tr>    
                                <td>Gesperrt:</td>
                                <td>
                                    <c:out value="${founduser.blocked}"></c:out>
                                </td>
                            </tr>
                            <c:choose>  
                            <%--  Auswahl der anzuzeigenden Buttons für verschiedene Faelle --%>
                                <c:when test="${founduser.admn ==true}"> 
                                    <tr>
                                    <td></td>
                                    <td>
                                        <button class="button" type="submit" name="button" value="noadmin">Adminrechte entfernen</button>
                                    </td>  
                                    </tr>
                                </c:when>
                                <c:otherwise> 
                                    <tr>
                                        <td></td>
                                        <td>
                                            <button class="button" type="submit" name="button" value="admin">Zum Admin ernennen</button>
                                        </td>  
                                    </tr>
                                </c:otherwise>     
                            </c:choose> 
                            <c:choose>   
                                <c:when test="${founduser.blocked ==true}">     
                                    <tr>
                                        <td></td>
                                        <td>
                                            <button class="button" type="submit" name="button" value="entsperren">Entperren</button>
                                        </td>
                                    </tr>
                                </c:when>    
                            <c:otherwise>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <button class="button" type="submit" name="button" value="sperren">Sperren</button>
                                        </td>
                                    </tr>
                            </c:otherwise>
                            </c:choose> 
                                <tr>
                                    <td></td>
                                    <td>
                                        <button class="button" type="submit" name="button" value="loeschen">Löschen</button>
                                    </td>
                                </tr> 
                        </c:otherwise>            
                     </c:choose>
                </table>
            </form>
        </div>
    </jsp:attribute>
</template:base>

