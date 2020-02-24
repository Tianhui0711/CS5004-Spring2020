/**
 * Implement a TermNode, represent each term in the polynomial
 *
 * @author TianhuiLi
 * CS5004 Assignment 4
 * 02/23/2020
 */

import java.util.Objects;

public class TermNode implements ListNode {
    private int coefficient;
    private int power;
    private ListNode next;

    /**
     * Construct a TermNode
     */
    public TermNode() {
    };

    /**
     * Overload the TermNode
     * @param coefficient the coefficient of the term
     * @param power the power of the node
     */
    public TermNode(int coefficient, int power){
        this.coefficient = coefficient;
        this.power = power;
    }

    /**
     * Get the coefficient of the term
     * @return the coefficient of the term
     */
    public int getCoefficient() {
        return coefficient;
    }

    /**
     * Get the power of the term
     * @return the power of the term
     */
    public int getPower() {
        return power;
    }

    /**
     * Add the coefficient to the original coefficient
     * @param i the integer provided to add to the coefficient
     */
    public void addCoefficient(int i) {
        this.coefficient += i;
    }

    /**
     * Get the next term
     * @return the next term
     */
    public ListNode getNext() {
        return this.next;
    }

    /**
     * Add the next term
     * @param next the next term to be added
     */
    public void addNext(ListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermNode termNode = (TermNode) o;
        return coefficient == termNode.coefficient &&
                power == termNode.power &&
                Objects.equals(next, termNode.next);
    }
}
