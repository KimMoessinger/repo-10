package de.hs_mannheim.tpe.gruppe10.exercise2;

public class Rechteck extends Figur {
	private double hoehe = 0;
	private double breite = 0;
	
	protected Rechteck(double hoehe, double breite) {
		super(hoehe * breite);
		
		this.hoehe = hoehe;
		this.breite = breite;
	}
	
	 public double getHoehe() {
	    	return this.hoehe;
	 }
	 
	 public double getBreite() {
	    	return this.breite;
	 }

}
