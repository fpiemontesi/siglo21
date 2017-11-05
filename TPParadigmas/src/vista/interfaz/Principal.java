package vista.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador;
import controlador.ControladorPrincipal;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class Principal  implements ActionListener,VistaPrincipal{
	private Controlador controlador;
	private JFrame frmPrincipal;
	private JMenuItem nuevoPedido = new JMenuItem("Nuevo");
	private JDesktopPane desktopPane = new JDesktopPane();
	private JMenuItem nuevoProducto = new JMenuItem("Nuevo");
	static final String NUEVO_PRODUCTO = "nuevoProducto";
    static final String NUEVO_PEDIDO = "nuevoPedido";

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setBounds(100, 100, 572, 400);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmPrincipal.getContentPane().add(panel, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
		
		JMenu menuPedido = new JMenu("Pedido");
		menuBar.add(menuPedido);
		menuPedido.add(nuevoPedido);
		nuevoPedido.addActionListener(this);
		
		
		desktopPane.setBackground(Color.BLUE);
		
		JMenu menuProducto = new JMenu("Producto");
		menuProducto.addActionListener(this);
		menuBar.add(menuProducto);
		
		
		menuProducto.add(nuevoProducto);
		nuevoProducto.addActionListener(this);
		
		
		frmPrincipal.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nuevoPedido) {
			controlador.actionPerformed(new ActionEvent(this, 1, NUEVO_PEDIDO));
			Pedido pedido = new Pedido();
			desktopPane.add(pedido);
			pedido.show();
      }else if(e.getSource()==nuevoProducto) {
    		controlador.actionPerformed(new ActionEvent(this, 2, NUEVO_PRODUCTO));
    	  	Producto producto = new Producto();
    	  	desktopPane.add(producto);
    	  	producto.show();
      }
		
	}

	 @Override
	    public void setControlador(Controlador controlador) {
	        this.controlador = controlador;
	    }

	@Override
	public void iniciarVista() {
		main();
		
	}
	

}
