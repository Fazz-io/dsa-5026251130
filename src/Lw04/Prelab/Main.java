package Lw04.Prelab;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        int[] branches;
        int[] targets;
 
        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("branches.txt"))) {
            int n = scanner.nextInt();
            branches = new int[n];
            for (int i = 0; i < n; i++) {
                branches[i] = scanner.nextInt();
            }
 
            int m = scanner.nextInt();
            targets = new int[m];
            for (int i = 0; i < m; i++) {
                targets[i] = scanner.nextInt();
            }
        }
 
        insertionSortDescending(branches, 3);
 
        for (int i = 0; i < branches.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(branches[i]);
        }
        System.out.println();
 
 for (int target : targets) {
     int index = linearSearch(branches, target);
     if (index != -1) {
     System.out.println(target + ": FOUND at index " + index);
     } else {
     System.out.println(target + ": NOT FOUND");
            }
        }
    }
 
    private static void insertionSortDescending(int[] a, int passes) {
        for (int i = 1; i <= passes; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
    private static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
