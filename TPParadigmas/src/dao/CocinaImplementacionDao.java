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
import modelo.dominio.Cocina;
import modelo.dominio.Estado;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public class CocinaImplementacionDao extends ConexionDao implements CocinaDao {

    @Override
    public ArrayList<Cocina> obtenerTodas() throws SQLException {
        ArrayList<Cocina> resultado = new ArrayList<Cocina>();
        try {
            String sql = "SELECT c.Nombre as NombreCocina, c.idUsuario, u.nombre as nombreUsuario, u.apellido as ApellidoUsuario, u.tipoUsuario, c.idEstado, e.nombre as NombreEstado, e.descripcion as DescripcionEstado, e.tiempoDemoraDesde, e.tiempoDemoraHasta "
                    + "FROM Cocina c "
                    + "INNER JOIN Usuario u ON u.id = c.idUsuario "
                    + "INNER JOIN Estado e ON e.id = c.idEstado ";
            PreparedStatement consulta = ConexionDao.obtener().prepareStatement(sql);
            
            Cocina cocina;
            Usuario cocinero;
            Estado estado;
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
               cocinero = new Usuario(rs.getInt("idUsuario"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"), rs.getString("tipoUsuario"));
               estado = new Estado(rs.getInt("idEstado"), rs.getString("nombreEstado"), rs.getString("descripcionEstado"), rs.getInt("tiempoDemoraDesde"), rs.getInt("tiempoDemoraHasta"));
               cocina = new Cocina(rs.getString("NombreCocina"), cocinero, estado);
               
               resultado.add(cocina);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CocinaImplementacionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
