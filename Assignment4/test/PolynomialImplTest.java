/**
 * Test for PolynomialImpl
 *
 * @author TianhuiLi
 * CS5004 Assignment 4
 * 02/23/2020
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialImplTest {
    PolynomialImpl poly;

    @Before
    public void setUp() throws Exception {
        // create a new polynomial: 4x^3 + 3x^1 -5
        poly = new PolynomialImpl("4x^3 +3x^1 -5");
    }

    @Test
    public void addTerm() {
        try {
            poly.addTerm(1, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }

        // add a new term which has the same power
        poly.addTerm(1, 1);
        assertEquals("4x^3 +4x^1 -5", poly.toString());

        // add a new term which need to be inserted to the polynomial
        poly.addTerm(3, 2);
        assertEquals("4x^3 +3x^2 +4x^1 -5", poly.toString());

        // add a new term to the head
        poly.addTerm(5, 4);
        assertEquals("5x^4 +4x^3 +3x^2 +4x^1 -5", poly.toString());
    }

    @Test
    public void removeTerm() {
        poly.removeTerm(3);
        assertEquals("3x^1 -5", poly.toString());
    }

    @Test
    public void getDegree() {
        assertEquals(3, poly.getDegree());
    }

    @Test
    public void getCoefficient() {
        assertEquals(3, poly.getCoefficient(1));
    }

    @Test
    public void evaluate() {
        assertEquals(33, poly.evaluate(2), 0);
    }

    @Test
    public void add() {
        try {
            poly.add(new TermNode(3, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }

        PolynomialImpl poly2 = new PolynomialImpl("9x^5 +11x^2 -2");
        assertEquals("9x^5 +4x^3 +11x^2 +3x^1 -7", poly.add(poly2).toString());

        // check the two polynomials haven't been change after adding
        assertEquals("4x^3 +3x^1 -5", poly.toString());
        assertEquals("9x^5 +11x^2 -2", poly2.toString());
    }

    @Test
    public void testToString() {
        // check the representation of the polynomial with no terms
        PolynomialImpl empty = new PolynomialImpl();
        assertEquals("0", empty.toString());

        assertEquals("4x^3 +3x^1 -5", poly.toString());
    }
}