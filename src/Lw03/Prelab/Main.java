package Lw03.Prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
    }

    private static void problem1() {
        List<String> playlist = new ArrayList<>();

        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("ADD ")) {
                    String song = line.substring(4);
                    playlist.add(song);
                } else if (line.startsWith("INSERT ")) {
                    String rest = line.substring(7);
                    int spaceIndex = rest.indexOf(' ');
                    int index = Integer.parseInt(rest.substring(0, spaceIndex));
                    String song = rest.substring(spaceIndex + 1);
                    playlist.add(index, song);
                } else if (line.startsWith("REMOVE ")) {
                    String song = line.substring(7);
                    playlist.remove(song);
                }
            }
        }

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println();
    }

    private static void problem2() {
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;

        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("participants.txt"))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    continue;
                }

                if (participants.contains(name)) {
                    duplicates++;
                } else {
                    participants.add(name);
                }
            }
        }

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int number = 1;
        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }
        System.out.println("Duplicate registrations: " + duplicates);
        System.out.println();
    }

    private static void problem3() {
        Map<String, Integer> stock = new LinkedHashMap<>();
        int failedSales = 0;

        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"))) {
            while (scanner.hasNext()) {
                String type = scanner.next();
                String product = scanner.next();
                int quantity = scanner.nextInt();

                if (type.equals("ADD")) {
                    if (stock.containsKey(product)) {
                        stock.put(product, stock.get(product) + quantity);
                    } else {
                        stock.put(product, quantity);
                    }
                } else if (type.equals("SELL")) {
                    if (stock.containsKey(product) && stock.get(product) >= quantity) {
                        stock.put(product, stock.get(product) - quantity);
                    } else {
                        failedSales++;
                    }
                }
            }
        }

        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}
