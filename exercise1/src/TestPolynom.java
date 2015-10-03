import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests für die Klasse Polynom.
 */
public class TestPolynom {

    private static final double PRECISION = 0.0001;

    @Test
    public void testCreation() {
        Polynom p1 = new Polynom();
        assertEquals(-1, p1.getGrad());

        p1 = new Polynom(0, 1, 0);
        assertEquals(1, p1.getGrad());

        p1 = new Polynom(0, 1, 0, 1, 0, 1, 0, 0, 0);
        assertEquals(5, p1.getGrad());

        p1 = new Polynom(1.5);
        assertEquals(0, p1.getGrad());

        double data[] = { 4, 3, 2, 1, 0, -1, -2, -3, -4 };
        p1 = new Polynom(data);
        assertArrayEquals(data, p1.getKoeffizienten(), PRECISION);

        p1 = new Polynom(data);
        assertEquals(4, p1.getKoeffizient(0), PRECISION);
        assertEquals(3, p1.getKoeffizient(1), PRECISION);
        assertEquals(-1, p1.getKoeffizient(5), PRECISION);
        
        // Hinzugefügt um Randbedingung zu prüfen
        assertEquals(-4, p1.getKoeffizient(8), PRECISION);
        assertEquals(0, p1.getKoeffizient(9), PRECISION);
    }

    @Test
    public void testBerechnung() {
        Polynom p = new Polynom(5);

        assertEquals(5.0, p.berechne(1.0), PRECISION);
        assertEquals(5.0, p.berechne(4.0), PRECISION);
        assertEquals(5.0, p.berechne(-1.0), PRECISION);

        p = new Polynom(-1, 5);

        assertEquals(-1.0, p.berechne(0.0), PRECISION);
        assertEquals(4.0, p.berechne(1.0), PRECISION);
        assertEquals(-6.0, p.berechne(-1.0), PRECISION);

        p = new Polynom(5, 0, -2,  0, 9.5, -8, 5);
        assertEquals(9.5, p.berechne(1), PRECISION);
        assertEquals(25.5, p.berechne(-1), PRECISION);
        assertEquals(59017.5, p.berechne(5), PRECISION);
        assertEquals(109017.5, p.berechne(-5), PRECISION);
    }
    
    // Hinzugefügt um calc(double[] xs) zu prüfen
    @Test
    public void testCalc() {
    	Polynom p = new Polynom(5, 0, -2,  0, 9.5, -8, 5);
    	double x[] = { 1, -1, 5, -5 };
        double fx[] = { 9.5, 25.5, 59017.5, 109017.5 };
        assertArrayEquals(fx, p.calc(x), PRECISION);
    }

    @Test
    public void testAddition() {
        Polynom p1 = new Polynom(5, 4, -2,  3, 9.5, -8);
        Polynom p2 = new Polynom(3, 7,  6, -6, 0.0,  4, 7, 11);
        Polynom pr = new Polynom(8, 11, 4, -3, 9.5, -4, 7, 11 );


        assertEquals(pr, p1.addiere(p2));


        p1 = new Polynom(5, 4, -2,  3, 9.5, -8);
        p2 = new Polynom(3, 7,  6, -6, 0.0);
        pr = new Polynom(8, 11, 4, -3, 9.5, -8);

        assertEquals(pr, p1.addiere(p2));

        p1 = new Polynom(5, 4, -2,  3, 9.5, -8);
        p2 = new Polynom();

        assertEquals(p1, p1.addiere(p2));


        p1 = new Polynom();
        p2 = new Polynom(5, 4, -2,  3, 9.5, -8);

        assertEquals(p2, p1.addiere(p2));
    }

    @Test
    public void testSubtraction() {
        Polynom p1 = new Polynom(5, 4, -2,  3, 9.5, -8);
        Polynom p2 = new Polynom(3, 7,  6, -6, 0.0,  4, 7, 11);
        Polynom pr = new Polynom(2, -3, -8, 9, 9.5, -12, -7, -11);

        assertEquals(pr, p1.subtrahiere(p2));

        p1 = new Polynom(5, 4, -2,  3, 9.5, -8);
        p2 = new Polynom(3, 7,  6, -6, 0.0);
        pr = new Polynom(2, -3, -8, 9, 9.5, -8 );

        assertEquals(pr, p1.subtrahiere(p2));


        p1 = new Polynom(5, 4, -2,  3, 9.5, -8);
        p2 = new Polynom();

        assertEquals(p1, p1.subtrahiere(p2));


        p1 = new Polynom();
        p2 = new Polynom(5, 4, -2,  3, 9.5, -8);
        pr = new Polynom(-5, -4, 2,  -3, -9.5, 8 );

        assertEquals(pr, p1.subtrahiere(p2));
    }

    @Test
    public void testDifferenzierenUndIntegrieren() {
        Polynom p1 = new Polynom(-10, 0, 0.5, -1, 2);
        Polynom pr = new Polynom(0, 1, -3, 8);

        System.out.println(p1);
        System.out.println(pr);

        assertEquals(pr,  p1.differenziere());

        Polynom pi = new Polynom(0, 0, 0.5, -1, 2);
        assertEquals(pi,  pr.integriere());
    }

    @Test
    public void testEquals() {
        assertEquals(new Polynom(), new Polynom());
        assertEquals(new Polynom(), new Polynom(0));
        assertEquals(new Polynom(0,0,1,0,0), new Polynom(0,0,1));
        assertEquals(new Polynom(1, 2, 3, 4), new Polynom(1, 2, 3, 4));
        assertFalse(new Polynom().equals(new Polynom(1)));
    }

    @Test
    public void testToString() {
        Polynom p = new Polynom(3, -2, 5, 0, -0.5, -4, 0, 0, -9);
        assertEquals("Grad 8:  -9x^8 - 4x^5 - 0,5x^4 + 5x^2 - 2x + 3", p.toString());
    }
}
