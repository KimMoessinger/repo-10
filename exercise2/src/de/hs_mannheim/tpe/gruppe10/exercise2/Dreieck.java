package de.hs_mannheim.tpe.gruppe10.exercise2;

/**
 * 
 * Klasse Dreieck
 * 
 * Diese Klasse erzeugt ein Dreieck. 
 * <p>
 * Sie erbt alle Methoden und Attribute der Klasse Figur.
 * Attribute können nur durch den Konstruktor verändert werden.
 * <p>
 * @author Tobias Jünemann und Kim Mössinger
 * @version 1.0
 */

public class Dreieck extends Figur {
	private double hoehe;
	private double grundseite;
	
	/**
     * Erzeugt eine neues Dreieck.
     * @param hoehe Höhe des Dreieck.
     * @param grundseite Grundseite des Dreieck.
     */
	public Dreieck(double hoehe, double grundseite) {
		super((hoehe * grundseite) / 2);
		
		this.hoehe = hoehe;
		this.grundseite = grundseite;
	}
	
	/**
     * Gibt die Höhe aus.
     * @return die Höhe des Dreieck
     */  
	public double getHoehe() {
	    	return this.hoehe;
	 }
	 
	/**
     * Gibt die Grundseite aus.
     * @return die Grundseite des Dreieck
     */  
	public double getGrundseite() {
	    	return this.grundseite;
	 }

}
