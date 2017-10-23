/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Producto;

/**
 *
 * @author franc
 */
public interface ProductoDao {
    final String tabla = "Producto";
    
    boolean guardar(Producto producto) throws SQLException;
    
    ArrayList<Producto> obtenerPorMenu(String menu) throws SQLException;
}
