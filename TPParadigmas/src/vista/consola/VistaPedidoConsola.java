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
import modelo.dominio.Pedido;
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
    private int mesa;
    private int mozoId;
    private int menuId;
    private int pedidoId;
    private Usuario mozo;
    private Menu menu;
    private Pedido pedido;
    private ArrayList<Usuario> mozos;
    private ArrayList<Menu> menus;
    private ArrayList<Pedido> pedidos;

    @Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public int getMesa() {
        return this.mesa;
    }

    @Override
    public Usuario getMozo() {
        return this.mozo;
    }
    
    @Override
    public Pedido getPedidoACerrar(){
        return this.pedido;
    }
    
    @Override
    public Menu getMenu(){
        return this.menu;
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
    public void buscarPedidos(){
        controlador.actionPerformed(new ActionEvent(this, 0, BUSCAR_PEDIDOS));
    }
    
    @Override
    public void cargarPedidos(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;
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
                    buscarMenus();
                    solicitarInformacion();
                    if (this.numero > 0 && this.mesa > 0 && this.mozoId > 0) {
                        controlador.actionPerformed(new ActionEvent(this, operacion, GUARDAR));
                    } else {
                        System.out.println("Por favor ingrese un nombre, marca y tipo para guardar el pedido");
                    }
                    break;
                case 2:
                    buscarPedidos();
                    solicitarPedido();
                    controlador.actionPerformed(new ActionEvent(this, operacion, CERRAR_PEDIDO));
                case 3:
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
        System.out.println("2: Cerrar Pedido");
        System.out.println("3: Cancelar");
        System.out.println("-1: Salir");
    }
    
    private void solicitarPedido(){
        boolean seleccionValida = false;
        do {
            System.out.println("\nSeleccione un pedido de la lista (por codigo):");
            mostrarPedidos();
            this.pedidoId = leeEntero();
            
            for (Pedido item : pedidos) {
                if (item.getNumero() == this.pedidoId){
                    this.pedido = item;
                    seleccionValida = true;   
                    break;
                }
            }
            
            if (!seleccionValida)
                System.out.println("Ha seleccionado un pedido inexistente, intentelo nuevamente...");
        } while (!seleccionValida);
    }
    
    private void mostrarPedidos(){
        for (Pedido item : pedidos) {
            System.out.println(String.format("NRO: %s -  MESA: %s", item.getNumero(), item.getMesa()));
        }
    }
    
    private void solicitarInformacion(){
        System.out.println("Ingrese el numero:");
        this.numero = leeEntero();
        System.out.println("Ingrese la mesa:");
        this.mesa = leeEntero();
        solcitarMozo();
        solicitarMenu();
    }
    
    private void solicitarMenu() {
        boolean seleccionValida = false;
        do {
            System.out.println("\nSeleccione un menu de la lista (por codigo):");
            mostrarMenu();
            this.menuId = leeEntero();
            
            for (Menu item : menus) {
                if (item.getNumero() == this.menuId){
                    this.menu = item;
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
    
    private void solcitarMozo(){
        boolean seleccionValida = false;
        do {
            System.out.println("\nSeleccione un mozo de la lista (por codigo):");
            mostrarMozos();
            this.mozoId = leeEntero();
            
            for (Usuario item : mozos) {
                if (item.getLegajo() == this.mozoId){
                    this.mozo = item;
                    seleccionValida = true;   
                    break;
                }
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

    @Override
    public void cancelar() {
        //volver al menu principal
    }
    
}
