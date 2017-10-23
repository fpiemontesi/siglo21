/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import dao.interfaz.PedidoDao;
import java.sql.SQLException;
import modelo.dominio.Pedido;

/**
 *
 * @author franc
 */
public class ModeloPedido extends Modelo {
    private final PedidoDao dao = fabricaDao.getPedidoDao();
       
    public boolean crear(Pedido pedido) throws SQLException{
        return this.dao.guardar(pedido);
    }
}
