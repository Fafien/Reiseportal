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
        <div class="center">
            <form method="POST" class="square">
                <div>
                    <input placeholder="Ort" class="field_top" name="location" id="location" type="text" value="${location}"/>
                    </br>
                    <input placeholder="Personen" class="field_middle" name="persons" id="persons" type="number" value="${persons}"/>
                    </br>
                    <input placeholder="von" class="field_middle" type="text" id="datum1" name="fromDate" value="${fromDate}"/>
                    </br>
                    <input placeholder="bis" class="field_bottom" type="text" id="datum2" name="untilDate" value="${untilDate}"/>
                    </br>
                    <button class="button" id="search">Suchen</button>
                    <div class="error">
                        <c:forEach items="${errors}" var="error">
                            <label><c:out value="${error}"></c:out></br></label>
                        </c:forEach>
                    </div>
                </div>
            </form>
        </div>
    </jsp:attribute>
</template:base>

