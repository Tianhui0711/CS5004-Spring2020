/**
 * Implement a polynomial which consists of several terms
 * The polynomial terms is in decreasing order of their powers
 *
 * @author TianhuiLi
 * CS5004 Assignment 4
 * 02/23/2020
 */

public class PolynomialImpl implements Polynomial {
    private TermNode head;

    /**
     * Construct a polynomial with no parameter
     */
    public PolynomialImpl() {
        this.head = new TermNode();
    }

    /**
     * Construct a polynomial, which takes a string, parses it and creates the polynomial accordingly
     * @param s the string representing the polynomial
     *          it contains the polynomial, with each term separated by a space
     *          e.g. "4x^3 +3x^1 -5"
     */
    public PolynomialImpl(String s) {
        // split the string by space
        String[] terms = s.split(" ");
        for (int i = 0; i < terms.length; i++) {
            // split the string by "x^"
            String[] coAndPow = terms[i].split("x\\^");
            int co = Integer.parseInt(coAndPow[0]);
            int power = 0;
            // if the power of term is not 0
            if (coAndPow.length == 2) {
                power = Integer.parseInt(coAndPow[1]);
            }
            this.addTerm(co, power);
        }
    }

    /**
     * Adds the new term to the original polynomial
     * @param coefficient the coefficient of the new term
     * @param power the coefficient of the new term
     * @throw IllegalArgumentException if a negative power is passed to it
     */
    public void addTerm(int coefficient, int power) throws IllegalArgumentException{
        if (power < 0) {
            throw new IllegalArgumentException("The power should be positive.");
        }

        // if the head is null, create new head
        if (head == null) {
            head = new TermNode(coefficient, power);
            return;
        }

        // if thw power of the new term is lager than the head, the new term should be the head
        if (power > head.getPower()) {
            ListNode temp = head;
            head = new TermNode(coefficient, power);
            head.addNext(temp);
            return;
        }

        ListNode p = head;
        // find the right position to add the new term
        while (p.getNext() != null) {
            if (power == p.getPower() || power > p.getNext().getPower()) {
                break;
            }
            p = p.getNext();
        }

        // if the power of the new term exists in the polynomial, simply increment the coefficient
        if (power == p.getPower()) {
            // if the sum of coefficient is 0, remove this term
            if (p.getCoefficient() + coefficient == 0) {
                this.removeTerm(power);
                return;
            }
            p.addCoefficient(coefficient);
            return;
        }
        // insert the new term to the right position
        TermNode newTerm = new TermNode(coefficient, power);
        newTerm.addNext(p.getNext());
        p.addNext(newTerm);
    }

    /**
     * Removes any and all terms in the polynomial with the power
     * @param power
     */
    public void removeTerm(int power) {
        // if the removed item is the head
        if (power == head.getPower()) {
            head = (TermNode) head.getNext();
            return;
        }

        ListNode p = head;
        while (p.getNext() != null) {
            if (power == p.getNext().getPower()) {
                p.addNext(p.getNext().getNext());
                return;
            }
            p = p.getNext();
        }
    }

    /**
     * Returns the degree of this polynomial (the highest power of the variable in a term)
     * @return the degree
     */
    public int getDegree() {
        return head.getPower();
    }

    /**
     * Returns the coefficient for the term with that power
     * @param power the power of the term
     * @return the coefficient for the term with that power
     */
    public int getCoefficient(int power) {
        ListNode p = head;
        while (p != null) {
            if (p.getPower() == power) {
                break;
            }
            p = p.getNext();
        }
        return p.getCoefficient();
    }

    /**
     * Returns a double-precision result
     * @param x the double-precision decimal number
     * @return the double-precision result
     */
    public double evaluate(double x) {
        ListNode p = head;
        double result = 0;
        while (p != null) {
            result += p.getCoefficient() * Math.pow(x, p.getPower());
            p = p.getNext();
        }
        return result;
    }

    /**
     * Returns the polynomial obtained by adding the two polynomials
     * Does not mutate either polynomial
     * @param other the other polynomial
     * @throws IllegalArgumentException if the input is a different class
     * @return a new polynomial
     */
    public Polynomial add(Object other) throws IllegalArgumentException{
        if (!(other instanceof PolynomialImpl)) {
            throw new IllegalArgumentException("The input should be a polynomial");
        }
        Polynomial newPoly = new PolynomialImpl(this.toString());
        PolynomialImpl that = (PolynomialImpl) other;
        ListNode p = that.head;
        while (p != null) {
            newPoly.addTerm(p.getCoefficient(), p.getPower());
            p = p.getNext();
        }
        return newPoly;
    }

    /**
     * Returns a string that contains the polynomial
     * @return a string that contains the polynomial
     *          e.g. 5𝑥2+4𝑥−2 creates the string “5x^2 +4x^1 -2”
     */
    public String toString() {
        if (head == null) {
            return "0";
        }

        String poly = "";
        ListNode p = head;
        while (p != null) {
            String co = String.valueOf(p.getCoefficient());
            String power = String.valueOf(p.getPower());
            if (p != head && p.getCoefficient() > 0) {
                co = "+" + co;
            }
            poly += co;
            if (!power.equals("0")) {
                poly += "x^" + power + " ";
            }
            p = p.getNext();
        }
        // cut the end space
        poly = poly.trim();
        return poly;
    }
}
