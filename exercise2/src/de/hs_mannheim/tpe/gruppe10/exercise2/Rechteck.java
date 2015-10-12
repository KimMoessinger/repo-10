package de.hs_mannheim.tpe.gruppe10.exercise2;

public class Rechteck extends Figur {
	private double hoehe;
	private double breite;
	
	public Rechteck(double hoehe, double breite) {
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
