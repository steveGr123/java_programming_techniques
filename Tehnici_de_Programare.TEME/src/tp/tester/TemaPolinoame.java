package tp.tester;

import javax.swing.SwingUtilities;

import tp.homework1.single_variable_polynomial.gui.InputWindow;
import tp.homework1.single_variable_polynomial.gui.MainFrame;
import tp.homework1.single_variable_polynomial.gui.OutputWindow;
import tp.homework1.single_variable_polynomial.gui.PlotWindow;

public class TemaPolinoame {

	/**
	 * Clasa Test. Se utilizeaza SwingUtilities.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame b = new MainFrame();
				b.getMainWnd().setVisible(true);
				b.getMainWnd().getContentPane()
						.add(new InputWindow().getPanel());
				b.getMainWnd().getContentPane()
						.add(new OutputWindow().getPanel());

				b.getMainWnd().getContentPane().add(new PlotWindow().getPlot());
			}
		});
	}

}