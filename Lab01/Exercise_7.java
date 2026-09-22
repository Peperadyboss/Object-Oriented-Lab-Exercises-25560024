import java.util.Scanner;

public class Exercise_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements in first array: ");
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter number of elements in second array: ");
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter " + m + " sorted integers:");
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n) {
            merged[k++] = arr1[i++];
        }

        while (j < m) {
            merged[k++] = arr2[j++];
        }

        System.out.println("Merged sorted array:");
        for (int num : merged) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
