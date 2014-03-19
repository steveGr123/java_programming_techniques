package tp.homework1.single_variable_polynomial.gui;

import tp.homework1.single_variable_polynomial.logic.Polinom;

/**
 * Clasa ce realizeaza functionalitatea de parsare dintr-un String introdus de
 * utilizator intr-un obiect de tip polinom
 * 
 * @author razvan
 * 
 */
public class Parser {
	/**
	 * Parsarea se face in felul urmator : se inlocuieste in String fiecare
	 * aparitie a semnului "-" cu "+-". Verificam daca String-ul incepe cu "+-",
	 * iar daca da, il stergem. Apelam la metoda split(Regex ex) pentru a
	 * imparti String-ul initial intr-un vector de String-uri, la fiecare
	 * aparitie a semnului "+". Apoi incepe tratarea posibilelor situatii pentru
	 * fiecare String din vector. Termenul poate sa contina sau sa nu contina x
	 * sau "^". S-au folosit metode specifice String-urilor pentru a detecta
	 * aparitia acestor pseudo-delimitatori. Rezultate s-au pus intr-o matrice
	 * cu care a fost construit polinomul.
	 * 
	 * @param s
	 *            String-ul introdus de utilizator
	 * @return Un obiect de tip Polinom identic cu cel trecut de utilizator sub
	 *         forma de string
	 */

	public Polinom toPolinom(String s) {
		s = s.replace("-", "+-");
		// System.out.println(s);
		if (s.startsWith("+-")) {
			s = s.replaceFirst("\\+", "");
		}

		// System.out.println(s);
		String[] parts = s.split("\\+");
		// int[][] temp = new int[parts.length][2];
		int[][] temporary = new int[parts.length][2];
		for (int i = 0; i < parts.length; i++) {
			// System.out.println("parts[" + i + "]" + parts[i]);
			if (!parts[i].contains("x") && !parts[i].contains("^")) {
				temporary[i][0] = (Integer.parseInt(parts[i]));
				temporary[i][1] = 0;
			} else {
				if (parts[i].contains("x") && !parts[i].contains("^")) {
					if (parts[i].substring(0, parts[i].indexOf('x'))
							.equals("-")) {
						temporary[i][0] = -1;
						temporary[i][1] = 1;
					} else {
						if (parts[i].substring(0, parts[i].indexOf('x') + 1)
								.equals("x")) {
							temporary[i][0] = 1;
							temporary[i][1] = 1;
						} else {
							temporary[i][0] = Integer.parseInt(parts[i]
									.substring(0, parts[i].indexOf('x')));
							temporary[i][1] = 1;
						}

					}
				}

				else {
					if (parts[i].contains("x") && parts[i].contains("^")) {
						if (parts[i].substring(0, parts[i].indexOf('x'))
								.equals("-")) {
							// temporary = new MonomZ(
							// -1,
							// Integer.parseInt(parts[i]
							// .substring(parts[i].indexOf("^") + 1)));
							temporary[i][0] = -1;
							temporary[i][1] = Integer.parseInt(parts[i]
									.substring(parts[i].indexOf("^") + 1));
						}

						else {
							if (parts[i]
									.substring(0, parts[i].indexOf('x') + 1)
									.equals("x")) {
								// temporary = new MonomZ(1,
								// Integer.parseInt(parts[i]
								// .substring(parts[i]
								// .indexOf("^") + 1)));
								temporary[i][0] = 1;
								temporary[i][1] = Integer.parseInt(parts[i]
										.substring(parts[i].indexOf("^") + 1));
							}

							else {
								// temporary = new MonomZ(
								// Integer.parseInt(parts[i].substring(0,
								// parts[i].indexOf('x'))),
								// Integer.parseInt(parts[i]
								// .substring(parts[i]
								// .indexOf("^") + 1)));
								temporary[i][0] = Integer.parseInt(parts[i]
										.substring(0, parts[i].indexOf('x')));
								temporary[i][1] = Integer.parseInt(parts[i]
										.substring(parts[i].indexOf("^") + 1));
							}
						}

					}
				}
			}
		}
		return new Polinom(temporary);
	}

	// public Polinom htmlToPolinom(String s) {
	// s = s.replace("<html>", "");
	// s = s.replace("<sup>", "^");
	// s = s.replace("</sup>", "");
	// s = s.replace("</html>", "");
	// System.out.println(s);
	// return this.toPolinom(s);
	// }
}