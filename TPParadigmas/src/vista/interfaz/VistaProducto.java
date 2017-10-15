/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz;

/**
 *
 * @author franc
 */
public interface VistaProducto extends Vista {
    
    static final String GUARDAR = "guardar";    
    static final String CANCELAR = "cancelar";
    
    String getNombre();
    
    String getMarca();
    
    String getTipo();
    
    void imprimeResultado(String resultado);
    
    void imprimeError(Exception e);
}
