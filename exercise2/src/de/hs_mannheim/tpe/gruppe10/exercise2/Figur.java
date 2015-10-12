package de.hs_mannheim.tpe.gruppe10.exercise2;

public class Figur {
	
	private double flaeche;
    
    protected Figur(double flaeche) {
    	this.flaeche = flaeche;
    }
    
    protected Figur() {
    	this.flaeche = 0;
    }
    
    public double getFlaeche() {
    	return this.flaeche;
    }
}
