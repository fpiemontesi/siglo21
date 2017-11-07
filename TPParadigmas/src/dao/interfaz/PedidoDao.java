/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.Cocina;
import modelo.dominio.Pedido;

/**
 *
 * @author franc
 */
public interface PedidoDao {
    ArrayList<Pedido> obtenerAbiertos() throws SQLException;
    boolean guardar(Pedido pedido) throws SQLException;
    boolean cerrar(Pedido pedido) throws SQLException;
    void cargarPedidos(Cocina cocina) throws SQLException;
}
