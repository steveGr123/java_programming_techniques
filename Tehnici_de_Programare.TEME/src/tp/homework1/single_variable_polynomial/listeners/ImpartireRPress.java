package tp.homework1.single_variable_polynomial.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tp.homework1.single_variable_polynomial.gui.InputWindow;
import tp.homework1.single_variable_polynomial.gui.MainFrame;
import tp.homework1.single_variable_polynomial.gui.OutputWindow;
import tp.homework1.single_variable_polynomial.gui.Parser;
import tp.homework1.single_variable_polynomial.logic.Polinom;

/**
 * Clasa responsabila de realizarea unui ascultator pentru butonul de .
 * Constructorul va lua ca parametrii fereastra de input in care s-a scris, si
 * ca al doilea parametru, fereastra de output unde se va dori afisa rezultatul.
 * Variabila booleana este setata false pentru a returna restul
 * 
 * @author razvan
 * 
 */
public class ImpartireRPress implements MouseListener {

	private InputWindow in;
	private OutputWindow out;

	public ImpartireRPress(InputWindow in, OutputWindow out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Parser p = new Parser();
		final Polinom rem = p.toPolinom(in.getTextFieldPolinom1().getText())
				.div(p.toPolinom(in.getTextFieldPolinom2().getText()), true);
		String htmlModifier = rem.toString();
		out.getResultLabel().setText(htmlModifier);
		out.getPanel().repaint();
		out.getPanel().revalidate();
		MainFrame b = new MainFrame();
		b.getMainWnd().getContentPane().add(out.getPanel());
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
