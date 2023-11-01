
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_libros";
    static String usuario ="root";
    static String password = "1234r";
    
    Connection conn = null;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            conn  = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("Conecion OK: "+ conn);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error de Driver "+ e.getMessage());
        } catch (SQLException ex){
            System.out.println("Error de SQL"+ ex.getMessage());
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
