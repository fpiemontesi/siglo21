/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaz;

import java.sql.SQLException;
import modelo.dominio.Estado;

/**
 *
 * @author franc
 */
public interface EstadoDao {
    Estado obtenerPorTiempoDemora(int tiempoDemora) throws SQLException;
    Estado obtenerLiviano() throws SQLException;
}
