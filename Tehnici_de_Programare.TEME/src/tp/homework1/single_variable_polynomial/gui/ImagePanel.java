package tp.homework1.single_variable_polynomial.gui;

import java.awt.Graphics;
import java.awt.Image;

//import java.net.URL;
//import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * Clasa responsabila de incarcarea imaginii pe panel-ul de Output, printr-un obiect de tip image
 * @author razvan
 *
 */
public class ImagePanel extends JPanel {
	private Image image;

	ImagePanel(Image image) {
		this.image = image;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
