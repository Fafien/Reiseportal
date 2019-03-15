<%-- 
    Document   : edithotel
    Created on : Mar 1, 2019, 4:24:58 PM
    Author     : belizbalim
--%>
<%--  Diese JSP wird verwendet, wenn der Admin die Daten eines bestehenden Hotels aendern will. --%>
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
                    <c:choose>
                       <c:when test="${delete}">
                            <div id="question">Wollen Sie das Hotel wirklich löschen?</div>
                            <tr>
                                <td>
                                    <button name="button" value="loeschenja" class="delete_button">Ja</button>
                                </td>
                                <td>
                                    <button name="button" value="loeschennein" class="delete_button">Nein</button>
                                </td>
                            </tr>
                        </c:when> 
                        <c:otherwise>
                            <%--  Inputfelder im Formular gesperrt anzeigen --%>
                            <c:if test="${disabled}">
                                <tr>
                                    <td> Hotelname </td>
                                     <td>
                                         <input  class="field_top" name="hotelname" value="<c:out value="${foundhotel.hotelname}"></c:out>" disabled> 
                                    </td>
                                </tr>
                                <tr>
                                    <td> Ort </td>
                                    <td>
                                        <input class="field_middle" name="ort" value="<c:out value="${foundhotel.ort}"></c:out>"  disabled>
                                    </td>
                                </tr>
                                <tr>
                                    <td> Preis Pro Nacht </td>
                                    <td>
                                        <input class="field_middle" name="preisProNacht" value="<c:out value="${foundhotel.preisProNacht}"></c:out>" disabled>
                                    </td>
                                </tr>
                                <tr>
                                    <td> Anzahl Zimmer </td>
                                    <td>
                                        <input placeholder="" class="field_middle" name="anzahlZimmer" value="<c:out value="${foundhotel.anzahlZimmer}"></c:out>"  disabled>
                                    </td>
                                </tr>  
                                <tr>
                                    <td> Anzahl Sterne </td>
                                    <td>
                                        <input class="field_middle" name="sterne" value="<c:out value="${foundhotel.sterne}"></c:out>" disabled>
                                    </td>    
                                </tr>
                                <tr>
                                    <td> Entfernung zu der Stadtmitte </td>
                                    <td>
                                        <input class="field_middle" name="entfernung" value="<c:out value="${foundhotel.entfernung}"></c:out>"  disabled>
                                    </td>
                                </tr>
                                <tr>
                                    <button type="submit" class="button" name="button" value="zuruck"> Zurück </button>
                                </tr>
                                <tr>
                                    <button type="submit" class="button" name="button" value="bearbeiten"> Bearbeiten </button>
                                </tr>
                                <tr>
                                    <button type="submit" class="button" name="button" value="loeschen"> Löschen </button>
                                </tr>
                            </c:if>  
                        
                            <%--  Inputfelder im Formular ungesperrt anzeigen --%>
                            <c:if test="${!disabled}">
                                <tr class="error"> 
                                    <c:forEach items="${error}" var="error">
                                        <p class="error"><c:out value="${error}"></c:out></br>
                                    </c:forEach>  
                                </tr>
                                <tr>
                                     <td> Hotelname </td>
                                     <td>
                                        <input  class="field_top" name="hotelname" value="<c:out value="${foundhotel.hotelname}"></c:out>"> 
                                    </td>
                                </tr>
                                <tr>
                                    <td> Ort </td>
                                    <td>
                                        <input class="field_middle" name="ort" value="<c:out value="${foundhotel.ort}"></c:out>">
                                    </td>
                                </tr>
                                <tr>
                                    <td> Preis Pro Nacht </td>
                                    <td>
                                        <input class="field_middle" name="preisProNacht" value="<c:out value="${foundhotel.preisProNacht}"></c:out>">
                                    </td>
                                </tr>
                                <tr>
                                    <td> Anzahl Zimmer </td>
                                    <td>
                                        <input placeholder="" class="field_middle" name="anzahlZimmer" value="<c:out value="${foundhotel.anzahlZimmer}"></c:out>">
                                    </td>
                                </tr>  
                                <tr>
                                    <td> Anzahl Sterne </td>
                                    <td>
                                        <input class="field_middle" name="sterne" value="<c:out value="${foundhotel.sterne}"></c:out>">
                                    </td>    
                                </tr>
                                <tr>
                                    <td> Entfernung zu der Stadtmitte </td>
                                    <td>
                                        <input class="field_middle" name="entfernung" value="<c:out value="${foundhotel.entfernung}"></c:out>">
                                    </td>
                                </tr>
                                <tr>
                                    <button type="submit" class="button" name="button" value="zuruck"> Zurück </button>
                                </tr>
                                <tr>
                                    <button type="submit" class="button" name="button" value="speichern"> Speichern </button>
                                </tr>
                            </c:if>
                        </c:otherwise>     
                    </c:choose> 
                </table> 
            </form>    
        </div>
    </jsp:attribute>
</template:base>

