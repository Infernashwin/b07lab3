package lab3;
public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber> {
    public double real;
    public double imaginary;

    public ComplexNumber(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    @Override
    public SpecialNumber add(SpecialNumber num) throws Lab3Exception {
        if (!(num instanceof ComplexNumber)) {
            throw new Lab3Exception("Cannot add an incompatible type");
        }

        ComplexNumber c = (ComplexNumber) num;
        double nreal = this.real + c.real;
        double nimag = this.imaginary + c.imaginary;
        return new ComplexNumber(nreal, nimag);
    }

    @Override
    public SpecialNumber divideByInt(int divisor) throws Lab3Exception {
        if (divisor == 0) {
            throw new Lab3Exception("Cannot divide by zero");
        }

        double nreal = this.real / divisor;
        double nimag = this.imaginary / divisor;
        return new ComplexNumber(nreal, nimag);
    }
    @Override
    public int compareTo(ComplexNumber num) {
        double maga = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
        double magb = Math.sqrt(Math.pow(num.real, 2) + Math.pow(num.imaginary, 2));

        return Double.compare(magb, maga);
    }

    @Override
    public int hashCode() {
        return (int) (this.real * 3 + this.imaginary * 5);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComplexNumber)) {
            return false;
        }

        ComplexNumber c = (ComplexNumber) obj;
        return (this.real == c.real && this.imaginary == c.imaginary);
    }
}
