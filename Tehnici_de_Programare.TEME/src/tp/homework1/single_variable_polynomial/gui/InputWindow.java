package tp.homework1.single_variable_polynomial.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.homework1.single_variable_polynomial.listeners.AdunarePress;
import tp.homework1.single_variable_polynomial.listeners.DerivareEvalPress;
import tp.homework1.single_variable_polynomial.listeners.DerivareNPress;
import tp.homework1.single_variable_polynomial.listeners.DerivarePress;
import tp.homework1.single_variable_polynomial.listeners.EvalPolinomPress;
import tp.homework1.single_variable_polynomial.listeners.ExitPress;
import tp.homework1.single_variable_polynomial.listeners.GraficInPress;
import tp.homework1.single_variable_polynomial.listeners.ImpartireQPress;
import tp.homework1.single_variable_polynomial.listeners.ImpartireRPress;
import tp.homework1.single_variable_polynomial.listeners.InmultirePress;
import tp.homework1.single_variable_polynomial.listeners.InmultireScalaraPress;
import tp.homework1.single_variable_polynomial.listeners.IntegrareDPress;
import tp.homework1.single_variable_polynomial.listeners.IntegrareNPress;
import tp.homework1.single_variable_polynomial.listeners.RadaciniPress;
import tp.homework1.single_variable_polynomial.listeners.ScaderePress;

/**
 * Clasa responsabila de afisarea butoanelor, textfieldurilor pentru utilizarea
 * aplicatiei
 * 
 * @author razvan
 * 
 */
public class InputWindow {
	private final Color secretColor2 = new Color(255, 255, 255);
	private JPanel panel = new JPanel();
	private JPanel panelComponents = new JPanel();
	private JTextField textFieldPolinom1;
	private JTextField textFieldPolinom2;
	private JTextField textValue;

	public InputWindow() {
		panel.setLayout(null);
		panel.setBounds(0, 0, 400, 480);
		addContent();
		panel.setVisible(true);
	}

	/**
	 * Metoda de initializare a componentelor
	 */
	public void addContent() {
		panelComponents.setLayout(null);
		panelComponents.setBounds(0, 0, 400, 480);
		panelComponents.setBackground(new Color(25, 25, 30));
		addP1TextField();
		addP2TextField();
		addButtons();
		panel.add(panelComponents);

	}

	/**
	 * Metoda de adaugare a butoanelor si ascultatorilor la butoane
	 */

	private void addButtons() {
		// operatieGraficP1 = new JButton("Grafic");
		// operatieGraficP1.setBackground(new Color(69, 59, 79));
		// operatieGraficP1.setForeground(secretColor2);
		//
		// operatieGraficP1.addMouseListener(new GraficInPress(this,
		// new PlotWindow()));
		// panelComponents.add(operatieGraficP1);

		JButton operatieGraficP2 = new JButton("Grafic");
		operatieGraficP2.setBackground(new Color(69, 59, 79));
		operatieGraficP2.setForeground(secretColor2);
		operatieGraficP2.setBounds(275, 230, 75, 25);
		operatieGraficP2.addMouseListener(new GraficInPress(this,
				new PlotWindow()));
		panelComponents.add(operatieGraficP2);

		JButton operatieDerivare = new JButton("Prima derivata");
		operatieDerivare.setBackground(new Color(69, 59, 79));
		operatieDerivare.setForeground(secretColor2);
		operatieDerivare.setBounds(10, 93, 117, 25);
		operatieDerivare.addMouseListener(new DerivarePress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieDerivare);

		JButton operatieDerivareN = new JButton("Derivata ordin N");
		operatieDerivareN.setBackground(new Color(69, 59, 79));
		operatieDerivareN.setForeground(secretColor2);
		operatieDerivareN.setBounds(130, 93, 125, 25);
		operatieDerivareN.addMouseListener(new DerivareNPress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieDerivareN);

		JButton operatieDerivEval = new JButton("Evaluare derivata");
		operatieDerivEval.setBackground(new Color(69, 59, 79));
		operatieDerivEval.setForeground(secretColor2);
		operatieDerivEval.setBounds(258, 93, 133, 25);
		operatieDerivEval.addMouseListener(new DerivareEvalPress(this,
				new OutputWindow()));
		panelComponents.add(operatieDerivEval);

		JButton operatieIntegrareN = new JButton("Integrare");
		operatieIntegrareN.setBackground(new Color(69, 59, 79));
		operatieIntegrareN.setForeground(secretColor2);
		operatieIntegrareN.setBounds(27, 123, 95, 25);
		operatieIntegrareN.addMouseListener(new IntegrareNPress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieIntegrareN);

		JButton operatieIntegrareD = new JButton("Integrala definita");
		operatieIntegrareD.setBackground(new Color(69, 59, 79));
		operatieIntegrareD.setForeground(secretColor2);
		operatieIntegrareD.setBounds(126, 123, 133, 25);
		operatieIntegrareD.addMouseListener(new IntegrareDPress(this,
				new OutputWindow()));
		panelComponents.add(operatieIntegrareD);

		JButton operatieEvaluare = new JButton("Evaluare polinom");
		operatieEvaluare.setBackground(new Color(69, 59, 79));
		operatieEvaluare.setForeground(secretColor2);
		operatieEvaluare.setBounds(263, 123, 131, 25);
		operatieEvaluare.addMouseListener(new EvalPolinomPress(this,
				new OutputWindow()));
		panelComponents.add(operatieEvaluare);

		JButton operatieInmultScal = new JButton("Inmultire cu scalar");
		operatieInmultScal.setBackground(new Color(69, 59, 79));
		operatieInmultScal.setForeground(secretColor2);
		operatieInmultScal.setBounds(45, 155, 145, 25);
		operatieInmultScal.addMouseListener(new InmultireScalaraPress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieInmultScal);

		JButton operatieRadacinaIntreaga = new JButton("Numar radacini");
		operatieRadacinaIntreaga.setBackground(new Color(69, 59, 79));
		operatieRadacinaIntreaga.setForeground(secretColor2);
		operatieRadacinaIntreaga.setBounds(200, 155, 175, 25);
		operatieRadacinaIntreaga.addMouseListener(new RadaciniPress(this,
				new OutputWindow()));
		panelComponents.add(operatieRadacinaIntreaga);

		JButton operatieAdunare = new JButton("Suma");
		operatieAdunare.setBackground(new Color(69, 59, 79));
		operatieAdunare.setForeground(secretColor2);
		operatieAdunare.setBounds(50, 285, 75, 25);
		operatieAdunare.addMouseListener(new AdunarePress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieAdunare);

		JButton operatieScadere = new JButton("Diferenta");
		operatieScadere.setBackground(new Color(69, 59, 79));
		operatieScadere.setForeground(secretColor2);
		operatieScadere.setBounds(150, 285, 95, 25);
		operatieScadere.addMouseListener(new ScaderePress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieScadere);

		JButton operatieInmultire = new JButton("Produs");
		operatieInmultire.setBackground(new Color(69, 59, 79));
		operatieInmultire.setForeground(secretColor2);
		operatieInmultire.setBounds(270, 285, 85, 25);
		operatieInmultire.addMouseListener(new InmultirePress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieInmultire);

		JButton operatieImpartireQ = new JButton("Cat");
		operatieImpartireQ.setBackground(new Color(69, 59, 79));
		operatieImpartireQ.setForeground(secretColor2);
		operatieImpartireQ.setBounds(105, 330, 65, 25);
		operatieImpartireQ.addMouseListener(new ImpartireQPress(this,
				new OutputWindow(), new PlotWindow()));
		panelComponents.add(operatieImpartireQ);

		JButton operatieImpartireR = new JButton("Rest");
		operatieImpartireR.setBackground(new Color(69, 59, 79));
		operatieImpartireR.setForeground(secretColor2);
		operatieImpartireR.setBounds(225, 330, 65, 25);
		operatieImpartireR.addMouseListener(new ImpartireRPress(this,
				new OutputWindow()));
		panelComponents.add(operatieImpartireR);

		JButton exit = new JButton("Exit");
		exit.setBackground(new Color(69, 59, 79));
		exit.setForeground(secretColor2);
		exit.setBounds(160, 400, 65, 25);
		exit.addMouseListener(new ExitPress());
		panelComponents.add(exit);

	}

	/**
	 * Metoda de adaugare a primului textfield
	 */
	private void addP1TextField() {
		textFieldPolinom1 = new JTextField();
		textFieldPolinom1.setBounds(100, 40, 150, 25);
		textValue = new JTextField();
		textValue.setBounds(275, 40, 75, 25);
		JLabel labelV = new JLabel("Valoare: ");
		JLabel labelP1 = new JLabel("Polinomul 1: ");
		labelP1.setForeground(Color.GREEN);
		labelP1.setBounds(10, 43, 85, 20);
		labelV.setForeground(Color.GREEN);
		labelV.setBounds(285, 20, 75, 20);
		panelComponents.add(textValue);
		panelComponents.add(labelV);
		panelComponents.add(textFieldPolinom1);
		panelComponents.add(labelP1);
		panelComponents.repaint();
		panelComponents.revalidate();
	}

	/**
	 * Metoda de adaugare a celui de-al doilea textfield. (probabil overkill)
	 */
	private void addP2TextField() {
		// TODO Auto-generated method stub
		textFieldPolinom2 = new JTextField();
		textFieldPolinom2.setBounds(100, 230, 150, 25);
		JLabel labelP2 = new JLabel("Polinomul 2: ");
		labelP2.setForeground(Color.GREEN);
		labelP2.setBounds(10, 233, 85, 20);
		panelComponents.add(textFieldPolinom2);
		panelComponents.add(labelP2);

	}

	public JPanel getPanel() {
		return panel;
	}

	public JTextField getTextFieldPolinom1() {
		return textFieldPolinom1;
	}

	public JTextField getTextFieldPolinom2() {
		return textFieldPolinom2;
	}

	public JTextField getTextValue() {
		return textValue;
	}

}
