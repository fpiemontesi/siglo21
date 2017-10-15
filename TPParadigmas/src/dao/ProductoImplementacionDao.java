/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dominio.Producto;

/**
 *
 * @author franc
 */
public class ProductoImplementacionDao extends ConexionDao implements ProductoDao {

    @Override
    public boolean guardar(Producto producto) throws SQLException {
        int resultado = 0;
        
        try {
            String sql = "INSERT INTO Producto (Nombre, Marca) VALUES (?, ?)";
            PreparedStatement consulta = ConexionDao.obtener().prepareStatement(sql);
            consulta.setString(1, producto.getNombre());
            consulta.setString(2, producto.getMarca());

            resultado = consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CocinaImplementacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado > 0;
    }
    
}
