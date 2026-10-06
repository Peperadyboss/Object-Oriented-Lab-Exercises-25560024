import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        UITStudent student1 = new UITStudent();

        UITStudent student2 = new UITStudent(1002, "Nguyen Van An");

        UITStudent student3 = new UITStudent(
            1003,
            "Tran Thi Binh",
            "Computer Science",
            3.8
        );

        UITStudent student4 = new UITStudent(
            1004,
            "Le Van Cuong",
            "Information Technology",
            2.7
        );

        UITStudent student5 = new UITStudent(
            1005,
            "Pham Thi Dung",
            "Data Science",
            1.8
        );

        System.out.println("===== STUDENT 1 =====");
        student1.displayInfo();

        System.out.println("\n===== STUDENT 2 =====");
        student2.displayInfo();

        System.out.println("\n===== STUDENT 3 =====");
        student3.displayInfo();

        System.out.println("\n===== STUDENT 4 =====");
        student4.displayInfo();

        System.out.println("\n===== STUDENT 5 =====");
        student5.displayInfo();


        // Create another student using Scanner
        System.out.println("\n===== CREATE YOUR OWN STUDENT =====");

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine(); // Clear newline

        System.out.print("Enter Full Name: ");
        String name = input.nextLine();

        System.out.print("Enter Major: ");
        String major = input.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = input.nextDouble();

        UITStudent student6 = new UITStudent(id, name, major, gpa);

        System.out.println("\n===== YOUR STUDENT =====");
        student6.displayInfo();

        input.close();
    }
}
