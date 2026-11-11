package Lw04.Unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] parcels;
        int[] targets;
 
        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("parcels.txt"))) {
            int n = scanner.nextInt();
            parcels = new int[n];
            for (int i = 0; i < n; i++) {
                parcels[i] = scanner.nextInt();
            }
 
            int m = scanner.nextInt();
            targets = new int[m];
            for (int i = 0; i < m; i++) {
                targets[i] = scanner.nextInt();
            }
        }
 
        int n = parcels.length;
        int[] afterTwoPasses = new int[n];
 
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (parcels[j] < parcels[j + 1]) {
                    int temp = parcels[j];
                    parcels[j] = parcels[j + 1];
                    parcels[j + 1] = temp;
                }
            }
 
            if (i == 1) {
                for (int k = 0; k < n; k++) {
                    afterTwoPasses[k] = parcels[k];
                }
            }
        }
 
        System.out.println("==== After 2 Passes ====");
        printArray(afterTwoPasses);
 
        System.out.println("==== Fully Sorted ====");
        printArray(parcels);
 
        System.out.println("==== Search Results ====");
        for (int target : targets) {
            int low = 0;
            int high = n - 1;
            int steps = 0;
            int foundIndex = -1;
 
            while (low <= high) {
                int mid = (low + high) / 2;
                steps++;
 
                if (parcels[mid] == target) {
                    foundIndex = mid;
                    break;
                } else if (parcels[mid] < target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
 
            if (foundIndex != -1) {
                System.out.println(target + ": FOUND at index " + foundIndex + " (steps: " + steps + ")");
            } else {
                System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }
 
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
        System.out.println();
    }
}