package com.emergentes.controlador;

import com.emergentes.modelo.Libro;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        ArrayList<Libro> lista = new ArrayList<Libro>();
        ConexionDB canal = new ConexionDB();

        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;

        if (op.equals("list")) {
            try {
                //obtener la lista de registros
                String sql = "select * from libros";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Libro libro = new Libro();
                    libro.setId(rs.getInt("id"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setDisponible(rs.getString("disponible"));
                    libro.setCategoria(rs.getString("categoria"));
                    // Otras asignaciones de campos
                    lista.add(libro);
                }
                // Añade la lista al objeto request
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("libro.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(op.equals("nuevo")){
            try {
                // Implementa la lógica para agregar un nuevo libro
                String titulo = request.getParameter("titulo");
                String autor = request.getParameter("autor");
                // Otras variables para los datos del nuevo libro
                // Realiza la inserción en la base de datos
                String sql = "INSERT INTO libros (titulo, autor, ...) VALUES (?, ?, ...)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, titulo);
                ps.setString(2, autor);
                // Establece otros parámetros
                int rows = ps.executeUpdate();
                // Realiza la lógica de redireccionamiento o respuesta apropiada
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    if(op.equals("eliminar")){
            try {
                // Implementa la lógica para eliminar un libro
                int libroId = Integer.parseInt(request.getParameter("id"));
                // Realiza la eliminación en la base de datos
                String sql = "DELETE FROM libros WHERE id=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, libroId);
                int rows = ps.executeUpdate();
                // Realiza la lógica de redireccionamiento o respuesta apropiada
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
