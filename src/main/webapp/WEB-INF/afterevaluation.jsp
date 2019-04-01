<%-- 
    Content    : Danke an den User für die Bewertung
    Document   : AfterEvaluation
    Created on : 20.03.2019, 15:04:00
    Author     : Marwa Alqataa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<template:base>
<jsp:attribute name="main">
        <form method="POST" >
            <div>
                <label class="thanks">
                  Danke für Ihre Zeit
                </label>
                </br>
            </div>
        </form>
    </jsp:attribute>
</template:base>