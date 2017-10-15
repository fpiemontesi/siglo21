/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.aplicacion.ModeloProducto;
import vista.VistaProductoConsola;
import vista.interfaz.VistaPrincipal;
import vista.interfaz.VistaProducto;

/**
 *
 * @author franc
 */
public class ControladorPrincipal implements Controlador {
    
    private VistaPrincipal vista;

    public ControladorPrincipal(VistaPrincipal vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch(e.getActionCommand()){
                case VistaPrincipal.NUEVO_PEDIDO:
                    
                    break;
                case VistaPrincipal.NUEVO_PRODUCTO:
                    VistaProducto vista = new VistaProductoConsola();
                    ModeloProducto modelo = new ModeloProducto();        
                    Controlador controlador = new ControladorProducto(vista, modelo);

                    vista.setControlador(controlador);
                    vista.iniciarVista();
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
