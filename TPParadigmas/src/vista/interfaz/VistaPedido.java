/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz;

import java.util.ArrayList;
import modelo.dominio.Menu;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public interface VistaPedido extends Vista {
    static final String GUARDAR = "guardarPedido";
    static final String CANCELAR = "cancelarPedido";
    static final String BUSCAR_MOZOS = "buscarMozos";
    static final String BUSCAR_MENUS = "buscarMenus";
    static final String CREAR_COCINA = "crearCocina";
    
    int getNumero();

    int getMesa();
    
    Usuario getMozo();
    
    Menu getMenu();
    
    void buscarMozos();
    
    void cargarMozos(ArrayList<Usuario> mozos);
    
     void buscarMenus();
    
    void cargarMenus(ArrayList<Menu> menus);
    
    void imprimeResultado(String resultado);
    
    void imprimeError(Exception e);
}
