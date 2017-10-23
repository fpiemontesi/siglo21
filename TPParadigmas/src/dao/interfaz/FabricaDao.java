/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaz;

/**
 *
 * @author franc
 */
public abstract class FabricaDao {
    public abstract ProductoDao getProductoDao();
    public abstract CocinaDao getCocinaDao();
    public abstract EstadoDao getEstadoDao();
    public abstract PedidoDao getPedidoDao();
    public abstract UsuarioDao getUsuarioDao();
}
