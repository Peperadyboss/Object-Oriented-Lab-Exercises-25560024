import java.util.ArrayList;
import java.util.Scanner;

abstract class Singer {
    private String fullName;
    private int yearsOfExperience;
    private long albumsSold;
    private long performances;

    public Singer(String fullName, int yearsOfExperience,
                  long albumsSold, long performances) {
        setFullName(fullName);
        setYearsOfExperience(yearsOfExperience);
        setAlbumsSold(albumsSold);
        setPerformances(performances);
    }

    public String getFullName() {
        return fullName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public long getAlbumsSold() {
        return albumsSold;
    }

    public long getPerformances() {
        return performances;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.fullName = fullName.trim();
    }

    public void setYearsOfExperience(int years) {
        if (years < 0) {
            throw new IllegalArgumentException(
                "Years of experience cannot be negative.");
        }
        this.yearsOfExperience = years;
    }

    public void setAlbumsSold(long albumsSold) {
        if (albumsSold < 0) {
            throw new IllegalArgumentException(
                "Albums sold cannot be negative.");
        }
        this.albumsSold = albumsSold;
    }

    public void setPerformances(long performances) {
        if (performances < 0) {
            throw new IllegalArgumentException(
                "Performances cannot be negative.");
        }
        this.performances = performances;
    }

    public abstract long calculateSalary();

    public void displayInfo() {
        System.out.println("Name: " + fullName);
        System.out.println("Years of experience: " + yearsOfExperience);
        System.out.println("Albums sold: " + albumsSold);
        System.out.println("Performances: " + performances);
        System.out.printf("Salary: %,d VND%n", calculateSalary());
    }
}

class RegularSinger extends Singer {

    public RegularSinger(String name, int years,
                         long albums, long performances) {
        super(name, years, albums, performances);
    }

    @Override
    public long calculateSalary() {
        return 3_000_000L
                + 500_000L * getYearsOfExperience()
                + 1_000L * getAlbumsSold()
                + 200_000L * getPerformances();
    }
}

class FamousSinger extends Singer {
    private long gameShowsAttended;

    public FamousSinger(String name, int years, long albums,
                        long performances, long gameShows) {
        super(name, years, albums, performances);
        setGameShowsAttended(gameShows);
    }

    public long getGameShowsAttended() {
        return gameShowsAttended;
    }

    public void setGameShowsAttended(long gameShows) {
        if (gameShows < 0) {
            throw new IllegalArgumentException(
                "Game shows cannot be negative.");
        }
        this.gameShowsAttended = gameShows;
    }

    @Override
    public long calculateSalary() {
        return 5_000_000L
                + 500_000L * getYearsOfExperience()
                + 1_200L * getAlbumsSold()
                + 500_000L * getPerformances()
                + 500_000L * gameShowsAttended;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Game shows attended: " + gameShowsAttended);
    }
}

public class Exercise_4 {

    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println("Value must be non-negative.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static long readLong(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                long value = Long.parseLong(sc.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println("Value must be non-negative.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static String readName(Scanner sc) {
        while (true) {
            System.out.print("Full name: ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Name cannot be empty.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Singer> singers = new ArrayList<>();

        int n = readInt(sc, "Number of singers: ");

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Singer " + (i + 1) + " ---");
            System.out.println("1. Regular Singer");
            System.out.println("2. Famous Singer");

            int type;
            do {
                type = readInt(sc, "Choose singer type (1 or 2): ");
                if (type != 1 && type != 2) {
                    System.out.println("Please choose 1 or 2.");
                }
            } while (type != 1 && type != 2);

            String name = readName(sc);
            int years = readInt(sc, "Years of experience: ");
            long albums = readLong(sc, "Number of albums sold: ");
            long performances =
                    readLong(sc, "Number of performances: ");

            if (type == 1) {
                singers.add(new RegularSinger(
                        name, years, albums, performances));
            } else {
                long gameShows =
                        readLong(sc, "Number of game shows attended: ");

                singers.add(new FamousSinger(
                        name, years, albums, performances, gameShows));
            }
        }

        System.out.println("\n========== SINGER LIST ==========");

        for (Singer singer : singers) {
            System.out.println("------------------------------");
            singer.displayInfo();
        }

        if (!singers.isEmpty()) {
            Singer highestPaid = singers.get(0);

            for (Singer singer : singers) {
                if (singer.calculateSalary()
                        > highestPaid.calculateSalary()) {
                    highestPaid = singer;
                }
            }

            System.out.println("\n========== HIGHEST-PAID SINGER ==========");
            highestPaid.displayInfo();
        } else {
            System.out.println("\nNo singers were entered.");
        }

        sc.close();
    }
}
