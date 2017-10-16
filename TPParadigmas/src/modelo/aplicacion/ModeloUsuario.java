/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import dao.UsuarioDao;
import dao.UsuarioImplementacionDao;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public class ModeloUsuario {
    
    private UsuarioDao dao;
    
    public ModeloUsuario(){
        this.dao = new UsuarioImplementacionDao();
    }
    
    public ArrayList<Usuario> obtenerMozos() throws SQLException{
        return this.dao.obtenerPorTipoDeUsuario("MOZO");
    }
}
