<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuários</title>
</head>
<body>
    <c:choose>
        <c:when test="${empty usuarios}">
            <p>Nenhum usuário encontrado.</p>
        </c:when>
        <c:otherwise>
            <h1>Usuários</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>ID</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td><a>${usuario.nome}</a></td>
                            <td>${usuario.id}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
