/**
 * Test for TermNode
 *
 * @author TianhuiLi
 * CS5004 Assignment 4
 * 02/23/2020
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TermNodeTest {
    TermNode term;

    @Before
    public void setUp() throws Exception {
        term = new TermNode(1,2);
    }

    @Test
    public void getCoefficient() {
        assertEquals(1, term.getCoefficient());
    }

    @Test
    public void getPower() {
        assertEquals(2, term.getPower());
    }

    @Test
    public void addCoefficient() {
        term.addCoefficient(3);
        assertEquals(4, term.getCoefficient());
    }

    @Test
    public void getNext() {
        // check the next TermNode of term is term2
        TermNode term2 = new TermNode(3,1);
        term.addNext(term2);
        assertEquals(term2, term.getNext());
    }

    @Test
    public void addNext() {
        //check term3 has been added successfully
        TermNode term3 = new TermNode(1,0);
        term.addNext(term3);
        assertEquals(term3, term.getNext());
    }
}