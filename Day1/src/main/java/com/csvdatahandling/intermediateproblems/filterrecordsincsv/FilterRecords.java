package com.csvdatahandling.intermediateproblems.filterrecordsincsv;

import java.io.*;

public class FilterRecords {
    public static void main(String[] args) {
        // Path where csv file exists
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\filterrecordsincsv\\SampleCSVFile.csv";

        // Reading the file with BufferedReader
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine(); // Reading the first line (header row)

            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");
                int marks = Integer.parseInt(col[3]);
                if (marks >= 80) { // Checking if the marks are greater the 80
                    System.out.println("Id: " + col[0] + " Name: " + col[1] + " Age: " + col[2] + " Marks: " + col[3]);
                }
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error in accessing the CSV file!");
        }
    }
}
