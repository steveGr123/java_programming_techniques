package tp.homework1.single_variable_polynomial.gui;

import javax.swing.BoxLayout;

import org.math.plot.Plot2DPanel;

/**
 * Clasa ce contine un panel responsabil de aparitia graficului
 * 
 * @author razvan
 * 
 */
public class PlotWindow {

	private Plot2DPanel plot = new Plot2DPanel();

	/**
	 * jMathPlot are o clasa {@link Plot2DPanel} ce extinde clasa JPanel,
	 * specializata in "desenarea" de grafice, fie 2D, fie 3D
	 * 
	 */
	public PlotWindow() {
		plot.setLayout(new BoxLayout(plot, BoxLayout.PAGE_AXIS));
		plot.setBounds(720, 0, 560, 480);
		plot.setVisible(true);
		plot.plotLegend.setVisible(true);
		plot.plotCanvas.setVisible(true);

	}

	public Plot2DPanel getPlot() {
		return plot;
	}

}
