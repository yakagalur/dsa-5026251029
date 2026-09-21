package lw01.prelab;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PrintJob> jobs = new ArrayList<>();

        InputStream input = Main.class.getResourceAsStream("jobs.txt");
        if (input == null) {
            System.err.println("File jobs.txt tidak ditemukan di resource package lw01.prelab.");
            return;
        }

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();
                
                PrintJob job;

                if (type.equals("Mono")) {
                    job = new MonoPrint(id, pages);
                } else {
                    job = new ColourPrint(id, pages);
                }

                jobs.add(job);
            }
            scanner.close();

        // Polimorfisme: Memanggil summary() melalui referensi superclass PrintJob
        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}