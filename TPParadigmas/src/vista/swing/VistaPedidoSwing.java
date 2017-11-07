package vista.swing;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import controlador.Controlador;
import modelo.dominio.Menu;
import modelo.dominio.Usuario;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.dominio.Pedido;
import vista.interfaz.VistaPedido;

public class VistaPedidoSwing extends JFrame implements VistaPedido {

    private Controlador controlador;
    private JTextField txtNumeroPedido;
    private JTextField txtNumeroMesa;
    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnCancelar = new JButton("Cancelar");
    private JComboBox<Menu> cmbMenu = new JComboBox();
    private JComboBox<Usuario> cmbMozos = new JComboBox();
    private JComboBox<Pedido> cmbPedidos = new JComboBox();

    /**
     * Create the frame.
     */
    public VistaPedidoSwing() {
//		setMaximizable(true);
//		setIconifiable(true);
//		setClosable(true);
        setTitle("Nuevo Pedido");
        setBounds(100, 100, 450, 300);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Numero Pedido:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        txtNumeroPedido = new JTextField();
        GridBagConstraints gbc_txtNumeroPedido = new GridBagConstraints();
        gbc_txtNumeroPedido.anchor = GridBagConstraints.WEST;
        gbc_txtNumeroPedido.insets = new Insets(0, 0, 5, 0);
        gbc_txtNumeroPedido.gridx = 1;
        gbc_txtNumeroPedido.gridy = 1;
        getContentPane().add(txtNumeroPedido, gbc_txtNumeroPedido);
        txtNumeroPedido.setColumns(10);

        JLabel lblNumeroMesa = new JLabel("Numero Mesa:");
        GridBagConstraints gbc_lblNumeroMesa = new GridBagConstraints();
        gbc_lblNumeroMesa.anchor = GridBagConstraints.EAST;
        gbc_lblNumeroMesa.insets = new Insets(0, 0, 5, 5);
        gbc_lblNumeroMesa.gridx = 0;
        gbc_lblNumeroMesa.gridy = 2;
        getContentPane().add(lblNumeroMesa, gbc_lblNumeroMesa);

        txtNumeroMesa = new JTextField();
        GridBagConstraints gbc_txtNumeroMesa = new GridBagConstraints();
        gbc_txtNumeroMesa.anchor = GridBagConstraints.WEST;
        gbc_txtNumeroMesa.insets = new Insets(0, 0, 5, 0);
        gbc_txtNumeroMesa.gridx = 1;
        gbc_txtNumeroMesa.gridy = 2;
        getContentPane().add(txtNumeroMesa, gbc_txtNumeroMesa);
        txtNumeroMesa.setColumns(10);

        JLabel lblListaMozos = new JLabel("Lista mozos:");
        GridBagConstraints gbc_lblListaMozos = new GridBagConstraints();
        gbc_lblListaMozos.anchor = GridBagConstraints.EAST;
        gbc_lblListaMozos.insets = new Insets(0, 0, 5, 5);
        gbc_lblListaMozos.gridx = 0;
        gbc_lblListaMozos.gridy = 3;
        getContentPane().add(lblListaMozos, gbc_lblListaMozos);

        GridBagConstraints gbc_cmbMozos = new GridBagConstraints();
        gbc_cmbMozos.anchor = GridBagConstraints.WEST;
        gbc_cmbMozos.insets = new Insets(0, 0, 5, 0);
        gbc_cmbMozos.gridx = 1;
        gbc_cmbMozos.gridy = 3;
        getContentPane().add(cmbMozos, gbc_cmbMozos);

        JLabel lblSeleccionarMenu = new JLabel(" Seleccionar menu:");
        GridBagConstraints gbc_lblSeleccionarMenu = new GridBagConstraints();
        gbc_lblSeleccionarMenu.anchor = GridBagConstraints.EAST;
        gbc_lblSeleccionarMenu.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionarMenu.gridx = 0;
        gbc_lblSeleccionarMenu.gridy = 4;
        getContentPane().add(lblSeleccionarMenu, gbc_lblSeleccionarMenu);

        GridBagConstraints gbc_cmbMenu = new GridBagConstraints();
        gbc_cmbMenu.insets = new Insets(0, 0, 5, 0);
        gbc_cmbMenu.anchor = GridBagConstraints.WEST;
        gbc_cmbMenu.gridx = 1;
        gbc_cmbMenu.gridy = 4;
        getContentPane().add(cmbMenu, gbc_cmbMenu);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 8;
        getContentPane().add(panel, gbc_panel);

        panel.add(btnGuardar);

        panel.add(btnCancelar);

    }

    @Override
    public int getNumero() {
        return Integer.parseInt(txtNumeroPedido.getText());
    }

    @Override
    public int getMesa() {
        return Integer.parseInt(txtNumeroMesa.getText());
    }

    @Override
    public Usuario getMozo() {
        return (Usuario)cmbMozos.getSelectedItem();
    }

    @Override
    public Menu getMenu() {
        return (Menu)cmbMenu.getSelectedItem();
    }

    @Override
    public void buscarMozos() {
        controlador.actionPerformed(new ActionEvent(this, 0, BUSCAR_MOZOS));
    }

    @Override
    public void cargarMozos(ArrayList<Usuario> mozos) {
        for (Usuario mozo : mozos) {
            cmbMozos.addItem(mozo);
        }
    }

    @Override
    public void buscarMenus() {
        controlador.actionPerformed(new ActionEvent(this, 0, BUSCAR_MENUS));
    }

    @Override
    public void cargarMenus(ArrayList<Menu> menus) {
        for (Menu menu : menus) {
            cmbMenu.addItem(menu);
        }
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        
        this.btnGuardar.addActionListener(controlador);
        this.btnGuardar.setActionCommand(VistaPedido.GUARDAR);
        
        this.btnCancelar.addActionListener(controlador);
        this.btnCancelar.setActionCommand(VistaPedido.CANCELAR);
    }

    @Override
    public void iniciarVista() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        buscarMenus();
        buscarMozos();
        buscarPedidos();
    }

    @Override
    public void imprimeResultado(String resultado) {
        JOptionPane.showMessageDialog(null, resultado);
    }

    @Override
    public void imprimeError(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }

    private void limpiarCampos() {
        txtNumeroMesa.setText("");
        txtNumeroPedido.setText("");
    }

    @Override
    public Pedido getPedidoACerrar() {
        return (Pedido)cmbPedidos.getSelectedItem();
    }

    @Override
    public void buscarPedidos() {
        controlador.actionPerformed(new ActionEvent(this, 0, VistaPedido.BUSCAR_PEDIDOS));
    }

    @Override
    public void cargarPedidos(ArrayList<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            cmbPedidos.addItem(pedido);
        }
    }

    @Override
    public void cancelar() {
        this.dispose();
    }

}
