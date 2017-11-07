/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class Cocina {
    private int id;
    private String nombre;
    private ArrayList<Pedido> pedidos;
    private Usuario cocinero;
    private Estado estado;
    
    public Cocina(String nombre, Usuario cocinero, Estado estado){
        this(0, nombre, cocinero, estado);
    }
    
    public Cocina(int id, String nombre){
        this(id, nombre, null, null);
    }

    public Cocina(int id, String nombre, Usuario cocinero, Estado estado){
        this.id = id;
        this.nombre = nombre;
        this.cocinero = cocinero;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pedidos
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void crearPedidos(){
        this.pedidos = new ArrayList();
    }

    /**
     * @return the cocinero
     */
    public Usuario getCocinero() {
        return cocinero;
    }

    /**
     * @param cocinero the cocinero to set
     */
    public void setCocinero(Usuario cocinero) {
        this.cocinero = cocinero;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cocina{" + "nombre=" + nombre + ", pedidos=" + pedidos + ", cocinero=" + cocinero + ", estado=" + estado + '}';
    }
    
}
