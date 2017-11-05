package vista.interfaz;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import controlador.Controlador;
import modelo.dominio.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Producto extends JInternalFrame implements VistaProducto,ActionListener {
	 	private Controlador controlador;
	 	private String nombre;
	    private String marca;
	    private String tipo;
	    private JTextField txtNombre;
	    private JTextField txtMarca;
	    private JComboBox cmbMenu = new JComboBox();
	    private JButton btnGuardar= new JButton("Aceptar");
	    private JButton btnCancelar = new JButton("Cancelar");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto frame = new Producto();
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
	public Producto() {
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
		cargarComboProducto(cmbMenu);
		
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
	    	JOptionPane.showMessageDialog(null,resultado);
	    }

	    @Override
	    public void imprimeError(Exception e) {
	    	JOptionPane.showMessageDialog(null,e.getMessage());
	    }
	    
	     @Override
	    public String getNombre() {
	         return this.nombre;
	    }

	    @Override
	    public String getMarca() {
	        return this.marca;
	    }

	    @Override
	    public String getTipo() {
	        return this.tipo;
	    }

	    @Override
	    public void setControlador(Controlador controlador) {
	        this.controlador = controlador;
	    }

	    @Override
	    public void iniciarVista() {
	       // imprimeMenu();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnGuardar) {
				this.nombre=txtNombre.getText();
			    this.marca=txtMarca.getText();
			    if(cmbMenu.getSelectedIndex()==0) {
			    	this.tipo="1";
			    }else {
			    	this.tipo="2";
			    }
				controlador.actionPerformed(new ActionEvent(this, 1, GUARDAR));
				JOptionPane.showMessageDialog(null, "Se cargo correctamente el pedido");
				limpiarCampos();
			}else if(e.getSource()==btnCancelar) {
				this.setVisible(false);
			}
			
		}
		
		private void limpiarCampos() {
			txtNombre.setText("");
			txtMarca.setText("");
			
		}
		
		private void cargarComboProducto(JComboBox cmbProducto ){
			cmbProducto.addItem("1 - Menu");
			cmbProducto.addItem("2 - Ejecutivo");
	    	
	    }

}
