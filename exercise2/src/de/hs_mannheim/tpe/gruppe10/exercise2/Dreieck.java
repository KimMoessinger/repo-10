package de.hs_mannheim.tpe.gruppe10.exercise2;

public class Dreieck extends Figur {
	private double hoehe;
	private double grundseite;
	
	public Dreieck(double hoehe, double grundseite) {
		super((hoehe * grundseite) / 2);
		
		this.hoehe = hoehe;
		this.grundseite = grundseite;
	}
	
	 public double getHoehe() {
	    	return this.hoehe;
	 }
	 
	 public double getGrundseite() {
	    	return this.grundseite;
	 }

}
