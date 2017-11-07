/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

/**
 *
 * @author franc
 */
public class Pedido {
    private int numero;
    private int mesa;
    private Usuario mozo;
    private Menu menu;
    private Cocina cocina;
    
    public Pedido(){
        
    }

    public Pedido(int numero, int mesa) {
        this.numero = numero;
        this.mesa = mesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public Usuario getMozo() {
        return mozo;
    }

    public void setMozo(Usuario mozo) {
        this.mozo = mozo;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Cocina getCocina() {
        return cocina;
    }

    public void setCocina(Cocina cocina) {
        this.cocina = cocina;
    }

    @Override
    public String toString() {
        return numero + " - " + mesa;
    }
}
