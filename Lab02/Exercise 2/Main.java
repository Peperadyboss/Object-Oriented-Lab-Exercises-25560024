import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter numerator for Fraction 1: ");
        int numerator1 = input.nextInt();

        System.out.print("Enter denominator for Fraction 1: ");
        int denominator1 = input.nextInt();

        Fraction fraction1 = new Fraction(numerator1, denominator1);

        System.out.print("Enter numerator for Fraction 2: ");
        int numerator2 = input.nextInt();

        System.out.print("Enter denominator for Fraction 2: ");
        int denominator2 = input.nextInt();

        Fraction fraction2 = new Fraction(numerator2, denominator2);

        System.out.print("\nFraction 1: ");
        fraction1.display();

        System.out.print("Fraction 2: ");
        fraction2.display();

        Fraction sum = fraction1.add(fraction2);
        System.out.print("Addition: ");
        sum.display();

        Fraction difference = fraction1.subtract(fraction2);
        System.out.print("Subtraction: ");
        difference.display();

        Fraction product = fraction1.multiply(fraction2);
        System.out.print("Multiplication: ");
        product.display();

        if (numerator2 != 0) {
            Fraction quotient = fraction1.divide(fraction2);
            System.out.print("Division: ");
            quotient.display();
        } else {
            System.out.println("Division: Cannot divide by zero.");
        }

        Fraction copy = new Fraction(fraction1);

        System.out.print("Copied Fraction: ");
        copy.display();

        System.out.println("Is the copy a different object? "
                + (fraction1 != copy));

        input.close();
    }
}