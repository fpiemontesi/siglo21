/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.consola;

import controlador.Controlador;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import modelo.dominio.Menu;
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
    private String menu;
    
    
    private ArrayList<Menu> menus;
    
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
    public String getMenu(){
        return this.menu;
    }
    
    @Override
    public void buscarMenus() {
        controlador.actionPerformed(new ActionEvent(this, 0, BUSCAR_MENUS));
    }
    
    @Override
    public void cargarMenus(ArrayList<Menu> menus){
        this.menus = menus;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void cancelar() {
        //vuelve menu anterior
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
                    buscarMenus();
                    solicitarInformacion();
                    if (this.marca.length() > 2 && this.nombre.length() > 2) {
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
    }
    
    private void solicitarInformacion(){
        System.out.println("Ingrese el nombre:");
        this.nombre = leeCadena();
        System.out.println("Ingrese la marca:");
        this.marca = leeCadena();
        solicitarMenu();
    }
    
    private void solicitarMenu() {
        boolean seleccionValida = false;
        do {
            System.out.println("\nSeleccione un menu de la lista (por codigo):");
            mostrarMenu();
            int menuId = leeEntero();
            
            for (Menu item : menus) {
                if (item.getNumero() == menuId){
                    this.menu = item.getNombre();
                    seleccionValida = true;
                    break;
                }                    
            }
            
            if (!seleccionValida)
                System.out.println("Ha seleccionado un menu inexistente, intentelo nuevamente...");
        } while (!seleccionValida);
    }    
    
    private void mostrarMenu(){
        for (Menu item : menus) {
            System.out.println(String.format("%s - %s, %s", item.getNumero(), item.getNombre(), item.getDescripcion()));
        }
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
