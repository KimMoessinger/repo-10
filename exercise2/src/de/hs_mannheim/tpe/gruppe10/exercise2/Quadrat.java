package de.hs_mannheim.tpe.gruppe10.exercise2;

/**
 * 
 * Klasse Quadrat
 * 
 * Diese Klasse erzeugt ein Quadrat. 
 * <p>
 * Sie erbt alle Methoden und Attribute der Klasse Figur.
 * Attribute können nur durch den Konstruktor verändert werden.
 * <p>
 * @author Tobias Jünemann und Kim Mössinger
 * @version 1.0
 */
public class Quadrat extends Rechteck {
	private double seite;
	
	/**
     * Erzeugt eine neues Quadrat.
     * @param seite Eine Seite des Quadrats.
     */
	public Quadrat(double seite) {
		super(seite, seite);
		
		this.seite = seite;
	}
	
	/**
     * Gibt eine Seite des Quadrats aus.
     * @return die Seite des Quadrats
     */ 
	public double getSeite() {
	    	return this.seite;
	 }

}
