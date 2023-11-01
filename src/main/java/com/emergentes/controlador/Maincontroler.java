
package com.emergentes.controlador;

import com.emergentes.modelo.Categorias;
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

@WebServlet(name = "Maincontroler", urlPatterns = {"/Maincontroler"})
public class Maincontroler extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        ArrayList<Categorias> lista = new ArrayList<Categorias>();
        ConexionDB canal = new ConexionDB();

        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;

        if (op.equals("list")) {
            try {
                //obtener la lista de registros
                String sql = "select * from categoria";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Categorias catego = new Categorias();
                    catego.setId(rs.getInt("id"));
                    catego.setCategoria(rs.getString("categoria"));
                    // Otras asignaciones de campos
                    lista.add(catego);
                }
                // Añade la lista al objeto request
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("categorias.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
