package com.csvdatahandling.basicproblems.readandcountrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class ReadAndCountRows {
    public static void main(String[] args) {
        // Path where csv file exists
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\readandcountrows\\SampleCSVFile";

        // Count variable to keep the count of rows
        int count = 0;

        // Reading the file with BufferedReader
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                count++; // Incrementing the counter for each line in the csv file
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error in accessing the file.");
        }

        // Output
        System.out.println("The CSV file contains " + (count-1) + " Records.");
    }
}
