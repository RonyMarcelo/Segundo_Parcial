<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    ArrayList<Libro> lista = (ArrayList<Libro>)request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
        <style>
            h1{
                text-align: center;
            }
            table{
                margin-left: auto;
                margin-right: auto;
            }
            p{
                margin-left: 28em;
            }
            
        </style>
    </head>
    <body>
        <h1>Libros</h1>
        <br>
        <p><a href="#">Nuevo</a></p>
        <p><a href="index.jsp">Regresar</a></p>
        <br>
        <table border="1">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Disponible</th>
            <th>Categoría</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${lista}" var="libro">
            <tr>
                <td>${libro.id}</td>
                <td>${libro.titulo}</td>
                <td>${libro.autor}</td>
                <td>${libro.disponible}</td>
                <td>${libro.categoria}</td>
                <td><a href="#">Editar</a></td>
                <td><a href="MainController?op==eliminar">Eliminar</a></td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
