package code.bmi;

public class Ausgabe {
	String geschlecht;
	String ergebnis;

	/* Diagnose feststellen */
	/* Konstruktor mit zwei Parameter */

	Ausgabe(String geschlecht, double bmi) {
		this.geschlecht = geschlecht;

		if (geschlecht.equalsIgnoreCase("M")) {
			if (bmi > 30) {
				ergebnis = "Sie haben Behandlungsbedürftiges Übergewicht";
			} else if (bmi > 26) {
				ergebnis = "Sie haben Übergewicht";
			} else if (bmi > 20) {
				ergebnis = "Sie haben Normalgewicht";
			} else {
				ergebnis = "Sie haben Untergewicht";
			}
		} else if (geschlecht.equalsIgnoreCase("W")) {
			if (bmi > 30) {
				ergebnis = "Sie haben Behandlungsbedürftiges Übergewicht";
			} else if (bmi > 25) {
				ergebnis = "Sie haben Übergewicht";
			} else if (bmi > 19) {
				ergebnis = "Sie haben Normalgewicht";
			} else {
				ergebnis = "Sie haben Untergewicht";
			}
		} else {
			javax.swing.JOptionPane.showMessageDialog(null, "Sie haben falsch eingegeben", "Fehler", 3);
		}
	}
}
