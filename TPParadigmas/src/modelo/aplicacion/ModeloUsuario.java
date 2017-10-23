/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import dao.interfaz.UsuarioDao;
import dao.implementacion.UsuarioImplementacionDao;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public class ModeloUsuario extends Modelo {
    private final UsuarioDao dao = fabricaDao.getUsuarioDao();
    
    public ModeloUsuario(){
    }
    
    public ArrayList<Usuario> obtenerMozos() throws SQLException{
        return this.dao.obtenerPorTipoDeUsuario("MOZO");
    }
}
