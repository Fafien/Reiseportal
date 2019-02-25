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
                        <c:when test="${empty name}">
                            <td id="login">
                                <a href="<c:url value="/login"/>">Anmelden</a>
                            </td>
                            <td>
                                |
                            </td>
                            <td id="registration">
                                <a href="<c:url value="/registration"/>">Registrieren</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                Hallo 
                            </td>
                            <td>
                                <c:out value="${name}"/>
                            </td>
                            <td>
                                <a href="<c:url value="/useraccount"/>">Mein Konto</a>
                            </td>
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