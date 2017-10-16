/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public class UsuarioImplementacionDao implements UsuarioDao {

    @Override
    public ArrayList<Usuario> obtenerPorTipoDeUsuario(String tipoDeUsuario) throws SQLException {
        ArrayList<Usuario> resultado = new ArrayList<Usuario>();
        ResultSet resultSet;
        
        try {
            String sql = "SELECT id, nombre, apellido, tipoUsuario FROM Usuario WHERE tipoUsuario = ?";
            PreparedStatement consulta = ConexionDao.obtener().prepareStatement(sql);
            consulta.setString(1, tipoDeUsuario);

            resultSet = consulta.executeQuery();
            
            while(resultSet.next()){
                resultado.add(new Usuario(
                        resultSet.getInt("id"), 
                        resultSet.getString("nombre"), 
                        resultSet.getString("apellido"), 
                        resultSet.getString("tipoUsuario")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CocinaImplementacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
}
