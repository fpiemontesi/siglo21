/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import dao.CocinaDao;
import dao.CocinaImplementacionDao;
import java.sql.SQLException;
import modelo.dominio.Cocina;

/**
 *
 * @author franc
 */
public class ModeloCocina {
    
    private CocinaDao dao;
    
    public ModeloCocina(){
        this.dao = new CocinaImplementacionDao();
    }
    
    public boolean guardar(Cocina cocina) throws SQLException {
        return this.dao.guardar(cocina);
    }
}
