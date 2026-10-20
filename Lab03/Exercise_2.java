import java.util.*;

abstract class Ticket {
    private String ticketId;
    private String holderName;
    private int birthYear;
    private int gamesPlayed;

    public Ticket(String ticketId, String holderName,
                  int birthYear, int gamesPlayed) {

        if (ticketId == null || ticketId.trim().isEmpty()
                || holderName == null || holderName.trim().isEmpty()
                || birthYear <= 0 || birthYear > 2026
                || gamesPlayed < 0 || gamesPlayed > 30) {
            throw new IllegalArgumentException(
                    "Invalid ticket data.");
        }

        this.ticketId = ticketId;
        this.holderName = holderName;
        this.birthYear = birthYear;
        this.gamesPlayed = gamesPlayed;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public abstract double calculatePrice();
}

class FullPackageTicket extends Ticket {

    public FullPackageTicket(String id, String name,
                             int birthYear, int gamesPlayed) {
        super(id, name, birthYear, gamesPlayed);

        if (gamesPlayed != 30) {
            throw new IllegalArgumentException(
                    "Full Package Ticket must cover exactly 30 games.");
        }
    }

    @Override
    public double calculatePrice() {
        return 200000;
    }
}

class PartialTicket extends Ticket {

    public PartialTicket(String id, String name,
                         int birthYear, int gamesPlayed) {
        super(id, name, birthYear, gamesPlayed);

        if (gamesPlayed >= 30) {
            throw new IllegalArgumentException(
                    "Partial Ticket must cover 0 to 29 games.");
        }
    }

    @Override
    public double calculatePrice() {
        return 70000 + 20000 * getGamesPlayed();
    }
}

public class Exercise_2 {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid integer.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();

        int n;

        do {
            n = readInt(sc, "Number of tickets: ");

            if (n < 0) {
                System.out.println(
                        "Count cannot be negative.");
            }
        } while (n < 0);

        for (int i = 0; i < n; i++) {
            System.out.println("\nTicket " + (i + 1));

            try {
                int type;

                do {
                    type = readInt(sc,
                            "Type (1 = Full Package, 2 = Partial): ");

                    if (type != 1 && type != 2) {
                        System.out.println(
                                "Please choose 1 or 2.");
                    }
                } while (type != 1 && type != 2);

                System.out.print("Ticket ID: ");
                String id = sc.nextLine();

                System.out.print("Holder name: ");
                String name = sc.nextLine();

                int birthYear = readInt(sc, "Year of birth: ");

                int games;

                if (type == 1) {
                    // Full Package Ticket requires exactly 30 games.
                    do {
                        games = readInt(sc,
                                "Number of games (30 only): ");

                        if (games != 30) {
                            System.out.println(
                                    "Full Package Ticket must cover exactly 30 games.");
                        }
                    } while (games != 30);

                    tickets.add(new FullPackageTicket(
                            id, name, birthYear, games));

                } else {
                    // Partial Ticket allows 0 to 29 games.
                    do {
                        games = readInt(sc,
                                "Number of games (0-29): ");

                        if (games < 0 || games > 29) {
                            System.out.println(
                                    "Partial Ticket must cover 0 to 29 games.");
                        }
                    } while (games < 0 || games > 29);

                    tickets.add(new PartialTicket(
                            id, name, birthYear, games));
                }

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Invalid ticket: " + e.getMessage());
                i--;
            }
        }

        double totalRevenue = 0;
        int partialCount = 0;

        System.out.println("\n===== TICKET RESULTS =====");

        for (Ticket t : tickets) {
            System.out.println("Ticket ID: " + t.getTicketId());
            System.out.println("Holder name: " + t.getHolderName());
            System.out.println("Year of birth: " + t.getBirthYear());
            System.out.println("Games played: " + t.getGamesPlayed());

            System.out.printf("Price: %.0f VND%n",
                    t.calculatePrice());

            System.out.println("-------------------------");

            totalRevenue += t.calculatePrice();

            if (t instanceof PartialTicket) {
                partialCount++;
            }
        }

        System.out.printf("Total revenue: %.0f VND%n",
                totalRevenue);

        System.out.println(
                "Number of Partial Tickets sold: " + partialCount);

        sc.close();
    }
}

