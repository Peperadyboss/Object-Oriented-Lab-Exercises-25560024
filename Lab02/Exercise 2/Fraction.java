public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            denominator = 1;
        }

        this.numerator = numerator;
        this.denominator = denominator;

        simplify();
    }

    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    public void simplify() {
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        if (a != 0) {
            numerator /= a;
            denominator /= a;
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Fraction add(Fraction other) {
        int newNumerator =
                numerator * other.denominator
                + other.numerator * denominator;

        int newDenominator = denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator =
                numerator * other.denominator
                - other.numerator * denominator;

        int newDenominator = denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = numerator * other.numerator;
        int newDenominator = denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

    public void display() {
        System.out.println(numerator + "/" + denominator);
    }
}