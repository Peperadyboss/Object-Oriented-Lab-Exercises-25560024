import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String fullName;
    private int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}

class Guest extends Person {
    private String citizenIDCard;

    public Guest(String id, String name, int age) {
        super(name, age);
        this.citizenIDCard = id;
    }

    public String getCitizenIDCard() {
        return citizenIDCard;
    }
}

class Staff extends Person {
    private String licenseID;
    private String employeeID;

    public Staff(String licenseID, String employeeID,
                 String name, int age) {
        super(name, age);
        this.licenseID = licenseID;
        this.employeeID = employeeID;
    }

    public String getLicenseID() {
        return licenseID;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}

class Room {
    private String roomType;
    private long pricePerDay;

    public Room(String roomType, long pricePerDay) {
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
    }

    public long calculateCost(int days) {
        if (days <= 0) {
            return 0;
        }
        return pricePerDay * days;
    }

    public String getRoomType() {
        return roomType;
    }

    public long getPricePerDay() {
        return pricePerDay;
    }
}

public class Exercise_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        // Add a guest
        System.out.print("Enter guest ID: ");
        String id = sc.nextLine();

        System.out.print("Enter guest name: ");
        String name = sc.nextLine();

        System.out.print("Enter guest age: ");
        int age = Integer.parseInt(sc.nextLine());

        if (age <= 0 || age > 120) {
            System.out.println("Invalid age.");
            sc.close();
            return;
        }

        people.add(new Guest(id, name, age));
        System.out.println("Guest added.");

        // Add a staff member
        System.out.println("\nEnter staff information:");

        System.out.print("Enter staff license ID: ");
        String licenseID = sc.nextLine();

        System.out.print("Enter staff employee ID: ");
        String employeeID = sc.nextLine();

        System.out.print("Enter staff name: ");
        String staffName = sc.nextLine();

        System.out.print("Enter staff age: ");
        int staffAge = Integer.parseInt(sc.nextLine());

        if (staffAge <= 0 || staffAge > 120) {
            System.out.println("Invalid staff age.");
            sc.close();
            return;
        }

        Staff staff = new Staff(
            licenseID, employeeID, staffName, staffAge
        );

        System.out.println("\nStaff added successfully.");
        System.out.println("Staff name: " + staff.getFullName());
        System.out.println("Staff age: " + staff.getAge());
        System.out.println("License ID: " + staff.getLicenseID());
        System.out.println("Employee ID: " + staff.getEmployeeID());

        // Remove a guest by ID
        System.out.print("\nEnter guest ID to remove: ");
        String removeID = sc.nextLine();

        boolean removed = false;

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof Guest) {
                Guest g = (Guest) people.get(i);

                if (g.getCitizenIDCard().equals(removeID)) {
                    people.remove(i);
                    removed = true;
                    break;
                }
            }
        }

        if (removed) {
            System.out.println("Guest removed.");
        } else {
            System.out.println("Guest not found.");
        }

        // Calculate room rental
        System.out.println("\nRoom types: VIP1, VIP2, VIP3");
        System.out.print("Enter room type: ");
        String type = sc.nextLine().toUpperCase();

        long price;

        switch (type) {
            case "VIP1":
                price = 900000;
                break;
            case "VIP2":
                price = 700000;
                break;
            case "VIP3":
                price = 500000;
                break;
            default:
                System.out.println("Invalid room type.");
                sc.close();
                return;
        }

        System.out.print("Enter number of rental days: ");
        int days = Integer.parseInt(sc.nextLine());

        if (days <= 0) {
            System.out.println("Days must be greater than 0.");
        } else {
            Room room = new Room(type, price);

            System.out.println("Room type: " + room.getRoomType());
            System.out.println(
                "Price per day: " + room.getPricePerDay() + " VND"
            );
            System.out.println(
                "Total cost: " + room.calculateCost(days) + " VND"
            );
        }

        sc.close();
    }
}
