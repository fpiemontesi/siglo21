/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.interfaz.EstadoDao;
import dao.interfaz.FabricaDao;
import dao.interfaz.CocinaDao;
import dao.interfaz.ProductoDao;
import dao.interfaz.PedidoDao;
import dao.interfaz.UsuarioDao;

/**
 *
 * @author franc
 */
public class FabricaImplementacionDao extends FabricaDao {

    @Override
    public ProductoDao getProductoDao() {
        return new ProductoImplementacionDao();
    }

    @Override
    public CocinaDao getCocinaDao() {
        return new CocinaImplementacionDao();
    }

    @Override
    public EstadoDao getEstadoDao() {
        return new EstadoImplementacionDao();
    }

    @Override
    public PedidoDao getPedidoDao() {
        return new PedidoImplementacionDao();
    }

    @Override
    public UsuarioDao getUsuarioDao() {
        return new UsuarioImplementacionDao();
    }
    
}
