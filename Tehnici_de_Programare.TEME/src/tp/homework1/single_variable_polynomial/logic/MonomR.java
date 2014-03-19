package tp.homework1.single_variable_polynomial.logic;

/**
 * MonomR : termen al unui polinom cu coeficienti reali
 * 
 * @author razvan
 * 
 */
public class MonomR extends Monom {

	private Double coeficient;

	public MonomR() {

	}

	public MonomR(double coeficient, int exponent) {
		this.coeficient = coeficient;
		this.exponent = exponent;
	}

	public Double getCoeficient() {
		return this.coeficient.doubleValue();
	}

	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}

	@Override
	public String toString() {
		return "MonomR [coeficient=" + coeficient + ", exponent=" + exponent
				+ "]";
	}

}
