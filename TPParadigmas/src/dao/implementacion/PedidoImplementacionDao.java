/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.interfaz.PedidoDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public boolean guardar(Pedido pedido) throws SQLException {
        int resultado = 0;
        
        try {
            conexion.conectar();
            
            String sql = "INSERT INTO Pedido (Numero, Mesa, IdUsuario, IdMenu) VALUES (?, ?, ?, ?)";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setInt(1, pedido.getNumero());
            consulta.setInt(2, pedido.getMesa());
            consulta.setInt(3, pedido.getMozo().getLegajo());
            consulta.setInt(4, pedido.getMenu().getNumero());

            resultado = consulta.executeUpdate();
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado > 0;
    }
}
