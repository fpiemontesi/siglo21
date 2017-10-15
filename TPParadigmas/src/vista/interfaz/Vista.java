/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaz;

import controlador.Controlador;

/**
 *
 * @author franc
 */
public interface Vista {
    void setControlador(Controlador controlador);
    
    void iniciarVista();
}
