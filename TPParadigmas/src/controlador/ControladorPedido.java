/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.aplicacion.ModeloPuntoDeVenta;
import modelo.aplicacion.ModeloUsuario;
import vista.interfaz.VistaPedido;

/**
 *
 * @author franc
 */
public class ControladorPedido implements Controlador {

    private VistaPedido vista;
    private ModeloUsuario modeloUsuario;
    private ModeloPuntoDeVenta modeloPuntoDeVenta;

    public ControladorPedido(VistaPedido vista, ModeloUsuario modeloUsuario) {
        this.vista = vista;
        this.modeloUsuario = modeloUsuario;
        this.modeloPuntoDeVenta = ModeloPuntoDeVenta.obtener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case VistaPedido.GUARDAR:

                    break;
                case VistaPedido.BUSCAR_MOZOS:
                    this.vista.cargarMozos(modeloUsuario.obtenerMozos());
                    break;
                case VistaPedido.CANCELAR:

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
