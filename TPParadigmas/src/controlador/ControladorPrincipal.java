/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.aplicacion.ModeloProducto;
import modelo.aplicacion.ModeloUsuario;
import vista.VistaPedidoConsola;
import vista.VistaProductoConsola;
import vista.interfaz.VistaPedido;
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
                    VistaPedido vistaPedido = new VistaPedidoConsola();
                    ModeloUsuario modeloUsuario = new ModeloUsuario();
                    Controlador controladorPedido = new ControladorPedido(vistaPedido, modeloUsuario);

                    vistaPedido.setControlador(controladorPedido);
                    vistaPedido.iniciarVista();                    
                    break;
                case VistaPrincipal.NUEVO_PRODUCTO:
                    VistaProducto vistaProducto = new VistaProductoConsola();
                    ModeloProducto modeloProducto = new ModeloProducto();        
                    Controlador controladorProducto = new ControladorProducto(vistaProducto, modeloProducto);

                    vistaProducto.setControlador(controladorProducto);
                    vistaProducto.iniciarVista();
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
