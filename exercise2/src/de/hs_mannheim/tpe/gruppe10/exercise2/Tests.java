package de.hs_mannheim.tpe.gruppe10.exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests für Exercise2.
 */

public class Tests {

    private static final double PRECISION = 0.0001;

    @Test
    public void testFigur() {
    	Figur figur1 = new Figur();
    	
    	assertEquals(0, figur1.getFlaeche(), PRECISION);
    	
    	Figur figur2 = new Figur(30);
    	
    	assertEquals(30, figur2.getFlaeche(), PRECISION);
    }
    
    
    @Test
    public void testRechteck() {
    	Rechteck rechteck = new Rechteck(10, 20);
    	
    	assertEquals(200, rechteck.getFlaeche(), PRECISION);
    	assertEquals(10, rechteck.getHoehe(), PRECISION);
    	assertEquals(20, rechteck.getBreite(), PRECISION);
    }
    
    
    @Test
    public void testDreieck() {
    	Dreieck dreieck = new Dreieck(5, 10);
    	
    	assertEquals(25, dreieck.getFlaeche(), PRECISION);
    	assertEquals(5, dreieck.getHoehe(), PRECISION);
    	assertEquals(10, dreieck.getGrundseite(), PRECISION);
    }
    
    
    @Test
    public void testGerade() {
    	Gerade gerade = new Gerade(15);
    	
    	assertEquals(0, gerade.getFlaeche(), PRECISION);
    	assertEquals(15, gerade.getLaenge(), PRECISION);
    }
    
    
    @Test
    public void testQuadrat() {
    	Quadrat quadrat = new Quadrat(7);
    	
    	assertEquals(49, quadrat.getFlaeche(), PRECISION);
    	assertEquals(7, quadrat.getSeite(), PRECISION);
    }
}
