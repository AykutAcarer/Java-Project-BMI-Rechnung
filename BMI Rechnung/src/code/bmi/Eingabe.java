package code.bmi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class Eingabe {

	String vorName;
	String nachName;
	
	static File file = new File("C:\\Users\\CC-Student\\Desktop\\Beispiel_Datei\\BMIndex.csv");

	public Eingabe(String vorName, String nachName) {
		this.vorName = vorName;
		this.nachName = nachName;
	}
	/*  Method für Ausgabe der Kopfzeile der csv-Datei */
	static void header() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			OutputStream ps = new FileOutputStream(file, true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ps));
			String h = "Vorname", h1 = "Nachname", h2 = "Geschlecht", h3 = "Groesse (cm)", h4 = "Gewicht (kg)",
					h5 = "BMI Wert", h6 = "Diagnose", sep = ";";

			String header = h + sep + h1 + sep + h2 + sep + h3 + sep + h4 + sep + h5 + sep + h6 + sep;

			bw.write(header);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		javax.swing.JOptionPane.showMessageDialog(null, "Willkommen zum  BMI Berechnung!");
		int auswahl = 0;
		
		/* Kopfzeile der csv-Datei */
		header();
	
		do {
			// Konsol-Eingabe
			String vorName = javax.swing.JOptionPane.showInputDialog("Geben Sie bitte Ihre vorName ein:");
			String nachName = javax.swing.JOptionPane.showInputDialog("Geben Sie bitte Ihre nachName ein:");
			String geschlecht = javax.swing.JOptionPane.showInputDialog("Geben Sie bitte Ihre Geschlecht: (m/w)");
			String g = javax.swing.JOptionPane.showInputDialog("Wie ist Ihre groesse:(cm)");
			float groesse = Float.parseFloat(g);
			String gg = javax.swing.JOptionPane.showInputDialog("Wie ist Ihre Gewicht: (kg)");
			float gewicht = Float.parseFloat(gg);

			// Aufruf der Konstructor von Klasse Eingabe
			Eingabe obj = new Eingabe(vorName, nachName);

			// Aufruf der Konstructor von Klasse Berechnung
			Berechnung obj1 = new Berechnung(groesse, gewicht);
			javax.swing.JOptionPane.showMessageDialog(null, obj1.bmi, "BMI Wert ist", 1);

			// Aufruf der Konstructor von Klasse Ausgabe
			Ausgabe obj2 = new Ausgabe(geschlecht, obj1.bmi);
			javax.swing.JOptionPane.showMessageDialog(null, obj2.ergebnis, "Diagnose", 1);

			// Erzeugen ein .csv Datei mit der Daten
			try {
				OutputStream ps = new FileOutputStream(file, true);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ps));
				String string_bmi = new DecimalFormat("0.00").format(obj1.bmi);

				bw.append(obj.vorName + ";" + obj.nachName + ";" + obj2.geschlecht + ";" + obj1.groesse + ";"
						+ obj1.gewicht + ";" + string_bmi + ";" + obj2.ergebnis);

				bw.newLine();
				bw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			auswahl = javax.swing.JOptionPane.showConfirmDialog(null, "Möchten Sie gerade wieder prüfen?");
		} while (auswahl <= 0);

	}

}
