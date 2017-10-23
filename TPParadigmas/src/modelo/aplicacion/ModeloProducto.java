/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import modelo.dominio.Producto;
import dao.interfaz.ProductoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dominio.Menu;

/**
 *
 * @author franc
 */
public class ModeloProducto extends Modelo {    
    private final ProductoDao dao = fabricaDao.getProductoDao();
    
    public ArrayList<Producto> cargarProductos(Menu menu) {
        ArrayList<Producto> resultado = new ArrayList<Producto>();
        try {
            resultado = this.dao.obtenerPorMenu(menu.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean guardar(Producto producto) throws SQLException {
        //lamar a la base de datos y guardar
        return dao.guardar(producto);
    }
    
}
