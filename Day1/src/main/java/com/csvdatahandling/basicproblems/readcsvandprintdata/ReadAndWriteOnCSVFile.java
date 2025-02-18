package com.csvdatahandling.basicproblems.readcsvandprintdata;

import java.io.*;

public class ReadAndWriteOnCSVFile {
    public static void main(String[] args) {
        // Path of the csv file
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\readcsvandprintdata\\SampleCSVFile.csv";

        // Reading CSV File with BufferedReader and File Reader
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String col[] = line.split(","); // breaking the line on the bases of comma
                System.out.println("Id: " + col[0] + " Name: " + col[1] + " Age: " + col[2] + " Marks: " + col[3]);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Exception in Reading the file");
        }
    }
}
