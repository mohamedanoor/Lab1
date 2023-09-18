public class Fraction implements INumber<Fraction> {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    @Override
    public Fraction plus(Fraction input) {
        int commonDenominator = this.denominator * input.denominator;
        int newNumerator = this.numerator * input.denominator + input.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator);
    }

    @Override
    public Fraction minus(Fraction input) {
        int commonDenominator = this.denominator * input.denominator;
        int newNumerator = this.numerator * input.denominator - input.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator);
    }

    @Override
    public Fraction divide(Fraction input) {
        if (input.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        int newNumerator = this.numerator * input.denominator;
        int newDenominator = this.denominator * input.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    @Override
    public Fraction multiply(Fraction input) {
        int newNumerator = this.numerator * input.numerator;
        int newDenominator = this.denominator * input.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    @Override
    public void print() {
        System.out.println(this.numerator + "/" + this.denominator);
    }
    
}