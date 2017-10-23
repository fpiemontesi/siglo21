/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.consola.VistaPrincipalConsola;
import controlador.Controlador;
import controlador.ControladorPrincipal;
import vista.interfaz.VistaPrincipal;

/**
 *
 * @author franc
 */
public class Lanzador {
    
    public static void main(String[] args){
        VistaPrincipal vistaPrincipal = new VistaPrincipalConsola();
        Controlador controlador = new ControladorPrincipal(vistaPrincipal);
        
        vistaPrincipal.setControlador(controlador);
        vistaPrincipal.iniciarVista();
    }
}
