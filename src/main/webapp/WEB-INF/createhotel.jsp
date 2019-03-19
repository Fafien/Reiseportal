<%-- 
    Document   : createhotel
    Created on : Feb 28, 2019, 3:57:02 PM
    Author     : belizbalim
--%>


<%--  Diese JSP wird verwendet, wenn der Admin ein neues Hotel anlegen will. Es enthaelt das Hotelanlageformular
Der Admin gibt alle relevante Daten ein--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <div class="center">
            <form method="POST">
                <table>
                    <tr>
                        <div class="title">
                            Neues Hotel Anlegen
                        </div>
                    </tr>
                    <tr>
                        <c:forEach items="${error}" var="error">
                            <p class="error"><c:out value="${error}"></c:out></br>
                        </c:forEach>  
                    </tr>        
                    <tr>
                        <td> 
                            <label> Hotelname </label>
                        </td>
                        <td>
                            <input  class="field_top" name="hotelname" value="${hotelname}">
                        </td>
                    </tr>  
                    <tr>
                        <td> 
                            <label> Ort </label>
                        </td>
                        <td>
                            <input class="field_middle" name="ort" value="${ort}">
                        </td>    
                    </tr>
                    <tr>
                        <td>
                            <label> Preis Pro Nacht </label>
                        </td>
                        <td>
                            <input class="field_middle" type="preisProNacht" name="preisProNacht" value="${preisProNacht}">
                        </td>    
                    </tr>
                    <tr>
                        <td>
                            <label> Anzahl Zimmer </label>
                        </td> 
                        <td>
                            <input placeholder="" class="field_middle" type="anzahlZimmer" name="anzahlZimmer" value="${anzahlZimmer}">
                        </td>    
                    </tr>
                    <tr>
                        <td>
                            <label> Anzahl Sterne </label>
                        </td>
                        <td>
                            <input class="field_middle" name="sterne" value="${sterne}">
                        </td>    
                    </tr>
                    <tr>
                        <td>
                            <label> Entfernung zu der Stadtmitte </label>
                        </td>
                        <td>
                            <input class="field_bottom" type="entfernung" name="entfernung" value="${entfernung}">
                        </td>    
                    </tr>
                    <tr>
                        <button class="button">
                            Hotel speichern
                        </button>   
                    </tr>
                </table>
            </form> 
        </div>
    </jsp:attribute>
</template:base>

