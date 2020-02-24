/**
 * The interface ListNode for the TermNode
 *
 * @author TianhuiLi
 * CS5004 Assignment 4
 * 02/23/2020
 */

public interface ListNode {
    /**
     * Get the coefficient of the term
     * @return the coefficient of the term
     */
    int getCoefficient();

    /**
     * Get the power of the term
     * @return the power of the term
     */
    int getPower();

    /**
     * Add the coefficient to the original coefficient
     * @param i the integer provided to add to the coefficient
     */
    void addCoefficient(int i);

    /**
     * Get the next ListNode
     * @return the next ListNode
     */
    ListNode getNext();

    /**
     * Add the next ListNode
     */
    void addNext(ListNode next);
}
