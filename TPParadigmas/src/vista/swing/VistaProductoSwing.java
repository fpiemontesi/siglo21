package vista.swing;

import controlador.Controlador;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelo.dominio.Menu;
import vista.interfaz.VistaProducto;

public class VistaProductoSwing extends javax.swing.JFrame implements VistaProducto {

    private Controlador controlador;
    private JTextField txtNombre;
    private JTextField txtMarca;
    private JComboBox<Menu> cmbMenu = new JComboBox<Menu>();
    private JButton btnGuardar = new JButton("Aceptar");
    private JButton btnCancelar = new JButton("Cancelar");

    public VistaProductoSwing() {
        setTitle("Nuevo Producto");
        setBounds(100, 100, 450, 300);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("  Nombre:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        txtNombre = new JTextField();
        GridBagConstraints gbc_txtNombre = new GridBagConstraints();
        gbc_txtNombre.anchor = GridBagConstraints.WEST;
        gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
        gbc_txtNombre.gridx = 1;
        gbc_txtNombre.gridy = 1;
        getContentPane().add(txtNombre, gbc_txtNombre);
        txtNombre.setColumns(10);

        JLabel lblMarca = new JLabel("Marca:");
        GridBagConstraints gbc_lblMarca = new GridBagConstraints();
        gbc_lblMarca.anchor = GridBagConstraints.EAST;
        gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
        gbc_lblMarca.gridx = 0;
        gbc_lblMarca.gridy = 3;
        getContentPane().add(lblMarca, gbc_lblMarca);

        txtMarca = new JTextField();
        GridBagConstraints gbc_txtMarca = new GridBagConstraints();
        gbc_txtMarca.anchor = GridBagConstraints.WEST;
        gbc_txtMarca.insets = new Insets(0, 0, 5, 0);
        gbc_txtMarca.gridx = 1;
        gbc_txtMarca.gridy = 3;
        getContentPane().add(txtMarca, gbc_txtMarca);
        txtMarca.setColumns(10);

        JLabel lblMenu = new JLabel("Menu:");
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
        getContentPane().add(cmbMenu, gbc_cmbMenu);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 7;
        getContentPane().add(panel, gbc_panel);

        panel.add(btnGuardar);
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
    public String getNombre() {
        return txtNombre.getText();
    }

    @Override
    public String getMarca() {
        return txtMarca.getText();
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        
        this.btnGuardar.addActionListener(controlador);
        this.btnGuardar.setActionCommand(VistaProducto.GUARDAR);
        
        this.btnCancelar.addActionListener(controlador);
        this.btnCancelar.setActionCommand(VistaProducto.CANCELAR);
    }

    @Override
    public void iniciarVista() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.buscarMenus();
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtMarca.setText("");
    }

    @Override
    public String getMenu() {
        return ((Menu)cmbMenu.getSelectedItem()).getNombre();
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
    public void cancelar() {
        this.dispose();
    }

}
