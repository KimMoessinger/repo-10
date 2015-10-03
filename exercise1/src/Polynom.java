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
    	this.polynom = new double[0];
    }

    /**
     * Berechnet das Polynom an der Stelle x.
     *
     * @param x Stelle, für die das Polynom berechnet werden soll.
     * @return Wert an der Stelle x
     */
    public double berechne(double x) {
        return 0.0;
    }

    /**
     * Berechnet das Polynom an mehreren Stellen.
     *
     * @param xs die Stellen an der das Polynom berechnet werden soll.
     * @return Ergebnis
     */
    public double[] calc(double[] xs) {
        return null;
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
        return null;
    }

    /**
     * Subtrahiert das gegebenen Polynom von diesem.
     *
     * @param p Polynom, das subtrahiert werden soll.
     * @return neues Polynom mit dem Ergebnis der Subtraktion
     */
    public Polynom subtrahiere(Polynom p) {
        return null;
    }

    /**
     * Differenziert das Polynom.
     *
     * @return Ergebnis der Ableitung
     */
    public Polynom differenziere() {
        return null;
    }

    /**
     * Integriert das Polynom.
     *
     * @return Ergebnis der Integration.
     */
    public Polynom integriere() {
        return null;
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
        return false;
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
        return "";
    }
}
