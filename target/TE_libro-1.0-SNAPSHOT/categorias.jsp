<%@page import="com.emergentes.modelo.Categorias"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    ArrayList<Categorias> lista = (ArrayList<Categorias>)request.getAttribute("lista");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
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
        <h1>Categorias</h1>
        <br> 
        <p><a href="#">Nuevo</a></p>
        <p><a href="index.jsp">Regresar</a></p>
      <table border="1">
        <tr>
            <th>ID</th>
            <th>Categoría</th>
        </tr>
        <c:forEach items="${lista}" var="catego">
            <tr>
                <td>${catego.id}</td>
                <td>${catego.categoria}</td>
                <td><a href="#">Editar</a></td>
                <td><a href="#">Eliminar</a></td>
            </tr>
        </c:forEach>
    </table>
        
    </body>
</html>
