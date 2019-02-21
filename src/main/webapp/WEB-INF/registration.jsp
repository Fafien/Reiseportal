<%-- 
    Document   : registration
    Created on : 19.02.2019, 16:33:49
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
                        <label for="firstname">Vorname:</label>
                    </td>
                    <td>
                        <input name="firstname" value="${user_form.firtsname}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="lastname">Nachname:</label>
                    </td>
                    <td>
                        <input name="lastname" value="${user_form.lastname}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="email">E-Mail:</label>
                    </td>
                    <td>
                        <input name="email" value="${user_form.email}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="emailb">E-Mail bestätigen:</label>
                    </td>
                    <td>
                        <input name="emailb" value="${user_form.emailb}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="username">Username</label>
                    </td>
                    <td>
                        <input name="username" value="${user_form.username}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="password">Passwort:</label>
                    </td>
                    <td>
                        <input type="password" name="password" value="${user_form.password}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="passwordb">Passwort bestätigen:</label>
                    </td>
                    <td>
                        <input type="password" name="passwordb" value="${user_form.passwordb}"
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button>
                            Account anlegen
                        </button>
                    </td>
                </tr>
            </table>
        </form>
    </jsp:attribute>
</template:base>
