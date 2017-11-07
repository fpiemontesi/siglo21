/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.interfaz.CocinaDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Cocina;
import modelo.dominio.Estado;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public class CocinaImplementacionDao implements CocinaDao {
   
    private ConexionDao conexion;
    
    public CocinaImplementacionDao(){
        this.conexion = ConexionDao.getInstancia();
    }
    
    @Override
    public ArrayList<Cocina> obtenerTodas() throws SQLException {
        ArrayList<Cocina> resultado = new ArrayList<Cocina>();
        try {
            conexion.conectar();
            
            String sql = "SELECT c.Nombre as NombreCocina, c.idUsuario, u.nombre as nombreUsuario, u.apellido as ApellidoUsuario, u.tipoUsuario, c.Id as IdCocina, c.idEstado, e.nombre as NombreEstado, e.descripcion as DescripcionEstado, e.tiempoDemoraDesde, e.tiempoDemoraHasta "
                    + "FROM Cocina c "
                    + "INNER JOIN Usuario u ON u.id = c.idUsuario "
                    + "INNER JOIN Estado e ON e.id = c.idEstado ";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            
            Cocina cocina;
            Usuario cocinero;
            Estado estado;
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
               cocinero = new Usuario(rs.getInt("idUsuario"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"), rs.getString("tipoUsuario"));
               estado = new Estado(rs.getInt("idEstado"), rs.getString("nombreEstado"), rs.getString("descripcionEstado"), rs.getInt("tiempoDemoraDesde"), rs.getInt("tiempoDemoraHasta"));
               cocina = new Cocina(rs.getInt("idCocina"), rs.getString("NombreCocina"), cocinero, estado);
               
               resultado.add(cocina);
            }
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } 
        return resultado;
    }

    @Override
    public boolean guardar(Cocina cocina) throws SQLException {
        int resultado = 0;
        
        try {
            conexion.conectar();
            
            String sql = "INSERT INTO Cocina (nombre, idUsuario, idEstado) VALUES (?, ?, ?)";
            PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
            consulta.setString(1, cocina.getNombre());
            consulta.setInt(2, cocina.getCocinero().getLegajo());
            consulta.setInt(3, cocina.getEstado().getId());

            resultado = consulta.executeUpdate();
            
            conexion.desconectar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
        return resultado > 0;
    }    
}
