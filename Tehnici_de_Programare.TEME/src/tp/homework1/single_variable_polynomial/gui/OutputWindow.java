package tp.homework1.single_variable_polynomial.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clasa responsabila de afisarea rezultatelor in urma efectuarii actiunilor
 * necesare de catre utilizator
 * 
 * @author razvan
 * 
 */
public class OutputWindow {
	private JPanel panel1 = new JPanel();
	private JLabel resultLabel;

	/**
 * 
 */
	public OutputWindow() {
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		GridBagConstraints constraints2 = new GridBagConstraints();

		panel1.setBounds(400, 0, 320, 480);

		ImagePanel imagePanel = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/719.GIF")));
		// Toolkit.getDefaultToolkit().getImage("719.GIF")
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.weighty = 3;

		// panel1.add(operatieGrafic, constraints);

		resultLabel = new JLabel();
		resultLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		resultLabel.setBounds(420, 60, 520, 30);
		resultLabel.setBackground(Color.WHITE);
		resultLabel.setVisible(true);

		// constraints.fill = GridBagConstraints.HORIZONTAL;
		// constraints.gridx = 0;
		// constraints.gridy = 2;

		constraints2.gridy = 1;
		constraints2.weighty = 3;
		constraints2.ipadx = 125;
		constraints2.ipady = 125;

		// resultLabel.setEditable(false);

		panel1.add(imagePanel, constraints2);
		panel1.add(resultLabel, constraints);
		panel1.setVisible(true);
	}

	// public OutputWindow(JLabel result) {
	// this();
	// this.resultLabel = result;
	// }

	public JPanel getPanel() {
		return panel1;
	}

	public JLabel getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(JLabel resultLabel) {
		this.resultLabel = resultLabel;
	}

}
