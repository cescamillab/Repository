/**
 * clase que pertenece al paquete view
 */
package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase encargada de generar la ventana para la visualizacion
 * 
 * @author Santiago Giraldo
 * @author Cristian Escamilla
 */
public class PrincipalWindow extends JFrame {

	private static final long serialVersionUID = -6769638857830900014L;
	private PanelImage panelImage;
	private JButton create;
	private JButton read;
	private JButton update;
	private JButton delete;
	/**
	 * Metodo Constructor
	 */
	public PrincipalWindow() {
		
		setTitle("Candidatos");
		setSize(650,350);
		panelImage = new PanelImage();
		this.setContentPane(panelImage);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		initializeComponents();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void initializeComponents() {
		
		create = new JButton();
		create.setBounds(105, 38, 45, 60);
		create.setBorderPainted(false);
		create.setFocusPainted(false);
		create.setBorder(null);
		create.setContentAreaFilled(false);
		create.setActionCommand("CREATE");
		add(create);
		
		read = new JButton();
		read.setBounds(210, 40, 65, 58);
		read.setBorderPainted(false);
		read.setFocusPainted(false);
		read.setBorder(null);
		read.setContentAreaFilled(false);
		read.setActionCommand("READ");
		add(read);
		
		update = new JButton();
		update.setBounds(345, 34, 48, 66);
		update.setBorderPainted(false);
		update.setFocusPainted(false);
		update.setBorder(null);
		update.setContentAreaFilled(false);
		update.setActionCommand("UPDATE");
		add(update);
		
		delete = new JButton();
		delete.setBounds(470, 33, 38, 65);
		delete.setBorderPainted(false);
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setContentAreaFilled(false);
		delete.setActionCommand("DELETE");
		add(delete);
		
	}
	
	public void mostrarMensaje(String message, String tittle) {
			JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String captureData(String message, String tittle) {
		return JOptionPane.showInputDialog(null, message, tittle, JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 * @return the create
	 */
	public JButton getCreate() {
		return create;
	}

	/**
	 * @return the read
	 */
	public JButton getRead() {
		return read;
	}

	/**
	 * @return the update
	 */
	public JButton getUpdate() {
		return update;
	}
	/**
	 * @return the delete
	 */
	public JButton getDelete() {
		return delete;
	}

	
}
