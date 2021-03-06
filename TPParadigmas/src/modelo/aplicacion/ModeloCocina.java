/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.aplicacion;

import dao.interfaz.CocinaDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dominio.Cocina;
import modelo.dominio.Estado;
import modelo.dominio.Observer;
import modelo.dominio.Subject;
import modelo.dominio.Usuario;

/**
 *
 * @author franc
 */
public class ModeloCocina extends Modelo implements Observer {
    private final CocinaDao dao = fabricaDao.getCocinaDao();
    
    private ArrayList<Cocina> cocinas;
    
    public ModeloCocina(){
        this.cocinas = new ArrayList<Cocina>();
    }
    
    public boolean guardar(Cocina cocina) throws SQLException {
        boolean resultado = this.dao.guardar(cocina);
        
        if (resultado)
            cocinas.add(cocina);
        
        return resultado;
    }
    
    public ArrayList<Cocina> obtenerTodas() throws SQLException{
        this.cocinas = this.dao.obtenerTodas();
        return this.getCocinas();
    }
    
    public Cocina obtenerDisponible() throws SQLException{
        Cocina resultado = null;
        
        int tiempoPorPedido = 2;//en minutos
        
        obtenerTodas();
        Estado estadoDemorado = fabricaDao.getEstadoDao().obtenerDemorado();

        for (Cocina cocina : this.cocinas) {
            fabricaDao.getPedidoDao().cargarPedidos(cocina);
            int tiempoTotalCocina = cocina.getPedidos().size() * tiempoPorPedido;
            Estado estadoCocina = fabricaDao.getEstadoDao().obtenerPorTiempoDemora(tiempoPorPedido);
            if (estadoCocina != estadoDemorado){
                resultado = cocina;
                break;
            }
        }
        
        return resultado;
    }
    
    public boolean hayDisponibilidad() throws SQLException {
        boolean hayDisponibilidad = true;
        int tiempoPorPedido = 2;//en minutos
        
        obtenerTodas();
        Estado estadoDemorado = fabricaDao.getEstadoDao().obtenerDemorado();

        for (Cocina cocina : this.cocinas) {
            fabricaDao.getPedidoDao().cargarPedidos(cocina);
            int tiempoTotalCocina = cocina.getPedidos().size() * tiempoPorPedido;
            Estado estadoCocina = fabricaDao.getEstadoDao().obtenerPorTiempoDemora(tiempoPorPedido);
            if (estadoCocina == estadoDemorado){
                hayDisponibilidad = false;
            }
        }
        
        return hayDisponibilidad;
    }

    public ArrayList<Cocina> getCocinas() {
        return cocinas;
    }

    @Override
    public void update(Subject subject) {
        try {
            Usuario usuario = fabricaDao.getUsuarioDao().obtenerAdministrador();
            Estado estadoLiviano = fabricaDao.getEstadoDao().obtenerLiviano();
            Cocina cocina = new Cocina("Nueva cocina Generada", usuario, estadoLiviano);
            this.dao.guardar(cocina);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCocina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
