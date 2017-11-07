/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.swing;

import controlador.Controlador;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.dominio.Menu;
import modelo.dominio.Pedido;
import modelo.dominio.Usuario;
import vista.interfaz.VistaPedido;

/**
 *
 * @author franc
 */
public class VistaFinalizarPedidoSwing extends javax.swing.JFrame implements VistaPedido {
    private Controlador controlador;
    private JComboBox<Pedido> cmbPedido = new JComboBox<Pedido>();
    private JButton btnFinalizarPedido = new JButton("Finalizar Pedido");
    private JButton btnCancelar = new JButton("Cancelar");


    public VistaFinalizarPedidoSwing() {
        setTitle("Nuevo Producto");
        setBounds(100, 100, 450, 300);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);        

        JLabel lblMenu = new JLabel("Pedidos:");
        GridBagConstraints gbc_lblMenu = new GridBagConstraints();
        gbc_lblMenu.anchor = GridBagConstraints.EAST;
        gbc_lblMenu.insets = new Insets(0, 0, 5, 5);
        gbc_lblMenu.gridx = 0;
        gbc_lblMenu.gridy = 5;
        getContentPane().add(lblMenu, gbc_lblMenu);

        GridBagConstraints gbc_cmbMenu = new GridBagConstraints();
        gbc_cmbMenu.insets = new Insets(0, 0, 5, 0);
        gbc_cmbMenu.anchor = GridBagConstraints.WEST;
        gbc_cmbMenu.gridx = 1;
        gbc_cmbMenu.gridy = 5;
        getContentPane().add(cmbPedido, gbc_cmbMenu);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 7;
        getContentPane().add(panel, gbc_panel);

        panel.add(btnFinalizarPedido);
        panel.add(btnCancelar);

    }

    @Override
    public void imprimeResultado(String resultado) {
        JOptionPane.showMessageDialog(null, resultado);
    }

    @Override
    public void imprimeError(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        
        this.btnFinalizarPedido.addActionListener(controlador);
        this.btnFinalizarPedido.setActionCommand(VistaPedido.CERRAR_PEDIDO);
        
        this.btnCancelar.addActionListener(controlador);
        this.btnCancelar.setActionCommand(VistaPedido.CANCELAR);
    }

    @Override
    public void iniciarVista() {
        this.buscarPedidos();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void cancelar() {
        this.dispose();
    }

    @Override
    public int getNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMesa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getMozo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Menu getMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido getPedidoACerrar() {
        return (Pedido)cmbPedido.getSelectedItem();
    }

    @Override
    public void buscarMozos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarMozos(ArrayList<Usuario> mozos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarMenus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarMenus(ArrayList<Menu> menus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarPedidos() {
        this.controlador.actionPerformed(new ActionEvent(this, 0, VistaPedido.BUSCAR_PEDIDOS));
    }

    @Override
    public void cargarPedidos(ArrayList<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            cmbPedido.addItem(pedido);
        }
    }
}
