<%-- 
    Document   : index
    Created on : 19.02.2019, 16:31:34
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
            <div>
                <table>
                    <tr id="search-bar">
                        <td class="label">
                            <label for="location">Ort:</label>
                        </td>
                        <td>
                            <input name="location" id="location" type="text" value="${location}"/>
                        </td>
                        
                        <td class="label">
                            <label for="persons">Personen:</label>
                        </td>
                        <td>
                            <input name="persons" id="persons" type="number" value="${persons}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="label">
                            <label for="fromDate">von:</label>
                        </td>
                        <td>
                            <input type="text" id="datum1" name="fromDate" value="${fromDate}"/>
                        </td>
                        <td class="label">
                            <label for="untilDate">bis:</label>
                        </td>
                        <td>
                            <input type="text" id="datum2" name="untilDate" value="${untilDate}"/>
                        </td>
                        <td>
                            <button id="search">Suchen</button>
                        </td>
                    </tr>
                </table>
            </form>
            <div class="error">
                <c:forEach items="${errors}" var="error">
                    <label><c:out value="${error}"></c:out></br></label>
                </c:forEach>
            </div>
        </div>
    </jsp:attribute>
</template:base>

