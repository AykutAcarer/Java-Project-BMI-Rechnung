package code.bmi;
public class Berechnung {

	float gewicht, groesse;
	double bmi;

	/* BMI Rechnung */
	/* Konsructor mit zwei Parameter */

	Berechnung(float groesse, float gewicht) {
		this.gewicht = gewicht;
		this.groesse = groesse;

		bmi = gewicht * 10000 / (groesse * groesse);

	}
}
