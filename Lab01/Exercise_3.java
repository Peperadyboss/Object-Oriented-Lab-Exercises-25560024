import java.util.Scanner;

public class Exercise_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        
        int n = Math.abs(number);
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;   
            sum += digit;         
            n /= 10;              
        }

        System.out.println("The sum of the digits of " + number + " is: " + sum);

        scanner.close();
    }
}
// this calculates the sum by adding all integers of the same number together. I.e 1234 = 1 + 2 + 3 + 4 = 10