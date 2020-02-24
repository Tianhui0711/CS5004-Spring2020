/**
 * The interface Polynomial of the PolynomialImpl
 *
 * @author TianhuiLi
 * CS5004 Assignment 4
 * 02/23/2020
 */

public interface Polynomial {
    /**
     * Adds the resulting term to the polynomial
     * @param coefficient
     * @param power
     */
    void addTerm(int coefficient, int power);

    /**
     * Removes any and all terms in the polynomial with the power
     * @param power
     */
    void removeTerm(int power);

    /**
     * Returns the degree of this polynomial (the highest power of the variable in a term)
     * @return the degree
     */
    int getDegree();

    /**
     * Returns the coefficient for the term with that power
     * @param power the power of the term
     * @return the coefficient for the term with that power
     */
    int getCoefficient(int power);

    /**
     * Returns a double-precision result
     * @param x the double-precision decimal number
     * @return the double-precision result
     */
    double evaluate(double x);

    /**
     * Returns the polynomial obtained by adding the two polynomials
     * Does not mutate either polynomial
     * @param other the other polynomial
     * @return a new added polynomial
     */
    Polynomial add(Object other);
}
