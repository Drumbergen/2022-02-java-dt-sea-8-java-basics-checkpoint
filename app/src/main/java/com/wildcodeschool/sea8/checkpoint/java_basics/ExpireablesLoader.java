package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class ExpireablesLoader {
    /**
     * Load entries from a CSV file that can contain certificates and dairy
     * products.
     * 
     * Entries can look like so:
     * Certificate,SEA 8 Checkpoint,WCS,2022-06-18
     * DairyProduct,2022-03-15,7
     * 
     * For certificates the date provided is the expiration date,
     * for dairy products it is the date produced followed by the days it is fresh.
     * 
     * @param file The file to load from.
     * @return ExpireablesDatabase containing entries from the file
     */
    public static ExpireablesDatabase<IExpireable> loadExpireablesFromFile(File file) {
        ExpireablesDatabase<IExpireable> database = null;

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            database = new ExpireablesDatabase<>();

            for (String line : lines) {
                // TODO: split the line at the right symbol instead of ""
                String[] lineEntries = line.split(","); // Andi

                if(lineEntries.length == 0) continue;
                if(lineEntries[0].equalsIgnoreCase("Certificate")) {
                    // TODO: load the certificate and add it to the database
                    // array lineEntries might look like this:
                    // ["Certificate", "SEA 8 Checkpoint", "WCS", "2022-06-18"]
                    Certificate certificate = new Certificate(lineEntries[1], lineEntries[2], LocalDate.parse(lineEntries[3]));
                    database.addItem(certificate);
                    // Andi fertig
                } else if (lineEntries[0].equalsIgnoreCase("DairyProduct")) {
                    // TODO: load the dairy product and add it to the database
                    // array lineEntries might look like this:
                    // ["DairyProduct", "2022-03-15", "7"]
                    DairyProduct dp = new DairyProduct(LocalDate.parse(lineEntries[1]), Integer.parseInt(lineEntries[2]));
                    database.addItem(dp);
                    // Andi fertig
                }
            }
        } catch (IOException e) {
            System.err.println("Could not load file " + file.getPath());
        }
        
        return database;
    }
}
