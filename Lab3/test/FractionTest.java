import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {
    private Fraction frac1;
    private Fraction frac2;
    private Fraction frac3;
    private Fraction frac4;


    @Before
    public void setUp() throws IllegalArgumentException {
        // Create new fractions
        frac1 = new Fraction(1, 2);
        frac2 = new Fraction(3, 4);
        frac3 = new Fraction(-1, 3);

        // Create a fraction that violates the rule of fraction.
        // Catch the error and throw a message.
        try {
            frac4 = new Fraction(1,-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    @Test
    public void toDouble() {
        // check if the double value of frac1 is 0.5
        assertEquals(0.5, frac1.toDouble(), 0);
    }

    @Test
    public void testToString() {
        // check the string description of frac1 is 1/2
        assertEquals("1/2", frac1.toString());
    }

    @Test
    public void testEquals() {
        // check frac1 and frac2 do not have the same value
        assertEquals(true, frac1.equals(frac1));
        assertEquals(false, frac1.equals(frac2));
    }

    @Test
    public void reciprocal() throws IllegalAccessException {
        // create the reciprocals of frac1 and frac3
        Fraction result1 = new Fraction(2, 1);
        Fraction result2 = new Fraction(-3, 1);

        // check frac1 and frac3 can be convert to right reciprocals
        assertEquals(result1, frac1.reciprocal());
        assertEquals(result2, frac3.reciprocal());

        // Create a fraction that violates the rule of fraction
        // Catch the error and throw a message
        try {
            Fraction frac5 = new Fraction(0,1);
            frac5.reciprocal();
        } catch (IllegalArgumentException e) {
            System.out.println("The reciprocal is 0.");
        }
    }

    @Test
    public void add() throws IllegalAccessException {
        Fraction result1 = new Fraction(5, 4);
        Fraction result2 = new Fraction(1, 6);

        // check the summary of frac1 and frac2 is equal to 5/4
        assertEquals(result1, frac1.add(frac2));

        // check the summary of frac1 and frac3 is equal to 1/6
        assertEquals(result2, frac1.add(frac3));
    }

    @Test
    public void compareTo() {
        // check frac1 is larger than frac3
        assertEquals(1, frac1.compareTo(frac3));

        // check frac1 is smaller than frac2
        assertEquals(-1, frac1.compareTo(frac2));

        // check frac1 has the same value as frac1
        assertEquals(0, frac2.compareTo(frac2));
    }
}