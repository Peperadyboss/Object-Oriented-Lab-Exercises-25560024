import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();

        System.out.println("Add two integers:");

        System.out.print("Enter a: ");
        int a = input.nextInt();

        System.out.print("Enter b: ");
        int b = input.nextInt();

        System.out.println("Result: " + calculator.add(a, b));
        System.out.println("Method selected: add(int, int)");


        System.out.println("\nAdd two doubles:");

        System.out.print("Enter a: ");
        int x = input.nextInt();

        System.out.print("Enter b: ");
        int y = input.nextInt();

        System.out.println(
            "Result: " + calculator.add((double) x, (double) y)
        );
        System.out.println("Method selected: add(double, double)");


        System.out.println("\nAdd three integers:");

        System.out.print("Enter a: ");
        int p = input.nextInt();

        System.out.print("Enter b: ");
        int q = input.nextInt();

        System.out.print("Enter c: ");
        int r = input.nextInt();

        System.out.println("Result: " + calculator.add(p, q, r));
        System.out.println("Method selected: add(int, int, int)");


        System.out.println("\nFind maximum of two integers:");

        System.out.print("Enter a: ");
        int m = input.nextInt();

        System.out.print("Enter b: ");
        int n = input.nextInt();

        System.out.println("Maximum: " + calculator.max(m, n));
        System.out.println("Method selected: max(int, int)");


        System.out.println("\nFind maximum of two doubles:");

        System.out.print("Enter a: ");
        int u = input.nextInt();

        System.out.print("Enter b: ");
        int v = input.nextInt();

        System.out.println(
            "Maximum: " + calculator.max((double) u, (double) v)
        );
        System.out.println("Method selected: max(double, double)");

        input.close();
    }
}