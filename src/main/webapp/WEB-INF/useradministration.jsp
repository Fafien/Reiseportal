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
        <form method="POST" name="useradministration">
        <table>
            <tr>
                <td>
                    Vorname:
                </td>
                <td>
                    <c:out value="${founduser.firstname}"></c:out>
                </td>
            </tr>
            <tr>
                <td>
                    Nachname:
                </td>
                <td>
                    <c:out value="${founduser.lastname}"></c:out>
                </td>
            </tr>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    <c:out value="${founduser.username}"></c:out>
                </td>
            </tr>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    <c:out value="${founduser.username}"></c:out>
                </td>
            </tr>
            <tr>    
                <td>
                    Admin:
                </td>
                <td>
                    <c:out value="${founduser.admn}"></c:out>
                </td>
            </tr>
             <tr>    
                <td>
                    Gesperrt:
                </td>
                <td>
                    <c:out value="${founduser.blocked}"></c:out>
                </td>
            </tr>
            <c:choose> 
                <c:when test="${founduser.admn ==true}"> 
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" name="button" value="noadmin">Adminrechte entfernen</button>
                        </td>  
                    </tr>
                </c:when>
                <c:otherwise> 
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" name="button" value="admin">Zum Admin ernennen</button>
                        </td>  
                    </tr>
                </c:otherwise>     
            </c:choose> 
            <c:choose>   
                <c:when test="${founduser.blocked ==true}">     
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" name="button" value="entsperren">Entperren</button>
                        </td>
                    </tr>
                </c:when>    
                <c:otherwise>
                     <tr>
                        <td></td>
                        <td>
                            <button type="submit" name="button" value="sperren">Sperren</button>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose> 
            <tr>
                <td></td>
                <td>
                    <button type="submit" name="button" value="loeschen">Löschen</button>
                </td>
            </tr>          
        </table>
        </form>
    </jsp:attribute>
</template:base>

