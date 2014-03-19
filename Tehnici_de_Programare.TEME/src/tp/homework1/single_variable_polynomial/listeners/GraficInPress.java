package tp.homework1.single_variable_polynomial.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tp.homework1.single_variable_polynomial.gui.InputWindow;
import tp.homework1.single_variable_polynomial.gui.MainFrame;
import tp.homework1.single_variable_polynomial.gui.Parser;
import tp.homework1.single_variable_polynomial.gui.PlotWindow;
import tp.homework1.single_variable_polynomial.logic.Polinom;

public class GraficInPress implements MouseListener {

	private InputWindow in;
	private PlotWindow out;

	public GraficInPress(InputWindow in, PlotWindow out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		out.getPlot().removeAllPlots();
		out.getPlot().repaint();
		out.getPlot().revalidate();

		Parser p = new Parser();
		Polinom graficY = p.toPolinom(in.getTextFieldPolinom2().getText());
		double[] yAxis = new double[30];
		double[] xAxis = new double[30];
		for (int i = 0; i < yAxis.length; i++) {
			yAxis[i] = graficY.evaluare(i - 15);
			xAxis[i] = i - 15;
		}
		out.getPlot().addLinePlot("Grafic Polinom InputPanel", xAxis, yAxis);
		out.getPlot().repaint();
		out.getPlot().revalidate();
		MainFrame b = new MainFrame();
		b.getMainWnd().getContentPane().add(out.getPlot());
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
