/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.aplicacion.ModeloProducto;
import modelo.dominio.Producto;
import vista.interfaz.VistaProducto;

/**
 *
 * @author franc
 */
public class ControladorProducto implements Controlador {
    
    private VistaProducto vista;
    private ModeloProducto modelo;
    
    public ControladorProducto(VistaProducto vista, ModeloProducto modelo){
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            switch(e.getActionCommand()){
                case VistaProducto.GUARDAR:
                    Producto producto = new Producto(vista.getNombre(), vista.getMarca());
                    
                    boolean resultado = modelo.guardar(producto);   
                    
                    String resultadoGuardado;
                    if (resultado)
                        resultadoGuardado = "Guardado exitosamente";
                    else
                        resultadoGuardado = "No se ha podido guardar";
                    
                    vista.imprimeResultado(resultadoGuardado);
                    break;
                case VistaProducto.CANCELAR:
                    
                    break;
            }
        } catch (Exception ex) {
            vista.imprimeError(ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
