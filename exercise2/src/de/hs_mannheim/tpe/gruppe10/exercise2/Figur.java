package de.hs_mannheim.tpe.gruppe10.exercise2;

public class Figur {
	
	private double flaeche = 0;
    
    protected Figur(double flaeche) {
    	this.flaeche = flaeche;
    }
    
    public double getFlaeche() {
    	return this.flaeche;
    }
}
