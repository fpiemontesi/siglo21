/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import modelo.dominio.Producto;
import dao.ProductoDao;
import dao.ProductoImplementacionDao;
import java.sql.SQLException;

/**
 *
 * @author franc
 */
public class ModeloProducto {
    private ProductoDao dao;
    
    public ModeloProducto(){
        this.dao = new ProductoImplementacionDao();
    }
    
    public boolean guardar(Producto producto) throws SQLException {
        //lamar a la base de datos y guardar
        return dao.guardar(producto);
    }
    
}
