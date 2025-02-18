package com.csvdatahandling.intermediateproblems.searcharecord;

import java.io.BufferedReader;
import java.io.FileReader;


public class SearchRecord {
    public static void main(String[] args) {
        // Path where csv file exists
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\searcharecord\\SampleCSVFile.csv";

        // Key element to search
        String key = "Ria";

        // Reading the file with BufferedReader
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine(); // Reading the first line (header row)

            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");
                if (col[1].matches(key)) { //Checking if the name matches the search key
                    System.out.println("EmpId: " + col[0] + " EmpName: " + col[1] + " EmpAge: " + col[2]);
                    br.close();
                    return;
                }
            }
            System.out.println("Key Not Found!");
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error in accessing the CSV file!");
        }
    }
}
