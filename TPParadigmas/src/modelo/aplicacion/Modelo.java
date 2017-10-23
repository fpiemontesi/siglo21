/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import dao.interfaz.FabricaDao;
import dao.implementacion.FabricaImplementacionDao;

/**
 *
 * @author franc
 */
public abstract class Modelo {
    protected final FabricaDao fabricaDao = new FabricaImplementacionDao();
}
