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
        <form method="POST" class="square">
            <table>
                <tr>
                    <td class="label">
                        <label for="firstname">Vorname:</label>
                    </td>
                    <td>
                        <input name="firstname" value="${firstname}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="lastname">Nachname:</label>
                    </td>
                    <td>
                        <input name="lastname" value="${lastname}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="email">E-Mail:</label>
                    </td>
                    <td>
                        <input type="email" name="email" value="${email}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="emailb">E-Mail bestätigen:</label>
                    </td>
                    <td>
                        <input type="email" name="emailb" value="${emailb}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="username">Username</label>
                    </td>
                    <td>
                        <input name="username" value="${username}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="password">Passwort:</label>
                    </td>
                    <td>
                        <input type="password" name="password" value="${password}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="passwordb">Passwort bestätigen:</label>
                    </td>
                    <td>
                        <input type="password" name="passwordb" value="${passwordb}"
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button>
                            Account anlegen
                        </button>
                    </td>
                </tr>
            </table>       
        </form>
        
        <div class="error">
            <c:forEach items="${errors}" var="error">
                <label><c:out value="${error}"></c:out></br></label>
            </c:forEach>
        </div>
    </jsp:attribute>
</template:base>
