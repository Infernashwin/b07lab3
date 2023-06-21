package lab3;
/**
 * This Class represents a rational number using 2 integers for the numerator and denominator
 */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber> 
{
    /**
     * numerator represents the numerator of the rational function
     * denominator represents the denominator of the ration function
     */
    public int numerator;
    public int denominator;

    /**
     * Constructor for the Rational Numbers. Creates a rational number based on the given numerator
     * and denominator
     * @param num the numerator of the rational number
     * @param denom the denominator of the rational number
     * @throws Lab3Exception if the denominator is 0
     */
    public RationalNumber(int num, int denom) throws Lab3Exception {
        if (denom == 0) {
            throw new Lab3Exception("Denominator cannot be zero");
        }

        this.numerator = num;
        this.denominator = denom;
    }
    /**
     * Adds the given Special Number to the calling Rational Number and return the sum
     * @param num the Special Number we are attempting to add to the calling rational number
     * @return the sum of the num and the calling rational number
     * @throws Lab3Exception if num is not a rational number
     * */
    @Override
    public SpecialNumber add(SpecialNumber num) throws Lab3Exception 
    {
        if (!(num instanceof RationalNumber))
        {
            throw new Lab3Exception("Cannot add an incompatible type");
        }

        RationalNumber rnum = (RationalNumber) num;
        return new RationalNumber(this.numerator * rnum.denominator + this.denominator*rnum.numerator,
                this.denominator * rnum.denominator);

    }
    /**
     * Divides the calling rational number by the given integer
     * @param divisor the integer that will divide our rational number
     * @return a new rational number which is the calling rational number divided by our divisor
     * @throws Lab3Exception if the divisor is 0
     * */
    @Override
    public SpecialNumber divideByInt(int divisor) throws Lab3Exception {
        if (divisor == 0) {
            throw new Lab3Exception("Cannot divide by zero");
        }

        return new RationalNumber(this.numerator, this.denominator * divisor);
    }

    /**
     * Compares two rational numbers and return an integer to represent the relationship between the two
     * is bigger, negative is the calling rational number is smaller, and zero if they are equal
     * @param num  the rational number we are comparing the calling rational number to
     * @return positive integer if the calling rational number is bigger, negative is the calling rational number
     * is smaller, and zero if they are equal
     */
    @Override
    public int compareTo(RationalNumber num) {
        double numa = (double) this.numerator / this.denominator;
        double numb = (double) num.numerator / num.denominator;
        return Double.compare(numa, numb);
    }

    /**
     *Compares the calling rational number to a given object and returns if they are equivalent
     * @param obj the object that we are comparing to the calling rational number
     * @return true if the object is an equivalent rational number to the calling rational number, false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof RationalNumber num)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        return (this.compareTo(num) == 0);

    }

    /**
     * Finds the Greatest Common Divisor (GCD) of two integers
     * @param numa One of the two integers whose GCD we are looking for
     * @param numb The other integer whose GCD we are looking for
     * @return The Greatest Common Divisor of numa and numb
     */
    public int GCD(int numa, int numb) {
        int gcd = 1;
        for (int x = 1; x <= Math.min(numa, numb); x++) {
            if (numa % x == 0 && numb % x == 0)
                gcd = x;
        }
        return gcd;
    }

    /**
     * Creates and returns the hashCode for the calling rational number
     * @return the hashCode of the calling rational number
     */
    @Override
    public int hashCode() {
        int hash = 1;
        long prime = 3;

        int gcd = GCD(this.numerator, this.denominator);
        hash = (int) (hash * prime + this.numerator / gcd);
        hash = (int) (hash * prime + this.denominator / gcd);

        return hash;
    }

}
