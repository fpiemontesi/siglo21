/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.interfaz.UsuarioDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public class UsuarioImplementacionDao implements UsuarioDao {
    private ConexionDao conexion;
    
    public UsuarioImplementacionDao(){
        this.conexion = ConexionDao.getInstancia();
    }
    
    @Override
    public ArrayList<Usuario> obtenerPorTipoDeUsuario(String tipoDeUsuario) throws SQLException {
        ArrayList<Usuario> resultado = new ArrayList<Usuario>();
        ResultSet resultSet;
        
        try {
            conexion.conectar();
            
            String sql = "SELECT id, nombre, apellido, tipoUsuario FROM Usuario WHERE tipoUsuario = ?";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setString(1, tipoDeUsuario);

            resultSet = consulta.executeQuery();
            
            while(resultSet.next()){
                resultado.add(new Usuario(
                        resultSet.getInt("id"), 
                        resultSet.getString("nombre"), 
                        resultSet.getString("apellido"), 
                        resultSet.getString("tipoUsuario")));
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado;
    }

    @Override
    public Usuario obtenerAdministrador() throws SQLException {
        return this.obtenerPorTipoDeUsuario("admin").get(0);        
    }
    
}
