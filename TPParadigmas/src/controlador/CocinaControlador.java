/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CocinaDao;
import dao.CocinaImplementacionDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dominio.Cocina;

/**
 *
 * @author franc
 */
public class CocinaControlador {
    
    public CocinaControlador(){
        
    }
    
    public ArrayList<Cocina> obtenerCocinas(){
        CocinaDao dao = new CocinaImplementacionDao();
        
        ArrayList<Cocina> resultado = null;
        try {
            resultado = dao.obtenerTodas();
        } catch (SQLException ex) {
            Logger.getLogger(CocinaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
}
