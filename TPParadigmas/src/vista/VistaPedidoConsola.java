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
import java.util.ArrayList;
import modelo.dominio.Usuario;
import vista.interfaz.VistaPedido;

/**
 *
 * @author franc
 */
public class VistaPedidoConsola implements VistaPedido {
    
    private Controlador controlador;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    private int numero;
    private String mesa;
    private int mozo;
    private ArrayList<Usuario> mozos;

    @Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public String getMesa() {
        return this.mesa;
    }

    @Override
    public int getMozo() {
        return this.mozo;
    }

    @Override
    public void buscarMozos() {
        controlador.actionPerformed(new ActionEvent(this, 0, BUSCAR_MOZOS));
    }
    
    @Override
    public void cargarMozos(ArrayList<Usuario> mozos){
        this.mozos = mozos;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void iniciarVista() {
        
        imprimeMenu();
    }
    
    @Override
    public void imprimeResultado(String resultado) {
        System.out.println(resultado);
    }

    @Override
    public void imprimeError(Exception e) {
        System.out.println(e.getMessage());
    }
    
    private void imprimeMenu() {
        muestraOpciones();

        int operacion;
        operacion = leeEntero();
        while (operacion != -1) {
            switch (operacion) {
                case 1:
                    buscarMozos();
                    solicitarInformacion();
                    if (this.numero > 0 && this.mesa.length() > 0 && this.mozo > 0) {
                        controlador.actionPerformed(new ActionEvent(this, operacion, GUARDAR));
                    } else {
                        System.out.println("Por favor ingrese un nombre, marca y tipo para guardar el pedido");
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
        System.out.println("Cierra formulario pedido!!");
    }
    
    private void muestraOpciones() {
        System.out.println("---- MENU PEDIDO ----");
        System.out.println("\nIndica la operación que quiere realizar:");
        System.out.println("1: Guardar");
        System.out.println("2: Cancelar");
        System.out.println("-1: Salir");
    }
    
    private void solicitarInformacion(){
        System.out.println("Ingrese el numero:");
        this.numero = leeEntero();
        System.out.println("Ingrese la mesa:");
        this.mesa = leeCadena();
        solcitarMozo();
    }
    
    private void solcitarMozo(){
        boolean seleccionValida = false;
        do {
            System.out.println("\nIngrese un mozo de la lista (por codigo):");
            mostrarMozos();
            this.mozo = leeEntero();
            
            for (Usuario item : mozos) {
                if (item.getLegajo() == this.mozo)
                    seleccionValida = true;
            }
            
            if (!seleccionValida)
                System.out.println("Ha seleccionado un mozo inexistente, intentelo nuevamente...");
        } while (!seleccionValida);
    }
    
    private void mostrarMozos(){
        for (Usuario item : mozos) {
            System.out.println(String.format("%s - %s, %s", item.getLegajo(), item.getApellido(), item.getNombre()));
        }
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
