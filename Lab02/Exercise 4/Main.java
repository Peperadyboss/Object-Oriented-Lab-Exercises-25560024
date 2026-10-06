import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Circle 1:");

        System.out.print("Center X: ");
        int x1 = input.nextInt();

        System.out.print("Center Y: ");
        int y1 = input.nextInt();

        System.out.print("Radius: ");
        int r1 = input.nextInt();

        Circle circle1 = new Circle(x1, y1, r1);

        System.out.println("\nCircle 1");
        System.out.println("Area: " + circle1.area());
        System.out.println("Perimeter: " + circle1.perimeter());


        System.out.println("\nEnter Circle 2:");

        System.out.print("Center X: ");
        int x2 = input.nextInt();

        System.out.print("Center Y: ");
        int y2 = input.nextInt();

        System.out.print("Radius: ");
        int r2 = input.nextInt();

        Circle circle2 = new Circle(x2, y2, r2);

        System.out.println("\nCircle 2");
        System.out.println("Area: " + circle2.area());
        System.out.println("Perimeter: " + circle2.perimeter());


        System.out.println("\nTest a point for Circle 1:");

        System.out.print("Point X: ");
        int pointX1 = input.nextInt();

        System.out.print("Point Y: ");
        int pointY1 = input.nextInt();

        System.out.println(
            "Point is inside/on circle: "
            + circle1.contains(pointX1, pointY1)
        );


        System.out.println("\nTest a point for Circle 2:");

        System.out.print("Point X: ");
        int pointX2 = input.nextInt();

        System.out.print("Point Y: ");
        int pointY2 = input.nextInt();

        System.out.println(
            "Point is inside/on circle: "
            + circle2.contains(pointX2, pointY2)
        );

        input.close();
    }
}