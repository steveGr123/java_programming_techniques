package tp.homework1.single_variable_polynomial.logic;

/**
 * Un monom este un termen de forma coeficient * x^exponent dintr-un polinom.
 * Acesta poate avea coeficienti reali sau intregi, de unde si clasele
 * MonomZ(multimea Z -> numere intregi) si MonomR(multimea R -> multimea nr.
 * reale).
 * 
 * @author razvan
 * 
 */
public class Monom {
	protected int exponent;

	public Monom() {
	}

	// public Monom(Object coeficient, int exponent) {
	// this.coeficient = coeficient;
	// this.exponent = exponent;
	// }

	public int getExponent() {
		return this.exponent;
	}

	public int compareTo(Monom arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

}
