/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.interfaz.PedidoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Cocina;
import modelo.dominio.Pedido;

/**
 *
 * @author franc
 */
public class PedidoImplementacionDao implements PedidoDao {
    private ConexionDao conexion;
    
    public PedidoImplementacionDao(){
        this.conexion = ConexionDao.getInstancia();
    }
    
    @Override
    public ArrayList<Pedido> obtenerAbiertos() throws SQLException{
        ArrayList<Pedido> resultado = new ArrayList<Pedido>();
        
        try {
            conexion.conectar();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT Numero, Mesa, IdUsuario, IdMenu, IdCocina ");
            sql.append("FROM Pedido ");
            sql.append("WHERE finalizado = 0");
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql.toString());
            
            ResultSet rs = consulta.executeQuery();
            
            Pedido pedido;
            while(rs.next()){
               pedido = new Pedido(rs.getInt("Numero"), rs.getInt("Mesa"));
               
               resultado.add(pedido);
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado;
    }

    @Override
    public boolean guardar(Pedido pedido) throws SQLException {
        int resultado = 0;
        
        try {
            conexion.conectar();
            
            String sql = "INSERT INTO Pedido (Numero, Mesa, IdUsuario, IdMenu, IdCocina, Finalizado) VALUES (?, ?, ?, ?, ?, 0)";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setInt(1, pedido.getNumero());
            consulta.setInt(2, pedido.getMesa());
            consulta.setInt(3, pedido.getMozo().getLegajo());
            consulta.setInt(4, pedido.getMenu().getNumero());
            consulta.setInt(5, pedido.getCocina().getId());

            resultado = consulta.executeUpdate();
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado > 0;
    }
    
    @Override
    public boolean cerrar(Pedido pedido) throws SQLException{
        int resultado = 0;
        
        try {
            conexion.conectar();
            
            String sql = "UPDATE Pedido SET Finalizado = 1 WHERE Numero = ?";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setInt(1, pedido.getNumero());
            
            resultado = consulta.executeUpdate();
            
            conexion.desconectar();
        } catch (Exception e) {
            throw new SQLException(e);
        }
        
        return resultado > 0;
    }
    
    @Override
    public void cargarPedidos(Cocina cocina) throws SQLException {
        try {
            conexion.conectar();
            
            cocina.crearPedidos();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT Numero, Mesa, IdUsuario, IdMenu ");
            sql.append("FROM Pedido ");
            sql.append("WHERE idCocina = ?");
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql.toString());
            consulta.setInt(1, cocina.getId());
            
            Pedido pedido;
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
               pedido = new Pedido(rs.getInt("Numero"), rs.getInt("Mesa"));
               
               cocina.getPedidos().add(pedido);
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
}
