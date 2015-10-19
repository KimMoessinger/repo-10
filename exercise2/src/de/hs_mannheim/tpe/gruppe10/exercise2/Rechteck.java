package de.hs_mannheim.tpe.gruppe10.exercise2;

/**
 * 
 * Klasse Rechteck
 * 
 * Diese Klasse erzeugt ein Rechteck. 
 * <p>
 * Sie erbt alle Methoden und Attribute der Klasse Figur.
 * Attribute können nur durch den Konstruktor verändert werden.
 * <p>
 * @author Tobias Jünemann und Kim Mössinger
 * @version 1.0
 */

public class Rechteck extends Figur {
	private double hoehe;
	private double breite;
	
	/**
     * Erzeugt eine neues Rechteck.
     * @param hoehe Höhe des Rechtecks.
     * @param breite Breite des Rechtecks.
     */
	public Rechteck(double hoehe, double breite) {
		super(hoehe * breite);
		
		this.hoehe = hoehe;
		this.breite = breite;
	}
	
	/**
     * Gibt die Höhe aus.
     * @return die Höhe des Rechtecks
     */ 
	public double getHoehe() {
	    	return this.hoehe;
	 }
	 
	/**
     * Gibt die Breite aus.
     * @return die Breite des Rechtecks 
     */ 
	public double getBreite() {
	    	return this.breite;
	 }

}
