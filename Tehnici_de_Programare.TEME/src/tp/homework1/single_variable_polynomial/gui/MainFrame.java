package tp.homework1.single_variable_polynomial.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Clasa ce afiseaza fereastra pe care se pun toate panel-urile. Backbone-ul
 * interfetei grafice
 * 
 * @author razvan
 * 
 */
public class MainFrame {
	private final Color secretColor = new Color(69, 56, 79);
	private static JFrame mainWnd = new JFrame(
			"TP.HOMEWORK1.FUNCTII_POLINOMIALE.rev2");

	public MainFrame() {

		mainWnd.setSize(1280, 480);
		mainWnd.getContentPane().setLayout(null);
		mainWnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = mainWnd.getToolkit();
		Dimension size = toolkit.getScreenSize();
		mainWnd.setLocation(size.width / 2 - mainWnd.getWidth() / 2,
				size.height / 2 - mainWnd.getHeight() / 2);
		mainWnd.getContentPane().setBackground(secretColor);
	}

	public JFrame getMainWnd() {
		return mainWnd;
	}

}