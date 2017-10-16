/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import vista.interfaz.VistaPrincipal;

/**
 *
 * @author franc
 */
public class VistaPrincipalConsola implements VistaPrincipal {

    private Controlador controlador;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void iniciarVista() {
        imprimeMenu();
    }
    
    private void imprimeMenu(){
        int operacion;
        muestraOpciones();
        operacion = leeEntero();
        while (operacion != -1) {
            switch (operacion) {
                case 1:
                    controlador.actionPerformed(new ActionEvent(this, operacion, NUEVO_PEDIDO));
                    break;
                case 2:
                    controlador.actionPerformed(new ActionEvent(this, operacion, NUEVO_PRODUCTO));
                    break;
                case -1:
                    System.out.println("La aplicacion se esta cerrando...");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Esa no es una opción del menu");
            }
            muestraOpciones();
            operacion = leeEntero();
        }
        System.out.println("La aplicacion se esta cerrando...");
        System.exit(0);
    }
    
    private void muestraOpciones() {
        System.out.println("---- MENU PRINCIPAL ----");
        System.out.println("\nIndica la operación que quiere realizar:");
        System.out.println("1: Nuevo Pedido");
        System.out.println("2: Nuevo Producto");
        System.out.println("-1: Salir");
    }
    
    private int leeEntero() {
        String s = null;
        try {
            s = in.readLine();
            return Integer.parseInt(s);
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
    }
}
