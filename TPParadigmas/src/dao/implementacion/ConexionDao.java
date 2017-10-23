/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author franc
 */
public class ConexionDao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/pp";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection connection = null;
    private static ConexionDao instancia = null;
    
    private ConexionDao() {
        conectar();
    }
    
    public static ConexionDao getInstancia() {
        if(instancia == null) {
            instancia = new ConexionDao();
        }
        return instancia;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    protected void conectar(){
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    protected void desconectar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        connection = null;
    }
}
