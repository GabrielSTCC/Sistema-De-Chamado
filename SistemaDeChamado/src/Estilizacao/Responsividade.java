package Estilizacao;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Responsividade extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	
	public Responsividade(String img) {
		this.img = new ImageIcon(img).getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

	}
	

}
