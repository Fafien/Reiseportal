<%-- 
    Document   : edithotel
    Created on : Mar 1, 2019, 4:24:58 PM
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
            <form method="POST">
                <table> 
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
                        <button type="submit" class="button" name="button" value="bearbeiten"> Bearbeiten </button>
                        </tr>
                        <tr>
                        <button type="submit" class="button" name="button" value="löschen"> Löschen </button>
                        </tr>
                    </c:if>   
                    <c:if test="${!disabled}">
                        <tr> ${error} </tr>
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
                        <button type="submit" class="button" name="button" value="speichern"> Speichern </button>
                        </tr>
                    </c:if> 
                </table> 
            </form>    
        </div>
    </jsp:attribute>
</template:base>

