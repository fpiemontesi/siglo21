/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author franc
 */
public class PedidosControlador {
    private static PedidosControlador puntoDeVenta;
    
    private PedidosControlador(){
    }
    
    public static PedidosControlador PuntoDeVenta(){
        if (puntoDeVenta == null)
            puntoDeVenta = new PedidosControlador();
        return puntoDeVenta;
    }
}
