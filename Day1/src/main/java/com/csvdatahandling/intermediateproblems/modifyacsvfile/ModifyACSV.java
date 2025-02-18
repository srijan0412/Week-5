package com.csvdatahandling.intermediateproblems.modifyacsvfile;

import java.io.*;

public class ModifyACSV {
    public static void main(String[] args) {
        // Path where csv file exists
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\modifyacsvfile\\SampleCSVFile.csv";
        String outputPath = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\modifyacsvfile\\newSampleCSVFile.csv";

        //Setting the increment percentage
        int incrementPercentage = 10; // 10% increment

        // Reading the file with BufferedReader
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            String line = br.readLine(); // Reading the first line (header row)
            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");
                int salary = Integer.parseInt(col[3]);
                salary += (salary * incrementPercentage) / 100;
                writer.write(col[0] + "," + col[1] + "," + col[2] + "," + salary + "\n");
            }
            System.out.println("File Modified Successfully.");
            writer.close();
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error in accessing the CSV file!");
        }
    }
}
