
import java.util.*;
import java.io.*;

class Product {
    private String name;
    private double volume;
    private double pricePerMl;

    public Product(String name, double volume, double pricePerMl) {
        if (volume <= 0 || pricePerMl < 0) {
            throw new IllegalArgumentException("Invalid volume or price.");
        }

        this.name = name;
        this.volume = volume;
        this.pricePerMl = pricePerMl;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return volume * pricePerMl;
    }

    @Override
    public String toString() {
        return name + " | Volume: " + volume + " ml | Price: "
                + String.format("%.0f VND", getPrice());
    }
}

class Perfume extends Product {
    public Perfume(String name, double volume, double price) {
        super(name, volume, price);
    }
}

class Shampoo extends Product {
    public Shampoo(String name, double volume, double price) {
        super(name, volume, price);
    }
}

class ShowerGel extends Product {
    public ShowerGel(String name, double volume, double price) {
        super(name, volume, price);
    }
}

abstract class Package {
    private String name;
    private ArrayList<Product> products = new ArrayList<>();

    public Package(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public abstract boolean hasRequiredProduct();

    public double getPrice() {
        double total = 0;

        for (Product p : products) {
            total += p.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        String result = name + "\n";

        for (Product p : products) {
            result += "  " + p + "\n";
        }

        return result + "Package price: "
                + String.format("%.0f VND", getPrice());
    }
}

class RomanticPackage extends Package {
    public RomanticPackage() {
        super("Romantic Package");
    }

    @Override
    public boolean hasRequiredProduct() {
        for (Product p : getProducts()) {
            if (p instanceof Perfume
                    && p.getName().equals("Rose Perfume")) {
                return true;
            }
        }

        return false;
    }
}

class FreshAirPackage extends Package {
    public FreshAirPackage() {
        super("Fresh-Air Package");
    }

    @Override
    public boolean hasRequiredProduct() {
        for (Product p : getProducts()) {
            if (p instanceof Shampoo
                    && p.getName().startsWith("Oily Hair Shampoo")) {
                return true;
            }
        }

        return false;
    }
}

class Customer {
    private String id;
    private String name;
    private String address;
    private String phone;

    public Customer(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id
                + "\nName: " + name
                + "\nAddress: " + address
                + "\nPhone: " + phone;
    }
}

class Order {
    private String id;
    private String date;
    private Customer customer;
    private Package productPackage;

    public Order(String id, String date, Customer customer, Package p) {
        if (customer == null || p == null || !p.hasRequiredProduct()) {
            throw new IllegalArgumentException(
                    "Customer or required package product is missing.");
        }

        this.id = id;
        this.date = date;
        this.customer = customer;
        this.productPackage = p;
    }

    @Override
    public String toString() {
        return "Order ID: " + id
                + "\nInvoice date: " + date
                + "\n" + customer
                + "\n" + productPackage
                + "\nOrder total: "
                + String.format("%.0f VND", productPackage.getPrice())
                + "\n";
    }
}

public class Exercise_5 {
    static Scanner sc = new Scanner(System.in);

    static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    static int readInt(String message, int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(readText(message));

                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Ask for input again.
            }

            System.out.println("Enter a number from "
                    + min + " to " + max + ".");
        }
    }

    static double readVolume() {
        while (true) {
            try {
                double volume = Double.parseDouble(
                        readText("Volume (ml): "));

                if (Double.isFinite(volume) && volume > 0) {
                    return volume;
                }
            } catch (NumberFormatException e) {
                // Ask for input again.
            }

            System.out.println("Volume must be a positive number.");
        }
    }

    static Product createProduct(int choice) {
        double volume = readVolume();

        switch (choice) {
            case 1:
                return new Perfume("Rose Perfume", volume, 20000);
            case 2:
                return new Perfume("Chamomile Perfume", volume, 15000);
            case 3:
                return new Shampoo("Dry Hair Shampoo", volume, 20000);
            case 4:
                return new Shampoo(
                        "Oily Hair Shampoo - Standard 1", volume, 30000);
            case 5:
                return new Shampoo(
                        "Oily Hair Shampoo - Standard 2", volume, 40000);
            case 6:
                return new ShowerGel(
                        "Dry Skin Shower Gel", volume, 20000);
            case 7:
                return new ShowerGel(
                        "Oily Skin Shower Gel", volume, 40000);
            default:
                return null;
        }
    }

    static void showProducts() {
        System.out.println("\nProducts:");
        System.out.println("1. Rose Perfume - 20000 VND/ml");
        System.out.println("2. Chamomile Perfume - 15000 VND/ml");
        System.out.println("3. Dry Hair Shampoo - 20000 VND/ml");
        System.out.println("4. Oily Hair Shampoo Standard 1 - 30000 VND/ml");
        System.out.println("5. Oily Hair Shampoo Standard 2 - 40000 VND/ml");
        System.out.println("6. Dry Skin Shower Gel - 20000 VND/ml");
        System.out.println("7. Oily Skin Shower Gel - 40000 VND/ml");
    }

    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();

        int n = readInt("Number of orders: ", 1, 1000);

        for (int i = 1; i <= n; i++) {
            System.out.println("\nOrder " + i);

            Customer customer = new Customer(
                    readText("Customer ID: "),
                    readText("Full name: "),
                    readText("Address: "),
                    readText("Phone: "));

            String date = readText("Invoice date (YYYY-MM-DD): ");

            System.out.println("1. Romantic Package");
            System.out.println("2. Fresh-Air Package");

            int choice = readInt("Choose package: ", 1, 2);

            Package p;

            if (choice == 1) {
                p = new RomanticPackage();
            } else {
                p = new FreshAirPackage();
            }

            while (!p.hasRequiredProduct()) {
                showProducts();

                int productChoice = readInt("Choose product: ", 1, 7);
                p.addProduct(createProduct(productChoice));

                if (!p.hasRequiredProduct()) {
                    System.out.println(
                            "Please add the required product.");
                }
            }

            while (readText("Add another product? (yes/no): ")
                    .equalsIgnoreCase("yes")) {
                showProducts();

                int productChoice = readInt("Choose product: ", 1, 7);
                p.addProduct(createProduct(productChoice));
            }

            orders.add(new Order("ORD" + i, date, customer, p));
        }

        System.out.println("\n========== ALL ORDERS ==========");

        try (PrintWriter out =
                     new PrintWriter(new FileWriter("order_list.txt"))) {

            for (Order order : orders) {
                System.out.println(order);
                out.println(order);
            }

            System.out.println("Orders saved to order_list.txt");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }

        sc.close();
    }
}
