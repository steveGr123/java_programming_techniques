package tp.homework1.single_variable_polynomial.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tp.homework1.single_variable_polynomial.gui.InputWindow;
import tp.homework1.single_variable_polynomial.gui.MainFrame;
import tp.homework1.single_variable_polynomial.gui.OutputWindow;
import tp.homework1.single_variable_polynomial.gui.Parser;

/**
 * Clasa responsabila de realizarea unui ascultator pentru butonul de evaluare a
 * derivatei. Constructorul va lua ca parametrii fereastra de input in care s-a
 * scris, si ca al doilea parametru, fereastra de output unde se va dori afisa
 * rezultatul. Valoarea la care se face evaluarea se va trece in textfieldul de
 * dupa cel de introducere a primului polinom
 * 
 * @author razvan
 * 
 */
public class DerivareEvalPress implements MouseListener {
	private InputWindow in;
	private OutputWindow out;

	public DerivareEvalPress(InputWindow in, OutputWindow out) {
		// TODO Auto-generated constructor stub
		this.in = in;
		this.out = out;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO EXTRA-TEXTFIELD PENTRU VALOARE
		Parser p = new Parser();
		final double result = p.toPolinom(in.getTextFieldPolinom1().getText())
				.evaluareDerivata(
						(Integer.parseInt(in.getTextValue().getText())));
		out.getResultLabel().setText(
				"<html><p style=font-family:monospace;color:green;font-size:13px;>"
						+ result + "</p></html>");
		out.getPanel().repaint();
		out.getPanel().revalidate();
		MainFrame b = new MainFrame();
		b.getMainWnd().add(out.getPanel());
		b.getMainWnd().setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
