<%-- 
    Document   : index
    Created on : 19.02.2019, 16:31:34
    Author     : Fabian Hupe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<template:base>
    <jsp:attribute name="main">
        <form method="POST" class="square">
            <table>
                <tr>
                    <td class="label">
                        <label for="location">Ort:</label>
                    </td>
                    <td>
                        <input name="location" type="text" value="${location}"
                    </td>
                    <td class="label">
                        <label for="fromDate">von:</label>
                    </td>
                    <td>
                        <input name="fromDate" type="date" value="${fromDate}"
                    </td>
                    <td class="label">
                        <label for="untilDate">bis:</label>
                    </td>
                    <td>
                        <input name="untilDate" type="date" value="${untilDate}"
                    </td>
                    <td class="label">
                        <label for="persons">Personen:</label>
                    </td>
                    <td>
                        <input name="persons" type="number" value="${persons}"
                    </td>
                    <td>
                        <button>Suchen</button>
                    </td>
                </tr>
            </table>
        </form>
    </jsp:attribute>
</template:base>

