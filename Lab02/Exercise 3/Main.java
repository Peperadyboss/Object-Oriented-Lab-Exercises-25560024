import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Time time1 = new Time(23, 59, 50);

        System.out.print("Original time: ");
        time1.display();

        time1.addSeconds(20);

        System.out.print("After adding 20 seconds: ");
        time1.display();


        Time time2 = new Time(0, 0, 10);

        System.out.print("\nOriginal time: ");
        time2.display();

        time2.subtractSeconds(20);

        System.out.print("After subtracting 20 seconds: ");
        time2.display();


        System.out.println("\nEnter a time:");

        System.out.print("Hour: ");
        int hour = input.nextInt();

        System.out.print("Minute: ");
        int minute = input.nextInt();

        System.out.print("Second: ");
        int second = input.nextInt();

        Time time3 = new Time(hour, minute, second);

        System.out.print("Enter seconds to add: ");
        int seconds = input.nextInt();

        time3.addSeconds(seconds);

        System.out.print("Result: ");
        time3.display();

        input.close();
    }
}
