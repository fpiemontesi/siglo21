/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.interfaz.EstadoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dominio.Estado;

/**
 *
 * @author franc
 */
public class EstadoImplementacionDao implements EstadoDao {
    private ConexionDao conexion;
    
    public EstadoImplementacionDao(){
        this.conexion = ConexionDao.getInstancia();
    }
    
    private Estado obtenerPorNombre(String nombre) throws SQLException {
        Estado resultado = null;
        
        ResultSet resultSet;
        
        try {
            conexion.conectar();
            
            String sql = "SELECT id, nombre, descripcion, tiempoDemoraDesde, tiempoDemoraHasta FROM Estado WHERE nombre = ?";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setString(1, nombre);

            resultSet = consulta.executeQuery();
            
            if(resultSet.next()){
                resultado = new Estado(
                        resultSet.getInt("id"), 
                        resultSet.getString("nombre"), 
                        resultSet.getString("descripcion"), 
                        resultSet.getInt("tiempoDemoraDesde"),
                        resultSet.getInt("tiempoDemoraHasta"));
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado;
    }

    @Override
    public Estado obtenerLiviano() throws SQLException {
        return this.obtenerPorNombre("Liviano");
    }

    @Override
    public Estado obtenerPorTiempoDemora(int tiempoDemora) throws SQLException {
        Estado resultado = null;
        
        ResultSet resultSet;
        
        try {
            conexion.conectar();
            
            String sql = "SELECT id, nombre, descripcion, tiempoDemoraDesde, tiempoDemoraHasta FROM Estado WHERE ? BETWEEN tiempoDemoraDesde AND tiempoDemoraHasta";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setInt(1, tiempoDemora);

            resultSet = consulta.executeQuery();
            
            if(resultSet.next()){
                resultado = new Estado(
                        resultSet.getInt("id"), 
                        resultSet.getString("nombre"), 
                        resultSet.getString("descripcion"), 
                        resultSet.getInt("tiempoDemoraDesde"),
                        resultSet.getInt("tiempoDemoraHasta"));
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado;
    }
}
