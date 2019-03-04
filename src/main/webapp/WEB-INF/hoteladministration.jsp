<%-- 
    Document   : administrationHotel
    Created on : Feb 28, 2019, 1:15:25 PM
    Author     : belizbalim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
   <jsp:attribute name="main">
       <div class="center">      
            <a href = "<c:url value="/createhotel"/>"> 
               <button class="button">Neues Hotel Anlegen</button>
            </a>
            <form method="POST" name="AdminHotelSearch">
                <input class="field_top" name="hotelname" placeholder="Hotelname">
                <br>
                <input class="field_top" name="ort" placeholder="Ort">
                <br>
                <button class="button">Suchen</button>
            </form>
       </div>
   </jsp:attribute>            
</template:base>