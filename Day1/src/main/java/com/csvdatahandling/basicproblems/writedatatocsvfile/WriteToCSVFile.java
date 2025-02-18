package com.csvdatahandling.basicproblems.writedatatocsvfile;

import java.io.*;

public class WriteToCSVFile {
    public static void main(String[] args) {
        // Path where data is to be written
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\writedatatocsvfile\\SampleCSVFile.csv";

        // Writing in a CSV File with BufferedWriter and File Writer
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write("Id,Name,Age,Marks");
            writer.write("01,Srijan,22,95\n");
            writer.write("02,Yash,21,78\n");
            writer.write("03,Sonu,23,82\n");

            System.out.println("Data Successfully written to the file.");
            writer.close(); //closing the file writer object
        }
        catch (Exception e) {
            System.out.println("Error in opening file!");
        }
    }
}
