package de.hs_mannheim.tpe.gruppe10.exercise2;

/**
 * 
 * Klasse Figur
 * 
 * Diese Klasse gibt die Fläche von unterschiedlichen Figuren zurück. 
 * <p>
 * Es sind die Klassen Dreieck, Gerade, Quadrat und Rechteck zusätzlich vorhanden.
 * <p>
 * Eine eigene Unit-Tests ist ebenfalls lauffähig vorhanden.
 * <p>
 * Objekte dieser Klasse können nur von Subklassen bearbeitet werden, sofern die
 * Subklassen in der Vererbung dieser Klasse aufgeführt sind.
 * Andere Klassen, welche nicht in der Vererbung dieser Klasse aufgeführt sind können
 * jedoch lesend auf die Objekte zugreifen.
 * <p>
 * @author Tobias Jünemann und Kim Mössinger
 * @version 1.0
 */

public class Figur {
	
	private double flaeche;
	
	/**
     * Erzeugt eine neue Fläche mit den übergebenen Werten.
     * @param Fläche der einzelnen Figuren.
     */
    
    protected Figur(double flaeche) {
    	this.flaeche = flaeche;
    }
    
    /**
     * Erzeugt die Fläche mit einem Wert 0.
     */
    
    protected Figur() {
    	this.flaeche = 0;
    }
    
    /**
     * Gibt Fläche aus.
     */
    
    public double getFlaeche() {
    	return this.flaeche;
    }
}
