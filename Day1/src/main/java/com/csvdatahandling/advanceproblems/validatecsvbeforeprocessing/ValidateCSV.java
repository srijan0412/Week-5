package com.csvdatahandling.advanceproblems.validatecsvbeforeprocessing;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV {
    // Method to validate a Email
    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; //Regex to validate email

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) return true;
        return false;
    }

    // Method to validate a phone number
    public static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^\\+?[1-9]\\d{0,2}[-.\\s]?\\d{10}$"; //Regex to validate phone number

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) return true;
        return false;
    }
    public static void main(String[] args) {
        // Path of the CSV File
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\advanceproblems\\validatecsvbeforeprocessing\\SampleCSVFile.csv";

        // Using bufferedReader to read the file
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine(); //Skiping the first line (header line)
            while((line = br.readLine()) != null) {
                String col[] = line.split(",");
                if (!validateEmail(col[3])) {
                    System.out.println("Id: " + col[0] + " Name: " + col[1] + " Invalid Email: " + col[3] );
                }
                if (!validatePhoneNumber(col[4])) {
                    System.out.println("Id: " + col[0] + " Name: " + col[1] + " Invalid Phone Number: " + col[4] );
                }
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error while working with the CSV file!");
        }
    }
}
