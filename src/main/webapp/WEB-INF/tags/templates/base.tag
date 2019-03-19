<%-- 
    Document   : base
    Created on : 19.02.2019, 16:44:39
    Author     : Fabian Hupe
--%>

<%@tag pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@attribute name="title"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="main" fragment="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">

        <title>Reiseportal</title>
        <link rel="stylesheet" href="<c:url value="/style.css"/>" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="<c:url value="/userinteraction.js"/>"></script>
        <link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        
        <jsp:invoke fragment="head"/>
    </head>
    <body class="w3-light-grey">
        <div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
            <span class="w3-bar-item w3-right">Reiseportal</span>    
        </div>
        <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container w3-row">
              <div class="w3-col s8 w3-bar">
                <c:choose>
                    <c:when test="${empty usr}">
                        <a id="login" class="w3-bar-item w3-button w3-padding" href="<c:url value="/login"/>">Anmelden</a>
                        <a id="registration" class="w3-bar-item w3-button w3-padding" href="<c:url value="/registration"/>">Registrieren</a>
                    </c:when>
                    <c:otherwise>
                        <span>Willkommen, <strong><c:out value="${usr.firstname}"/></strong></span><br>
                        <a class="w3-bar-item w3-button" href="<c:url value="/logout"/>">Logout</a>
                    </c:otherwise>
                </c:choose>
              </div>
            </div>
            <hr>
            <div class="w3-container">
              <h5>Dashboard</h5>
            </div>
            <div class="w3-bar-block">
                <a href="<c:url value="/index.html"/>" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-users fa-fw"></i>  Hotels suchen</a>
                <c:if test="${!empty usr}">
                    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-diamond fa-fw"></i>  Meine Buchungen</a>
                    <c:if test="${usr.admn}">
                        <a href="<c:url value="/usersearch"/>" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bank fa-fw"></i>  Benutzer verwalten</a>
                        <a href="<c:url value="/hoteladministration"/>" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bank fa-fw"></i>  Hotels verwalten</a>                            
                    </c:if>
                    <a href="<c:url value="/useraccount"/>" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Kontoeinstellungen</a><br><br>
                </c:if>
            </div>
        </nav>
        <!-- Hauptinhalt der Seite -->
        <main class="w3-main" style="margin-left:300px;margin-top:43px;">    
            <jsp:invoke fragment="main"/>
        </main>
    </body>
</html>
