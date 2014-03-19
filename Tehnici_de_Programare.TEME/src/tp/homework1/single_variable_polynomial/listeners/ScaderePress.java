package tp.homework1.single_variable_polynomial.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tp.homework1.single_variable_polynomial.gui.InputWindow;
import tp.homework1.single_variable_polynomial.gui.MainFrame;
import tp.homework1.single_variable_polynomial.gui.OutputWindow;
import tp.homework1.single_variable_polynomial.gui.Parser;
import tp.homework1.single_variable_polynomial.gui.PlotWindow;
import tp.homework1.single_variable_polynomial.logic.Polinom;

/**
 * Clasa responsabila de realizarea unui ascultator pentru butonul de scadere.
 * Constructorul va lua ca parametrii fereastra de input in care s-a scris, si
 * ca al doilea parametru, fereastra de output unde se va dori afisa rezultatul
 * 
 * @author razvan
 * 
 */
public class ScaderePress implements MouseListener {
	private InputWindow in;
	private OutputWindow out = new OutputWindow();
	private PlotWindow outP = new PlotWindow();

	public ScaderePress(InputWindow inputWindow, OutputWindow outputWindow,
			PlotWindow outP) {
		// TODO Auto-generated constructor stub
		this.in = inputWindow;
		this.out = outputWindow;
		this.outP = outP;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		outP.getPlot().removeAllPlots();
		outP.getPlot().repaint();
		outP.getPlot().revalidate();
		Parser p = new Parser();
		double[] yAxis = new double[30];
		double[] xAxis = new double[30];
		Polinom dif = p.toPolinom(in.getTextFieldPolinom1().getText()).sub(
				p.toPolinom(in.getTextFieldPolinom2().getText()));
		String htmlModifier = dif.toString();
		for (int i = 0; i < yAxis.length; i++) {
			yAxis[i] = dif.evaluare(i - 15);
			xAxis[i] = i - 15;
		}
		out.getResultLabel().setText(htmlModifier);
		out.getPanel().repaint();
		out.getPanel().revalidate();
		outP.getPlot().addLinePlot("Grafic Polinom : ", xAxis, yAxis);
		outP.getPlot().repaint();
		outP.getPlot().revalidate();
		MainFrame b = new MainFrame();
		b.getMainWnd().getContentPane().add(out.getPanel());
		b.getMainWnd().getContentPane().add(outP.getPlot());
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
