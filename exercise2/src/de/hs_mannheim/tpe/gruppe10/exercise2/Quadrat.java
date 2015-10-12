package de.hs_mannheim.tpe.gruppe10.exercise2;

public class Quadrat extends Rechteck {
	private double seite;
	
	public Quadrat(double seite) {
		super(seite, seite);
		
		this.seite = seite;
	}
	
	 public double getSeite() {
	    	return this.seite;
	 }

}
