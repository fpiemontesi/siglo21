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
public abstract class Menu {
    private int numero;
    private String nombre;
    private String descripcion;
    private int tiempoDemora;
    private ArrayList<Producto> productos;

    public Menu(int numero, String nombre, String descripcion, int tiempoDemora) {
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoDemora = tiempoDemora;
    }    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempoDemora() {
        return tiempoDemora;
    }

    public void setTiempoDemora(int tiempoDemora) {
        this.tiempoDemora = tiempoDemora;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return numero + " - " + nombre;
    }
}
