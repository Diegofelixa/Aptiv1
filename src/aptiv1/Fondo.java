package aptiv1;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	
	
	public Fondo() {
		this.setSize(930,500);
	}
	
	public void paint(Graphics g) {
		
		Dimension tamanio=getSize();
		ImageIcon imagen= new ImageIcon (getClass().getResource("/imagenes/aptiv-media.jpg"));
		g.drawImage(imagen.getImage(),0,0, tamanio.width,tamanio.height,null);
		setOpaque(false);
		super.paint(g);
	}
	
	

}
