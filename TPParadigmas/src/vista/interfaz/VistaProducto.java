/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz;

import java.util.ArrayList;
import modelo.dominio.Menu;

/**
 *
 * @author franc
 */
public interface VistaProducto extends Vista {
    
    static final String GUARDAR = "guardar";    
    static final String CANCELAR = "cancelar";
    static final String BUSCAR_MENUS = "buscarMenus";
    
    String getNombre();
    
    String getMarca();
    
    String getMenu();
    
    void buscarMenus();
    
    void cargarMenus(ArrayList<Menu> menus);
    
    void imprimeResultado(String resultado);
    
    void imprimeError(Exception e);
    
    void cancelar();
}
