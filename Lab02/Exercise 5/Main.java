import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rolls: ");
        int n = input.nextInt();

        Dice dice = new Dice();

        int[] frequency = new int[6];

        for (int i = 0; i < n; i++) {
            int result = dice.roll();

            frequency[result - 1]++;
        }

        System.out.println("\nResults:");

        for (int i = 0; i < 6; i++) {
            double probability = (double) frequency[i] / n;

            System.out.println(
                "Face " + (i + 1)
                + ": " + frequency[i]
                + " times, Probability: " + probability
            );
        }

        input.close();
    }
}