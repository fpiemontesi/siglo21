/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.interfaz.ProductoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Producto;

/**
 *
 * @author franc
 */
public class ProductoImplementacionDao implements ProductoDao {
    private ConexionDao conexion;
    
    public ProductoImplementacionDao(){
        this.conexion = ConexionDao.getInstancia();
    }
    
    @Override
    public boolean guardar(Producto producto) throws SQLException {
        int resultado = 0;
        
        try {
            conexion.conectar();
            
            String sql = "INSERT INTO Producto (Nombre, Marca) VALUES (?, ?)";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setString(1, producto.getNombre());
            consulta.setString(2, producto.getMarca());

            resultado = consulta.executeUpdate();
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado > 0;
    }

    @Override
    public ArrayList<Producto> obtenerPorMenu(String menu) throws SQLException {
        ArrayList<Producto> resultado = new ArrayList<Producto>();
        
        try {
            conexion.conectar();
            
            String sql = "SELECT Id, Nombre, Marca FROM Producto WHERE menu = ?";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setString(1, menu);

            ResultSet rs = consulta.executeQuery();
            while (rs.next()){
                resultado.add(new Producto(rs.getString("Nombre"), rs.getString("Marca")));
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado;
    }
    
}
