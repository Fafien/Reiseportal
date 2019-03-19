<%-- 
    Document   : administrationHotel
    Created on : Feb 28, 2019, 1:15:25 PM
    Author     : belizbalim
--%>

<%--  Die Einstiegsseite für Admins bezüglich der Hotelanlage und Hoteldatenaenderungen --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<template:base>
   <jsp:attribute name="main">
       <div class="center">
           <div class="title">
                   Hotelverwaltung
           </div>
            <form method="POST" name="hoteladministrationneu">
                <button type="submit" class="button" name="button" value="neu">Neues Hotel Anlegen</button>
            </form>
            <form method="POST" name="hoteladministrationsearch">
                <p class="error"> ${error} </p>
                <br>
                
                <input class="field_top" name="hotelname" placeholder="Hotelname">
                <br>
                <input class="field_top" name="ort" placeholder="Ort">
                <br>
                <button type="submit" class="button" name="button" value="suche">Hotel Suchen</button>
            </form>
       </div>
   </jsp:attribute>            
</template:base>