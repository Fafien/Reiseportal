<%-- 
    Document   : useradministration
    Created on : Mar 2, 2019, 3:49:46 PM
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
            <form method="POST" name="UserSearch" action="/adminUserEdit">
                <input class="field_top" name="benutzername" placeholder="Benutzername">
                <br>
                <button class="button">Suchen</button>
            </form>
       </div>
   </jsp:attribute>            
</template:base>