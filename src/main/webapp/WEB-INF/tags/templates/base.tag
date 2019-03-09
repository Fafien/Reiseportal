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
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        
        <jsp:invoke fragment="head"/>
    </head>
    <body>
        <header>
            <table>
                <tr>
                    <td id="title">
                        Dein Reiseportal
                    </td>
                    <c:choose>
                        <c:when test="${empty usr}">
                            <td class="nav">
                                <a href="<c:url value="/login"/>">Anmelden</a>
                            </td>
                            <td>
                                |
                            </td>
                            <td class="nav">
                                <a href="<c:url value="/registration"/>">Registrieren</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                Hallo 
                            </td>
                            <td>
                                <c:out value="${usr.firstname}"/>
                            </td>
                            <td>
                                <a href="<c:url value="/useraccount"/>">Mein Konto</a>
                            </td>
                            <c:if test="${!usr.admn}">
                                <td>
                                    <a href="<c:url value="/useradministration"/>">Benutzer verwalten</a>
                                </td> 
                            <td>    
                                <a href="<c:url value="/hoteladministration"/>">Hotel verwalten</a>
                            </td>   
                            </c:if>   
                            <td>
                                <a href="<c:url value="/logout"/>">Logout</a>
                            </td>
                        </c:otherwise>
                    </c:choose> 
                </tr>
            </table>           
        </header>
        <!-- Hauptinhalt der Seite -->
        <main>    
            <jsp:invoke fragment="main"/>
        </main>
    </body>
</html>
