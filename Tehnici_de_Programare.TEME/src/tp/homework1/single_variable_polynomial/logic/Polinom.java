package tp.homework1.single_variable_polynomial.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Polinom {

	private ArrayList<Monom> termeni;

	public Polinom() {
		termeni = new ArrayList<Monom>();
	}

	public Polinom(MonomZ termen) {
		termeni = new ArrayList<Monom>();
		termeni.add(termen);
	}

	public Polinom(MonomR termen) {
		termeni = new ArrayList<Monom>();
		termeni.add(termen);

	}

	@Deprecated
	public Polinom(int[] coeficienti, int[] exponenti) {
		if (exponenti.length == 0 || coeficienti.length == 0
				|| exponenti.length != coeficienti.length) {
			throw new IllegalArgumentException(
					"Trebuie sa existe cel putin un exponent si cel putin un coeficient");
		}

		else {
			termeni = new ArrayList<Monom>();
			for (int i = 0; i < exponenti.length; i++) {
				termeni.add(new MonomZ(coeficienti[i], exponenti[i]));
			}

			this.ordonareTermeni();
		}
	}

	public Polinom(int[][] terms) {
		if (terms.length == 0) {
			termeni = new ArrayList<Monom>();
			termeni.add(new MonomZ(0, 0));
		}
		Comparator<int[]> dupaExponent = new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg1[1] - arg0[1];
			}

		};
		Arrays.sort(terms, dupaExponent);
		this.termeni = new ArrayList<Monom>();
		for (int[] element : terms) {
			if (element[0] != 0) {
				this.termeni.add(new MonomZ(element[0], element[1]));
			}

			else {
				this.termeni.add(new MonomZ(0, element[1]));
			}
		}

		compactareTermeni();
	}

	@Deprecated
	public Polinom(double[][] terms) {
		if (terms.length == 0) {
			termeni = new ArrayList<Monom>();
			termeni.add(new MonomZ(0, 0));
		}
		Comparator<double[]> dupaExponent = new Comparator<double[]>() {

			@Override
			public int compare(double[] arg0, double[] arg1) {
				return (int) (arg1[1] - arg0[1]);
			}

		};
		Arrays.sort(terms, dupaExponent);
		this.termeni = new ArrayList<Monom>();
		// Monom adder = new Monom();
		for (double[] element : terms) {
			if (element[0] != 0) {
				this.termeni.add(new MonomR(element[0], (int) element[1]));
			}

			else {
				this.termeni.add(new MonomZ(0, (int) element[1]));
			}
		}

		compactareTermeni();
	}

	public ArrayList<Monom> getTermeni() {
		return termeni;
	}

	public Polinom add(Polinom that) {

		this.ordonareTermeni();
		that.ordonareTermeni();
		Polinom suma = new Polinom();

		for (Monom date : this.getTermeni()) {
			if (date instanceof MonomZ) {
				MonomZ monom = new MonomZ();
				monom.setCoeficient(((MonomZ) date).getCoeficient());
				monom.setExponent(date.getExponent());
				suma.getTermeni().add(monom);
			}
			if (date instanceof MonomR) {
				MonomR monom = new MonomR();
				monom.setCoeficient(((MonomR) date).getCoeficient());
				monom.setExponent(date.getExponent());
				suma.getTermeni().add(monom);

			}
		}

		for (Monom date : that.getTermeni()) {
			if (date instanceof MonomZ) {
				MonomZ monom = new MonomZ();
				monom.setCoeficient(((MonomZ) date).getCoeficient());
				monom.setExponent(date.getExponent());
				suma.getTermeni().add(monom);
			}
			if (date instanceof MonomR) {
				MonomR monom = new MonomR();
				monom.setCoeficient(((MonomR) date).getCoeficient());
				monom.setExponent(date.getExponent());
				suma.getTermeni().add(monom);
			}

		}
		suma.ordonareTermeni();
		return suma;
	}

	public Polinom sub(Polinom that) {
		return this.add(that.scalarMul(-1));
	}

	public Polinom mul(Polinom that) {
		this.ordonareTermeni();
		that.ordonareTermeni();

		if (this.getTermeni().size() == 0) {
			return this;
		} else {
			if (that.getTermeni().size() == 0) {
				return that;
			}

			else {
				Polinom produs = new Polinom();
				for (Monom termen : this.getTermeni()) {
					for (Monom termen2 : that.getTermeni()) {
						if (termen instanceof MonomZ
								&& termen2 instanceof MonomZ) {
							MonomZ termenNou = new MonomZ();
							termenNou.setExponent(termen.getExponent()
									+ termen2.getExponent());
							termenNou.setCoeficient(((MonomZ) termen)
									.getCoeficient()
									* ((MonomZ) termen2).getCoeficient());
							produs.getTermeni().add(termenNou);
						}
						if (termen instanceof MonomR
								&& termen2 instanceof MonomR) {
							MonomR termenNou = new MonomR();
							termenNou.setExponent(termen.getExponent()
									+ termen2.getExponent());
							termenNou.setCoeficient(((MonomR) termen)
									.getCoeficient()
									* ((MonomR) termen2).getCoeficient());
							produs.getTermeni().add(termenNou);
						}
					}
				}

				produs.ordonareTermeni();
				return produs;
			}
		}
	}

	public Polinom div(Polinom that, boolean remainder) {
		this.ordonareTermeni();
		that.ordonareTermeni();

		Polinom deimpartit = new Polinom();
		for (Monom date : this.getTermeni()) {
			MonomR monom = new MonomR();
			monom.setCoeficient(((MonomZ) date).getCoeficient());
			monom.setExponent(date.getExponent());
			deimpartit.getTermeni().add(monom);
		}
		deimpartit.ordonareTermeni();

		Polinom impartitor = new Polinom();
		for (Monom date : that.getTermeni()) {
			MonomR monom = new MonomR();
			monom.setCoeficient(((MonomZ) date).getCoeficient());
			monom.setExponent(date.getExponent());
			impartitor.getTermeni().add(monom);
		}
		impartitor.ordonareTermeni();

		Integer index = 0, newExponent = 0;
		Double newCoeficient = 0.;
		Polinom cat = new Polinom();
		Polinom running = new Polinom();

		while (deimpartit.getTermeni().size() > 0
				&& deimpartit.getTermeni().get(0).getExponent() >= impartitor
						.getTermeni().get(0).getExponent()
				&& index < deimpartit.getTermeni().size()) {

			newCoeficient = ((MonomR) (deimpartit.getTermeni().get(0)))
					.getCoeficient()
					/ ((MonomR) (impartitor.getTermeni().get(0)))
							.getCoeficient();

			newExponent = deimpartit.getTermeni().get(0).getExponent()
					- impartitor.getTermeni().get(0).getExponent();

			MonomR newTermen = new MonomR(newCoeficient, newExponent);
			cat.getTermeni().add(newTermen);
			Polinom runningLast = new Polinom();
			runningLast.getTermeni().add(newTermen);

			running = runningLast.mul(impartitor);

			deimpartit = deimpartit.sub(running);
			index++;
			deimpartit.getTermeni().set(0,
					deimpartit.getTermeni().get(index - 1));
			deimpartit.getTermeni().remove(index - 1);

		}

		if (remainder == true) {
			deimpartit.ordonareTermeni();
			return deimpartit;
		} else {
			cat.ordonareTermeni();
			return cat;
		}

	}

	public Polinom derivare() {
		if (this.getTermeni().size() == 0) {
			return this;
		} else {
			Polinom derivat = new Polinom();
			for (Monom termen : this.getTermeni()) {
				MonomZ term = new MonomZ();
				term.setCoeficient(((MonomZ) termen).getCoeficient()
						* termen.getExponent());
				term.setExponent(termen.getExponent() - 1);
				derivat.getTermeni().add(term);
			}

			derivat.ordonareTermeni();
			return derivat;
		}

	}

	public Polinom derivareN(Polinom aux, Integer n) {
		if (n > aux.getTermeni().get(0).getExponent()) {
			return new Polinom(new MonomZ(0, 0));
		}

		else {
			for (int i = 0; i < n; i++) {
				aux = aux.derivare();
			}
			return aux;
		}
	}

	public Polinom integrare() {
		if (this.getTermeni().size() == 0) {
			return this;
		} else {
			Polinom integrat = new Polinom();
			for (Monom termen : this.getTermeni()) {
				MonomR term = new MonomR();
				term.setExponent(termen.getExponent() + 1);
				term.setCoeficient(Math.round((((MonomZ) termen)
						.getCoeficient() * 100 / (termen.getExponent() + 1))) / 100.0d);
				integrat.getTermeni().add(term);
			}
			integrat.ordonareTermeni();
			return integrat;
		}

	}

	public Polinom scalarMul(Integer scalar) {
		for (int i = 0; i < this.getTermeni().size(); i++) {
			if (this.getTermeni().get(i) instanceof MonomZ) {
				this.getTermeni().set(
						i,
						new MonomZ(scalar
								* ((MonomZ) this.getTermeni().get(i))
										.getCoeficient(), this.getTermeni()
								.get(i).getExponent()));
			} else {
				if (this.getTermeni().get(i) instanceof MonomR) {
					this.getTermeni().set(
							i,
							new MonomR(scalar
									* ((MonomR) this.getTermeni().get(i))
											.getCoeficient(), this.getTermeni()
									.get(i).getExponent()));
				}
			}
		}
		return this;
	}

	public Double evaluare(Integer x) {
		Double rezultat = 0.;
		if (this.getTermeni().size() == 0) {
			throw new NullPointerException("Polinom nul");
		} else {
			for (int i = 0; i < this.getTermeni().size(); i++) {
				if (this.getTermeni().get(i) instanceof MonomZ) {
					rezultat += Math.pow(x.doubleValue(),
							(this.getTermeni().get(i)).getExponent())
							* ((MonomZ) this.termeni.get(i)).getCoeficient();
				}
				if (this.getTermeni().get(i) instanceof MonomR) {
					rezultat += Math
							.round((Math.pow(x.doubleValue(),
									(this.getTermeni().get(i)).getExponent()) * ((MonomR) this.termeni
									.get(i)).getCoeficient()) * 1000) / 1000.d;
				}
			}
		}

		return rezultat;
	}

	public Double evaluareDerivata(Integer x) {
		return this.derivare().evaluare(x);
	}

	public Double integrareDefinita(Integer margineInferioara,
			Integer margineSuperioara) {
		return this.integrare().evaluare(margineSuperioara)
				- this.integrare().evaluare(margineInferioara);
	}

	public Integer primitiveRootSearch() {
		Integer numarRadacini = 0;
		for (int i = -1000; i >= 1000; i++) {
			if (this.evaluare(i) == 0) {
				numarRadacini++;
			}
		}

		return numarRadacini;
	}

	public void compactareTermeni() {
		boolean compact = false;
		Integer index = 0;
		while (!compact && this.getTermeni().size() > 1) {
			if (this.getTermeni().get(index).getExponent() == this.getTermeni()
					.get(index + 1).getExponent()) {
				if (this.getTermeni().get(index) instanceof MonomZ) {
					((MonomZ) this.getTermeni().get(index))
							.setCoeficient(((MonomZ) this.termeni.get(index))
									.getCoeficient()
									+ ((MonomZ) this.termeni.get(index + 1))
											.getCoeficient());
					this.getTermeni().remove(index + 1);
				}
				if (this.getTermeni().get(index) instanceof MonomR) {
					((MonomR) this.getTermeni().get(index))
							.setCoeficient(((MonomR) this.termeni.get(index))
									.getCoeficient()
									+ ((MonomR) this.termeni.get(index + 1))
											.getCoeficient());
					this.getTermeni().remove(index + 1);
				}
			} else {
				index++;
			}
			if (index == this.getTermeni().size() - 1) {
				compact = true;
			}
		}
	}

	public void ordonareTermeni() {
		Comparator<Monom> dupaExponent = new Comparator<Monom>() {

			@Override
			public int compare(Monom arg0, Monom arg1) {
				return arg1.getExponent() - arg0.getExponent();
			}

		};

		Collections.sort(this.getTermeni(), dupaExponent);
		this.compactareTermeni();

	}

	public String toString() {
		if (this.getTermeni().size() == 0)
			return "0";
		else {
			StringBuilder result = new StringBuilder();
			result.append("<html><p style=font-family:monospace;color:black;font-size:13px;>");
			boolean negativ;

			for (int i = 0; i < this.getTermeni().size(); i++) {

				if (this.getTermeni().get(i) instanceof MonomZ) {
					negativ = (((MonomZ) (this.termeni.get(i))).getCoeficient() > 0) ? false
							: true;
					if (i == 0) {
						if (Math.abs(((MonomZ) (this.termeni.get(i)))
								.getCoeficient()) == 1) {
							if (negativ)
								result.append("-");
						} else {
							if (Math.abs(((MonomZ) (this.termeni.get(i)))
									.getCoeficient()) == 0) {
								result.append("");
							} else {
								if (negativ)
									result.append("-"
											+ Math.abs(((MonomZ) (this.termeni
													.get(i))).getCoeficient()));
								else
									result.append(((MonomZ) (this.termeni
											.get(i))).getCoeficient());
							}
						}
					} else {
						if (Math.abs(((MonomZ) (this.termeni.get(i)))
								.getCoeficient()) == 0) {
							result.append("");
						} else {
							if (Math.abs(((MonomZ) (this.termeni.get(i)))
									.getCoeficient()) != 1) {
								if (negativ)
									result.append("- "
											+ Math.abs(((MonomZ) (this.termeni
													.get(i))).getCoeficient()));
								else
									result.append("+ "
											+ ((MonomZ) (this.termeni.get(i)))
													.getCoeficient());
							} else {
								if (negativ)
									result.append("- ");
								else
									result.append("+ ");
							}
						}
					}

					if ((this.termeni.get(i).getExponent() > 1)
							&& (((MonomZ) (this.termeni.get(i)))
									.getCoeficient() != 0)) {
						result.append("x" + "<sup>"
								+ this.termeni.get(i).getExponent() + "</sup>"
								+ " ");
					} else {
						if ((this.termeni.get(i).getExponent() > 1)
								&& (((MonomZ) (this.termeni.get(i)))
										.getCoeficient() == 0)) {
							result.append("");
						}

						if ((this.termeni.get(i).getExponent() == 1)
								&& (((MonomZ) (this.termeni.get(i)))
										.getCoeficient() != 0))
							result.append("x ");
						else {
							if ((this.termeni.get(i).getExponent() == 1)
									&& (((MonomZ) (this.termeni.get(i)))
											.getCoeficient() == 0)) {
								result.append("");
							} else {
								if ((this.termeni.get(i).getExponent() == 0)
										&& (((MonomZ) (this.termeni.get(i)))
												.getCoeficient() == 1)) {
									result.append(((MonomZ) (this.termeni
											.get(i))).getCoeficient());
								}

								else {
									if ((this.termeni.get(i).getExponent() == 0)
											&& (((MonomZ) (this.termeni.get(i)))
													.getCoeficient() == -1)) {
										result.append(Math
												.abs(((MonomZ) this.termeni
														.get(i))
														.getCoeficient()));
									}

									else {
										if ((this.termeni.get(
												this.getTermeni().size() - 1)
												.getExponent() == 0)
												&& (((MonomZ) (this.termeni
														.get(this.getTermeni()
																.size() - 1)))
														.getCoeficient() == 0)) {
											result.append("0");
										}
									}

								}
							}

						}
					}
				} else {
					if (this.getTermeni().get(i) instanceof MonomR) {
						negativ = (((MonomR) (this.termeni.get(i)))
								.getCoeficient() > 0) ? false : true;
						if (i == 0) {
							if (Math.abs(((MonomR) (this.termeni.get(i)))
									.getCoeficient()) == 1) {
								if (negativ)
									result.append("-");
							} else {
								if (Math.abs(((MonomR) (this.termeni.get(i)))
										.getCoeficient()) == 0) {
									result.append("");
								} else {
									if (negativ)
										result.append("-"
												+ Math.abs(((MonomR) (this.termeni
														.get(i)))
														.getCoeficient()));
									else
										result.append(((MonomR) (this.termeni
												.get(i))).getCoeficient());
								}
							}
						} else {
							if (Math.abs(((MonomR) (this.termeni.get(i)))
									.getCoeficient()) == 0) {
								result.append("");
							} else {
								if (Math.abs(((MonomR) (this.termeni.get(i)))
										.getCoeficient()) != 1) {
									if (negativ)
										result.append("- "
												+ Math.abs(((MonomR) (this.termeni
														.get(i)))
														.getCoeficient()));
									else
										result.append("+ "
												+ ((MonomR) (this.termeni
														.get(i)))
														.getCoeficient());
								} else {
									if (negativ)
										result.append("- ");
									else
										result.append("+ ");
								}
							}
						}

						if ((this.termeni.get(i).getExponent() > 1)
								&& (((MonomR) (this.termeni.get(i)))
										.getCoeficient() != 0)) {
							result.append("x" + "<sup>"
									+ this.termeni.get(i).getExponent()
									+ "</sup>" + " ");
						} else {
							if ((this.termeni.get(i).getExponent() > 1)
									&& (((MonomR) (this.termeni.get(i)))
											.getCoeficient() == 0)) {
								result.append("");
							}

							if ((this.termeni.get(i).getExponent() == 1)
									&& (((MonomR) (this.termeni.get(i)))
											.getCoeficient() != 0))
								result.append("x ");
							else {
								if ((this.termeni.get(i).getExponent() == 1)
										&& (((MonomR) (this.termeni.get(i)))
												.getCoeficient() == 0)) {
									result.append("");
								} else {
									if ((this.termeni.get(i).getExponent() == 0)
											&& (((MonomR) (this.termeni.get(i)))
													.getCoeficient() == 1)) {
										result.append(((MonomR) (this.termeni
												.get(i))).getCoeficient());
									}

									else {
										if ((this.termeni.get(i).getExponent() == 0)
												&& (((MonomR) (this.termeni
														.get(i)))
														.getCoeficient() == -1)) {
											result.append(Math
													.abs(((MonomR) this.termeni
															.get(i))
															.getCoeficient()));
										}

										else {
											if ((this.termeni
													.get(this.getTermeni()
															.size() - 1)
													.getExponent() == 0)
													&& (((MonomR) (this.termeni
															.get(this
																	.getTermeni()
																	.size() - 1)))
															.getCoeficient() == 0)) {
												result.append("");
											}
										}

									}
								}

							}
						}

					}
				}

			}
			result.append("</p></html>");
			return result.toString();
		}

	}
}
