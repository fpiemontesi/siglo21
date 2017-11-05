package vista.interfaz;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import controlador.Controlador;
import modelo.dominio.Menu;
import modelo.dominio.Usuario;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Pedido extends JInternalFrame implements VistaPedido,ActionListener {
	private Controlador controlador;
	private JTextField txtNumeroPedido;
	private JTextField txtNumeroMesa;
	private int numero;
    private int mesa;
    private int mozoId;
    private int menuId;
    private Usuario mozo;
    private Menu menu;
    private ArrayList<Usuario> mozos;
    private ArrayList<Menu> menus;
    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnCancelar = new JButton("Cancelar");
    private JComboBox cmbMenu = new JComboBox();
    private JComboBox cmbMozos = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedido frame = new Pedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pedido() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
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
		cargarComboMozo(cmbMozos);
		
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
		cmbMenu.addItem("1 Principal");
		cmbMenu.addItem("2 Ejecutivo)");
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 8;
		getContentPane().add(panel, gbc_panel);
		
		panel.add(btnGuardar);
		btnGuardar.addActionListener(this);
		
		
		panel.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
	}

	@Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public int getMesa() {
        return this.mesa;
    }

    @Override
    public Usuario getMozo() {
        return this.mozo;
    }
    
    @Override
    public Menu getMenu(){
        return this.menu;
    }

    @Override
    public void buscarMozos() {
        controlador.actionPerformed(new ActionEvent(this, 0, BUSCAR_MOZOS));
    }
    
    @Override
    public void cargarMozos(ArrayList<Usuario> mozos){
        this.mozos = mozos;
    }
    
     @Override
    public void buscarMenus() {
        controlador.actionPerformed(new ActionEvent(this, 0, BUSCAR_MENUS));
    }
    
    @Override
    public void cargarMenus(ArrayList<Menu> menus){
        this.menus = menus;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void iniciarVista() {        
       
    }
    
    @Override
    public void imprimeResultado(String resultado) {
    	JOptionPane.showMessageDialog(null,resultado);
    }

    @Override
    public void imprimeError(Exception e) {
    	JOptionPane.showMessageDialog(null,e.getMessage());
    }
    
    
    
    private void cargarComboMozo(JComboBox cmbMozos ){
        if (mozos!=null) {
        	for (Usuario item : mozos) {
            	cmbMozos.addItem(item.getLegajo());
            }
        }
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnGuardar) {
			this.numero=Integer.parseInt(txtNumeroMesa.getText());
		    this.mesa=Integer.parseInt(txtNumeroMesa.getText());
		    this.mozoId=Integer.parseInt(cmbMozos.getSelectedItem().toString());
		    this.menuId=Integer.parseInt(cmbMenu.getSelectedItem().toString());
			controlador.actionPerformed(new ActionEvent(this, 1, GUARDAR));
			JOptionPane.showMessageDialog(null, "Se cargo correctamente el pedido");
			limpiarCampos();
		}else if(e.getSource()==btnCancelar) {
			this.setVisible(false);
		}
		
		
	}

	private void limpiarCampos() {
		txtNumeroMesa.setText("");
		txtNumeroPedido.setText("");
		
	}
	

}
