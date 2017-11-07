/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import modelo.aplicacion.ModeloCocina;
import modelo.aplicacion.ModeloMenu;
import modelo.aplicacion.ModeloPedido;
import modelo.aplicacion.ModeloProducto;
import modelo.aplicacion.ModeloUsuario;
import modelo.dominio.Cocina;
import modelo.dominio.Observer;
import modelo.dominio.Pedido;
import modelo.dominio.Subject;
import vista.interfaz.VistaPedido;

/**
 *
 * @author franc
 */
public class ControladorPuntoDeVenta implements Controlador, Subject {

    private VistaPedido vista;
    private ModeloUsuario modeloUsuario;
    private ModeloPedido modeloPedido;
    private ModeloCocina modeloCocina;
    private ModeloProducto modeloProducto;
    private ModeloMenu modeloMenu;
    private static ControladorPuntoDeVenta puntoDeVenta;
    
    private ControladorPuntoDeVenta(VistaPedido vista) {
        this.vista = vista;
        this.modeloUsuario = new ModeloUsuario();
        this.modeloPedido = new ModeloPedido();
        this.modeloCocina = new ModeloCocina();
        this.modeloProducto = new ModeloProducto();
        this.modeloMenu = new ModeloMenu(modeloProducto);
        
        addObserver(modeloCocina);
    }
    
    public static ControladorPuntoDeVenta obtener(VistaPedido vista){
        if (puntoDeVenta == null)
            puntoDeVenta = new ControladorPuntoDeVenta(vista);
        return puntoDeVenta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case VistaPedido.GUARDAR:
                    Pedido nuevoPedido = new Pedido();
                    nuevoPedido.setMenu(this.vista.getMenu());
                    nuevoPedido.setMesa(this.vista.getMesa());
                    nuevoPedido.setMozo(this.vista.getMozo());
                    nuevoPedido.setNumero(this.vista.getNumero());
                    
                    if (!this.modeloCocina.hayDisponibilidad()){
                        this.notifyObservers();   
                    }
                    
                    nuevoPedido.setCocina(modeloCocina.obtenerDisponible());
                    
                    if (this.modeloPedido.crear(nuevoPedido)){
                        this.vista.imprimeResultado("Se ha guardado el pedido con éxito");
                    }
                    else{
                        this.vista.imprimeResultado("No se ha podido guardar el pedido, consulte con el administrador");
                    }
                    
                    break;
                case VistaPedido.BUSCAR_MOZOS:
                    this.vista.cargarMozos(modeloUsuario.obtenerMozos());
                    break;
                case VistaPedido.BUSCAR_MENUS:
                    this.vista.cargarMenus(modeloMenu.obtenerTodos());
                    break;
                case VistaPedido.BUSCAR_PEDIDOS:
                    this.vista.cargarPedidos(modeloPedido.obtenerAbiertos());
                    break;
                case VistaPedido.CERRAR_PEDIDO:
                    this.modeloPedido.cerrar(this.vista.getPedidoACerrar());
                    break;
                case VistaPedido.CANCELAR:
                    this.vista.cancelar();
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

    @Override
    public void addObserver(Observer o) {
        Subject.OBSERVERS.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        Iterator it = Subject.OBSERVERS.iterator();

        while (it.hasNext()) {
            Observer obs = (Observer) it.next();
            if (obs.equals(o)){
                it.remove();
            }
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : Subject.OBSERVERS) {
            o.update(this);
        }
    }

}
