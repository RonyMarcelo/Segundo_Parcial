<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Libro"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Biblioteca</title>
    <style>
        h1{
            text-align: center;
        
       }
       p{
          margin-left: 25em;
       }
    </style>
</head>
<body>
    <h1>Biblioteca</h1>
    
    <p><a href="MainController?=op==libro">Libros</a></p>
    <br>
    <p><a href="Maincontroler?=op==categorias">Categorias</a></p>
    
    <!-- Agrega enlaces o botones para eliminar libros si lo deseas -->

</body>
</html>
