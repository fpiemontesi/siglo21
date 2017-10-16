/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public interface UsuarioDao {
    ArrayList<Usuario> obtenerPorTipoDeUsuario(String tipoDeUsuario) throws SQLException;
}
