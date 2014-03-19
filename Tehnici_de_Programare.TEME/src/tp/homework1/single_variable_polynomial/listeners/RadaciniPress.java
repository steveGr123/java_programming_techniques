package tp.homework1.single_variable_polynomial.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tp.homework1.single_variable_polynomial.gui.InputWindow;
import tp.homework1.single_variable_polynomial.gui.MainFrame;
import tp.homework1.single_variable_polynomial.gui.OutputWindow;
import tp.homework1.single_variable_polynomial.gui.Parser;
import tp.homework1.single_variable_polynomial.logic.Polinom;

/**
 * Clasa responsabila de realizarea unui ascultator pentru butonul de gasire a
 * radacinilor intregi. Constructorul va lua ca parametrii fereastra de input in
 * care s-a scris, si ca al doilea parametru, fereastra de output unde se va
 * dori afisa rezultatul
 * 
 * @author razvan
 * 
 */
public class RadaciniPress implements MouseListener {
	private InputWindow in;
	private OutputWindow out;

	public RadaciniPress(InputWindow inputWindow, OutputWindow outputWindow) {
		// TODO Auto-generated constructor stub
		this.in = inputWindow;
		this.out = outputWindow;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Parser p = new Parser();
		String parsableText = in.getTextFieldPolinom1().getText();
		String htmlModifier = "";
		final Polinom rezultat = p.toPolinom(parsableText);
		final int rez = rezultat.primitiveRootSearch();
		htmlModifier = "Numarul de radacini : " + rez + "\n";
		out.getResultLabel().setText(
				"<html><p style=font-family:monospace;color:green;font-size:13px;>"
						+ htmlModifier + "</p></html>");
		out.getPanel().repaint();
		out.getPanel().revalidate();
		MainFrame b = new MainFrame();
		b.getMainWnd().getContentPane().add(out.getPanel());
		b.getMainWnd().setVisible(true);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
