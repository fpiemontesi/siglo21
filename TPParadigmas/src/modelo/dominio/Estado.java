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
public class Estado {
    private int id;
    private String nombre;
    private String descripcion;
    private int tiempoDemoraDesde;
    private int tiempoDemoraHasta;
    
    public Estado(int id, String nombre, String descripcion, int tiempoDemoraDesde, int tiempoDemoraHasta){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoDemoraDesde = tiempoDemoraDesde;
        this.tiempoDemoraHasta = tiempoDemoraHasta;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tiempoDemoraHasta
     */
    public int getTiempoDemoraHasta() {
        return tiempoDemoraHasta;
    }

    /**
     * @param tiempoDemoraHasta the tiempoDemoraHasta to set
     */
    public void setTiempoDemoraHasta(int tiempoDemoraHasta) {
        this.tiempoDemoraHasta = tiempoDemoraHasta;
    }
}
