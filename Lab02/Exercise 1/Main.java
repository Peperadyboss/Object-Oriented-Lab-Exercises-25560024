import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Rectangle_Exercise rectangle1 = new Rectangle_Exercise();

        System.out.print("Enter width for Rectangle 2: ");
        int width2 = input.nextInt();

        System.out.print("Enter height for Rectangle 2: ");
        int height2 = input.nextInt();

        Rectangle_Exercise rectangle2 =
                new Rectangle_Exercise(width2, height2);

        System.out.print("Enter width for Rectangle 3: ");
        int width3 = input.nextInt();

        System.out.print("Enter height for Rectangle 3: ");
        int height3 = input.nextInt();

        Rectangle_Exercise rectangle3 =
                new Rectangle_Exercise(width3, height3);

        System.out.println("\nRectangle 1:");
        rectangle1.displayInfo();

        System.out.println("\nRectangle 2:");
        rectangle2.displayInfo();

        System.out.println("\nRectangle 3:");
        rectangle3.displayInfo();

        input.close();
    }
}