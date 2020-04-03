public class Fraction {
    int num;
    int deno;

    /**
     * Create a new Fraction with the numerator and the denominator.
     * @param num
     * @param deno
     * @throws IllegalArgumentException
     */

    public Fraction(int num, int deno) throws IllegalArgumentException {
        this.num = num;
        if (deno <= 0) {
            throw new IllegalArgumentException("The denominator must be positive.");
        }
        this.deno = deno;
    }

    /**
     * Calculate the decimal result of the fraction.
     * @return the decimal result of the fraction.
     */
    public double toDouble() {
        double doub = (double)this.num / (double)this.deno;
        return doub;
    }

    /**
     * Get a string that depicts the fraction's value.
     * @return a string that depicts the fraction's value.
     */
    public String toString() {
        String frac = this.num + "/" + this.deno;
        return frac;
    }

    /**
     * Compare whether the two fractions are the same.
     * @param other
     * @return a boolean value
     */
    public boolean equals(Object other) {
        Fraction otherFraction = (Fraction)other;
        return this.num == otherFraction.num && this.deno == otherFraction.deno;
    }

    /**
     * Get the reciprocal of the fraction.
     * @return the reciprocal of the fraction
     * @throws IllegalAccessException
     */
    public Fraction reciprocal() throws IllegalAccessException{
        if (this.num == 0) {
            throw new IllegalAccessException("The reciprocal is 0.");
        } else if (this.num < 0) {
            int newNum = -this.num;
            int newDeno = -this.deno;
            return new Fraction(newDeno, newNum);
        }
        return new Fraction(this.deno, this.num);
    }

    /**
     * Add this fraction to the one passed to it.
     * @param other
     * @return the summary as a fraction project
     * @throws IllegalAccessException
     */
    public Fraction add(Fraction other) throws IllegalArgumentException {
        int mult1 = this.num * other.deno + other.num * this.deno;
        int mult2 = this.deno * other.deno;

        int a = mult1;
        int b = mult2;
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        int newNum = mult1 / a;
        int newDeno = mult2 / a;

        return new Fraction(newNum, newDeno);
    }

    /**
     * Compares two fractions.
     * @param other
     * @return -1, if the other fraction is larger than this one.
     *         Or 1, if the other fraction is smaller than this one.
     *         Or 0, if the two fractions are equal.
     */
    public int compareTo(Fraction other) {
        int res = this.num * other.deno - this.deno * other.num;
        if (res == 0) {
            return 0;
        } else if (res > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    // Test part.
    public static void main (String[] args) throws IllegalArgumentException, IllegalAccessException {
        // Create three new fraction projects.
        Fraction frac1 = new Fraction(1, 2);
        Fraction frac2 = new Fraction(3, 4);
        Fraction frac3 = new Fraction(-1, 3);

        // Create a fraction that violates the rule of fraction.
        // Catch the error and throw a message.
        try {
            Fraction frac4 = new Fraction(1,-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }

        // Test the toDouble() method.
        System.out.println(frac1.toDouble());
        System.out.println(frac3.toDouble());

        // Test the toString() method.
        System.out.println(frac1.toString());

        // Create a new fraction which is the same as frac1.
        // Test the equals() method.
        Fraction frac5 = new Fraction(1, 2);
        System.out.println(frac1.equals(frac2));
        System.out.println(frac1.equals(frac5));

        // Test the reciprocal() method.
        System.out.println(frac1.reciprocal());
        System.out.println(frac3.reciprocal());

        // Test the add() method.
        System.out.println(frac1.add(frac2));
        System.out.println(frac1.add(frac3));

        // Test the compareTo() method.
        System.out.println(frac3.compareTo(frac1));
        System.out.println(frac1.compareTo(frac3));
    }
}
