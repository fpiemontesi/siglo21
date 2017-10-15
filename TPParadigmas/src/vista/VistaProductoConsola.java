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
import vista.interfaz.VistaProducto;

/**
 *
 * @author franc
 */
public class VistaProductoConsola implements VistaProducto {
    private Controlador controlador;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    private String nombre;
    private String marca;
    private String tipo;
    
    @Override
    public void imprimeResultado(String resultado) {
        System.out.println(resultado);
    }

    @Override
    public void imprimeError(Exception e) {
        System.out.println(e.getMessage());
    }
    
     @Override
    public String getNombre() {
         return this.nombre;
    }

    @Override
    public String getMarca() {
        return this.marca;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void iniciarVista() {
        imprimeMenu();
    }
    
    private void imprimeMenu() {
        muestraOpciones();

        int operacion;
        operacion = leeEntero();
        while (operacion != -1) {
            switch (operacion) {
                case 1:
                    solicitarInformacion();
                    if (this.marca.length() > 2 && this.tipo.length() > 2 && this.nombre.length() > 2) {
                        controlador.actionPerformed(new ActionEvent(this, operacion, GUARDAR));
                    } else {
                        System.out.println("Por favor ingrese un nombre, marca y tipo para guardar el producto");
                    }
                    break;
                case 2:
                case -1:
                    controlador.actionPerformed(new ActionEvent(this, operacion, CANCELAR));
                    break;
                default:
                    System.err.println("Esa no es una opción del menu");
            }
            muestraOpciones();
            operacion = leeEntero();
        }
        System.out.println("Cierra formulario producto!!");
        System.exit(0);
    }
    
    private void solicitarInformacion(){
        System.out.println("Ingrese el nombre:");
        this.nombre = leeCadena();
        System.out.println("Ingrese la marca:");
        this.marca = leeCadena();
        System.out.println("Ingrese el tipo:");
        this.tipo = leeCadena();
    }
    
    private void muestraOpciones() {
        System.out.println("---- MENU PRODUCTO ----");
        System.out.println("\nIndica la operación que quiere realizar:");
        System.out.println("1: Guardar");
        System.out.println("2: Cancelar");
        System.out.println("-1: Salir");
    }
    
    private String leeCadena(){
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException ex) {
            System.out.println();
        }
        return s;
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
