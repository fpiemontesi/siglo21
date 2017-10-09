/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author franc
 */
public class ConexionDao {
    protected static Connection conexion = null;
    
    public static Connection obtener() throws SQLException, ClassNotFoundException {
      if (conexion == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/java_mysql", "root", "root");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return conexion;
   }
   public static void cerrar() throws SQLException {
      if (conexion != null) {
         conexion.close();
      }
   }
}
