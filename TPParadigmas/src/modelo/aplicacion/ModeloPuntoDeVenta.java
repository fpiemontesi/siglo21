/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

/**
 *
 * @author franc
 */
public class ModeloPuntoDeVenta {
    private static ModeloPuntoDeVenta puntoDeVenta;
    
    private ModeloPuntoDeVenta(){
    }
    
    public static ModeloPuntoDeVenta obtener(){
        if (puntoDeVenta == null)
            puntoDeVenta = new ModeloPuntoDeVenta();
        return puntoDeVenta;
    }
}
