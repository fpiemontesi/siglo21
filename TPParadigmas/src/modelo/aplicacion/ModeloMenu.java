/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import java.util.ArrayList;
import modelo.dominio.Fabrica;
import modelo.dominio.FabricaMenu;
import modelo.dominio.Menu;

/**
 *
 * @author franc
 */
public class ModeloMenu {

    private ModeloProducto modeloProducto;
    private Fabrica fabricaMenu;
    
    public ModeloMenu(ModeloProducto modeloProducto) {
        this.modeloProducto = modeloProducto;
        this.fabricaMenu = new FabricaMenu();
    }
    
    public ArrayList<Menu> obtenerTodos(){
        ArrayList<Menu> resultado = new ArrayList<Menu>();
        resultado.add(fabricaMenu.CrearMenu1());
        resultado.add(fabricaMenu.CrearMenu2());
        
        for (Menu menu : resultado) {
            menu.setProductos(modeloProducto.cargarProductos(menu));
        }
        
        return resultado;
    }
}
