import java.text.DecimalFormat;
import java.util.*;

/**
 * Test
 * Diese Klasse präsentiert ein Polynom von einem beliebigen Grad mit
 * realen Koeffizienten.
 * <p>
 * Polynome können addiert und subtrahiert werden. Außerdem ist es möglich,
 * die Koeffizienten einzeln oder en-bloc wieder auszulesen. Für beliebige
 * Werte x kann der Polynom ausgerechnet werden.
 * <p>
 * Es besteht die Möglichkeit das Polynom zu differnzieren oder zu
 * integrieren.
 * <p>
 * Objekte dieser Klasse sind immutable. Die Methoden verändern den Zustand
 * des Objektes nicht sondern geben grundsätzlich ein neues Objekt zurück.
 * <p>
 * Die Indices beim Zugriff auf die Koeffizienten beginnen immer
 * bei {@literal 0}
 */
public class Polynom {

    /*
     * Hilfe, ich bin werde auf der Mother Base gefangen gehalten
     * und muss hier den ganzen Tag Programme schreiben...
     *
     * Ich lösche jetzt einfach die meisten Implementierung der
     * Methoden und flüchte mit dem Schlauchboot, vielleicht finden
     * sie mich ja nicht....
     */
	
	private double[] polynom;

    /**
     * Erzeugt ein neues Polynom mit den gegebenen Koeffizienten.
     * Die Koeffizienten beginnen Element a0 und setzen sich dann zu
     * höheren Koeffizienten fort. D.h., dass z.B. das Polynom
     * <code>2x^4 - 1x^3 + 0,5x^2</code> erzeugt werden muss als:
     * <code>new Polynom(0.0, 0.0, 0.5, -1.0, 2.0)</code>.
     *
     * @param a Koeffizienten des Polynoms
     */
    public Polynom(double... a) {
    	this.polynom = new double[a.length];
    	
    	// Kopiere alle Werte
    	for(int i = 0; i < a.length; i++) {
    		this.polynom[i] = a[i];
       	}
    }

    /**
     * Erzeugt das Nullpolynom, d.h. das Polynom, bei dem alle Koeffizienten
     * 0 sind.
     */
    public Polynom() {
    	this.polynom = new double[1];
    }

    /**
     * Berechnet das Polynom an der Stelle x.
     *
     * @param x Stelle, für die das Polynom berechnet werden soll.
     * @return Wert an der Stelle x
     */
    public double berechne(double x) {
    	double fx = 0.0; // fx = y = ...
    	
    	// Erklärung Mathe: https://de.wikipedia.org/wiki/Ganzrationale_Funktion
    	
    	for(int exponent = 0; exponent <= getGrad(); exponent++) {
    		double koeffizient = getKoeffizient(exponent);
    		
    		if(exponent == 0) {
    			fx = koeffizient;
    		} else {
    			double basis = x;
    			double potenz = 1;
    			
    			for(int k = 0; k < exponent; k++) {
    				potenz *= basis;
    			}
    			
    			fx += (koeffizient * potenz);
    		}
       	}
    	
    	return fx;
    }

    /**
     * Berechnet das Polynom an mehreren Stellen.
     *
     * @param xs die Stellen an der das Polynom berechnet werden soll.
     * @return Ergebnis
     */
    public double[] calc(double[] xs) {
        double[] fxs = new double[xs.length];
        
        for(int i = 0; i < xs.length; i++) {
        	fxs[i] = berechne(xs[i]);
        }
    	return fxs;
    }

    /**
     * Liefert den Grad des Polynoms.
     *
     * @return Grad des Polynoms, -1 für das Nullpolynom
     */
    public int getGrad() {
    	// Grad entspricht der Länge des Arrays bis zur Position
    	// in der noch ein vernünftiger Wert (nicht 0) steht.
    	
    	// Initialisiere Rückgabewert mit -1, da Array ja auch keine
    	// Werte enthalten kann.
    	int grad = -1;
    	
    	for(int i = 0; i < this.polynom.length; i++) {
    		if(this.polynom[i] != 0.0) {
    			grad = i;
    		}
    	}
    	
    	return grad;
    }

    /**
     * Liefert den n-ten Koeffizienten.
     *
     * @param n Koeffizient, der gelesen werden soll.
     * @return Wert des Koeffizienten oder 0 wenn n größer als der Grad des
     *         Polynoms ist
     */
    public double getKoeffizient(int n) {
    	// Anzahl der Koeffizienten = Länge des Arrays
    	int anzahlKoeffizienten = this.polynom.length;
    	
    	double koeffizient = 0.0;
    	
    	// Liegt n im Array? (Anmerkung: n darf auch nicht negativ sein.)
    	if((n < anzahlKoeffizienten) && (n >= 0)) {
    		koeffizient = this.polynom[n];	
    	}
    	
    	return koeffizient;
    }

    /**
     * Liefert die Koeffizienten dieses Polynoms.
     *
     * @return die Koeffizienten.
     */
    public double[] getKoeffizienten() {
    	// Anzahl der Koeffizienten = Länge des Arrays
    	int anzahlKoeffizienten = this.polynom.length;
    	
        double[] koeffizienten = new double[anzahlKoeffizienten];
    	
    	// Kopiere alle Werte
    	for(int i = 0; i < anzahlKoeffizienten; i++) {
    		koeffizienten[i] = this.polynom[i];
       	}
    	
    	return koeffizienten;
    }

    /**
     * Addiert das gegebenen Polynom zu diesem.
     *
     * @param p Polynom, das addiert werden soll.
     * @return neues Polynom mit dem Ergebnis der Addition
     */
    public Polynom addiere(Polynom p) {
        int laengeAktuellesPolynom = this.polynom.length;	
        int laengeUebergebenesPolynom = p.getKoeffizienten().length;
    	
        double[] koeffizientenErgebnis;
        
        // Größeres Array ermitteln und neues Ergebnis-Array mit dieser Größe anlegen
        if(laengeAktuellesPolynom <= laengeUebergebenesPolynom) {
        	koeffizientenErgebnis = new double[laengeUebergebenesPolynom];
        } else {
        	koeffizientenErgebnis = new double[laengeAktuellesPolynom];
        }
        
        for(int i = 0; i < koeffizientenErgebnis.length; i++) {
        	double aktuellerKoeffizient = this.getKoeffizient(i);
        	double uebergebenerKoeffizient = p.getKoeffizient(i);
        	
        	koeffizientenErgebnis[i] = aktuellerKoeffizient + uebergebenerKoeffizient;
        }
        
        Polynom ergebnis = new Polynom(koeffizientenErgebnis);
        
    	return ergebnis;
    }

    /**
     * Subtrahiert das gegebenen Polynom von diesem.
     *
     * @param p Polynom, das subtrahiert werden soll.
     * @return neues Polynom mit dem Ergebnis der Subtraktion
     */
    public Polynom subtrahiere(Polynom p) {
    	int laengeAktuellesPolynom = this.polynom.length;	
        int laengeUebergebenesPolynom = p.getKoeffizienten().length;
    	
        double[] koeffizientenErgebnis;
        
        // Größeres Array ermitteln und neues Ergebnis-Array mit dieser Größe anlegen
        if(laengeAktuellesPolynom <= laengeUebergebenesPolynom) {
        	koeffizientenErgebnis = new double[laengeUebergebenesPolynom];
        } else {
        	koeffizientenErgebnis = new double[laengeAktuellesPolynom];
        }
        
        for(int i = 0; i < koeffizientenErgebnis.length; i++) {
        	double aktuellerKoeffizient = this.getKoeffizient(i);
        	double uebergebenerKoeffizient = p.getKoeffizient(i);
        	
        	koeffizientenErgebnis[i] = aktuellerKoeffizient - uebergebenerKoeffizient;
        }
        
        Polynom ergebnis = new Polynom(koeffizientenErgebnis);
        
    	return ergebnis;
    }

    /**
     * Differenziert das Polynom.
     *
     * @return Ergebnis der Ableitung
     */
    public Polynom differenziere() {
    	double[] koeffizientenErgebnis = new double[this.getGrad()];
    	int koeffizientenErgebnisZaehler = 0;
    	
    	for(int i = 0; i <= this.getGrad(); i++) {
    		if(i == 0) {
    			// nichts tun!
    		} else {
    			koeffizientenErgebnis[koeffizientenErgebnisZaehler] = this.getKoeffizient(i) * i;
    			koeffizientenErgebnisZaehler++;
    		}
    	}
    	
    	 Polynom ergebnis = new Polynom(koeffizientenErgebnis);
         
     	return ergebnis;
    }

    /**
     * Integriert das Polynom.
     *
     * @return Ergebnis der Integration.
     */
    public Polynom integriere() {
    	double[] koeffizientenErgebnis = new double[this.getGrad() + 2];
    	
    	koeffizientenErgebnis[0] = 0;
    	int koeffizientenErgebnisZaehler = 1;
    	
    	for(int i = 0; i <= this.getGrad(); i++) {
    		// Teilen durch Null verhindern
    		if(this.getKoeffizient(i) != 0) {
    			koeffizientenErgebnis[koeffizientenErgebnisZaehler] = this.getKoeffizient(i) / (i + 1);
    		} else {
    			koeffizientenErgebnis[koeffizientenErgebnisZaehler] = 0;
    		}
    		koeffizientenErgebnisZaehler++;
    	}
    	
    	 Polynom ergebnis = new Polynom(koeffizientenErgebnis);
         
     	return ergebnis;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
    	boolean rueckgabewert;
    	
    	if(obj == this) {
    		rueckgabewert = true;
        } else if(obj == null) {
        	rueckgabewert = false;
        } else if(obj instanceof Polynom) {	
        	Polynom uebergebenesPolynom = (Polynom)obj;
        	
        	int laengeAktuellesPolynom = getGrad();	
            int laengeUebergebenesPolynom = uebergebenesPolynom.getGrad();
        	
            if(laengeAktuellesPolynom != laengeUebergebenesPolynom) {
            	rueckgabewert = false;
            } else {
            	rueckgabewert = true;
            	
            	for(int i = 0; i < laengeAktuellesPolynom; i++) {
            		double aktuellerKoeffizient = this.getKoeffizient(i);
            		double uebergebenerKoeffizient = uebergebenesPolynom.getKoeffizient(i);
            		
            		if(aktuellerKoeffizient != uebergebenerKoeffizient) {
            			rueckgabewert = false;
            		}
            	}
            }
        } else {
        	rueckgabewert = false;
        }
    	
    	return rueckgabewert;
    }

    /**
     * Diese Methode wandelt das Polynom in einen lesbaren String um.
     * Dabei lässt sie alle Koeffizienten aus, die 0 sind und gibt den
     * Grad vorweg aus. Für das Polynom -9x^8 - 4x^5 - 0,5x^4 + 5x^2 - 2x + 3
     * lautet die Ausgabe:
     * <code>
     * Grad 8: -9x^8 - 4x^5 - 0,5x^4 + 5x^2 - 2x + 3
     * </code>
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    	String ergebnis = "Grad ";
    	
    	ergebnis += getGrad() + ":  ";
    	
    	for(int i = getGrad(); i >= 0; i--) {
    		double koeffizient = getKoeffizient(i);
    		
    		// Nullwerte ausschließen
    		if(koeffizient != 0.0) {
    			
    			// Bei der ersten Zahl das Vorzeichen nicht formatieren
    			if(i != getGrad()) {
    				// Vorzeichen getrennt ausgeben - Bei negativen Wert die Zahl positiv machen
    				if(koeffizient <= 0) {
    					ergebnis += " - ";
    					koeffizient = koeffizient * -1; // Zahl positiv machen
    				} else {
    					ergebnis += " + ";
    				}
    			}
    			
    			// Erklärung: http://javabeginners.de/Mathematisches/Dezimalzahl_formatieren.php
    			DecimalFormat df = (DecimalFormat)DecimalFormat.getInstance(Locale.GERMAN);
    			df.applyPattern( "#,#,#.#" );
    			String zahlAlsString = df.format( koeffizient );

    			switch(i) {
    			case 0:
    				ergebnis += zahlAlsString;
    			break;
    			case 1:
    				ergebnis += zahlAlsString + "x";
    			break;
    			default:
    				ergebnis += zahlAlsString + "x^" + i;
    			}
    		}	
    	}
    	
        return ergebnis;
    }
}
