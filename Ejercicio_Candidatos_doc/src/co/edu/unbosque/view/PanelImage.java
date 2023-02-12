/**
 * calse que pertenece al paquete view
 */
package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Clase encargada de generar visualizacion en el panel
 * 
 * @author Santiago Giraldo
 * @author Cristian Escamilla
 */
public class PanelImage extends JPanel{
	
	private Image image;
	
	@Override
	public void paint(Graphics g) {
		
		image = new ImageIcon(getClass().getResource("/images/background.JPG")).getImage();
		
		g.drawImage(image, 0, 0, 650, 350, getFocusCycleRootAncestor());
		
		setOpaque(false);
		super.paint(g);
	}
	
}
