<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="home.css">
    <title>Home</title>
</head>
<body>
    <div class="container">
        <h1 class="welcome-message">Bem-vindo à área Administrativa</h1>
        <p class="logout-link"><a href="index.jsp">Logout</a></p>
        
        <div class="user-search">
            <input type="text" placeholder="Buscar usuários">
            <input type="submit" value="Buscar">
        </div>
        
        <div class="user-list">
            <h2>Lista de Usuários</h2>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Endereço</th>
                        <th>Editar</th>
                        <th>Deletar</th>
                    </tr>
                </thead>
                <tbody>
                   
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.nome}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.telefone}</td>
                            <td>${usuario.endereco}</td>
                            <td class="edit-delete-buttons"><a href="editar_usuario?id=${usuario.id}">Editar</a></td>
                            <td class="edit-delete-buttons"><a href="deletar_usuario?id=${usuario.id}">Deletar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <div class="add-user-form">
            <h2>Adicionar Novo Usuário</h2>
            <form action="adicionar_usuario" method="post">
                <input type="text" name="nome" placeholder="Nome" required>
                <input type="text" name="email" placeholder="Email" required>
                <input type="text" name="telefone" placeholder="Telefone">
                <input type="text" name="endereco" placeholder="Endereço">
                <input type="submit" value="Adicionar">
            </form>
        </div>
    </div>
</body>
</html>
