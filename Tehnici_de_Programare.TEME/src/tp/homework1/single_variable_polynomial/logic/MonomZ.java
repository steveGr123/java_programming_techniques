package tp.homework1.single_variable_polynomial.logic;

/**
 * MonomZ : termen al unui polinom cu coeficienti intregi
 * 
 * @author razvan
 * 
 */
public class MonomZ extends Monom {

	private Integer coeficient;

	public MonomZ() {
		super();
	}

	public MonomZ(Integer coeficient, int exponent) {
		this.coeficient = coeficient;
		this.exponent = exponent;
	}

	public Integer getCoeficient() {
		return this.coeficient.intValue();
	}

	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}

	@Override
	public String toString() {
		return "MonomZ [coeficient=" + coeficient + ", exponent=" + exponent
				+ "]";
	}

}
