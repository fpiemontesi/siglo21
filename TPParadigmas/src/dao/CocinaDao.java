/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Cocina;

/**
 *
 * @author franc
 */
public interface CocinaDao {
    final String tabla = "Cocina";
    
    ArrayList<Cocina> obtenerTodas() throws SQLException;
    
    boolean guardar(Cocina cocina) throws SQLException;
}
