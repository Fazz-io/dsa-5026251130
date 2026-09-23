package Lw01.Prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        List<PrintJob> jobs = new ArrayList<>();
 
        try (Scanner scanner = new Scanner(new File("C:\\Users\\faza\\OneDrive\\Dokumen\\ASD\\dsa-5026251130\\src\\Lw01\\Prelab\\jobs.txt"))) {
            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();
 
                if (type.equals("MONO")) {
                    jobs.add(new Monoprint(id, pages));
                } else if (type.equals("COLOUR")) {
                    jobs.add(new Colourprint(id, pages));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File jobs.txt not found.");
            return;
        }
 
        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}
