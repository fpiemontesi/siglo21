/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz;

import java.util.ArrayList;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public interface VistaPedido extends Vista {
    static final String GUARDAR = "guardarPedido";
    static final String CANCELAR = "cancelarPedido";
    static final String BUSCAR_MOZOS = "buscarMozos";
    
    int getNumero();

    String getMesa();
    
    int getMozo();
    
    void buscarMozos();
    
    void cargarMozos(ArrayList<Usuario> mozo);
    
    void imprimeResultado(String resultado);
    
    void imprimeError(Exception e);
}
