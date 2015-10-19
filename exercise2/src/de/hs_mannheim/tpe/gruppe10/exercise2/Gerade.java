package de.hs_mannheim.tpe.gruppe10.exercise2;

/**
 * 
 * Klasse Gerade
 * 
 * Diese Klasse erzeugt ein Gerade. 
 * <p>
 * Sie erbt alle Methoden und Attribute der Klasse Figur.
 * Attribute können nur durch den Konstruktor verändert werden.
 * <p>
 * @author Tobias Jünemann und Kim Mössinger
 * @version 1.0
 */
public class Gerade extends Figur {
	private double laenge;
	
	/**
     * Erzeugt eine neues Gerade.
     * @param laenge Länge der Gerade.
     */
	public Gerade(double laenge) {
		super();
		
		this.laenge = laenge;
	}
	
	/**
     * Gibt die Länge aus.
     * @return die Länge der Gerade
     */   
	public double getLaenge() {
	    	return this.laenge;
	 }

}

