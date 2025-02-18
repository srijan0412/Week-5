package com.csvdatahandling.advanceproblems.csvtoobject;

import java.io.*;
import java.util.*;
import java.io.FileReader;

class Student {

    private int id;
    private String name;
    private String email;
    private double grade;

    public Student(int id, String name, String email, double grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', grade=" + grade + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class CSVToJavaObject {
    public static List<Student> convertCSVToStudents(String filePath) {
        List<Student> students = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                double grade = Double.parseDouble(data[3]);

                students.add(new Student(id, name, email, grade));
            }
        } catch (Exception e) {
            System.out.println("Error occured while working with file!");
        }

        return students;
    }
    public static void main(String[] args) {
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\advanceproblems\\csvtoobject\\SampleCSVFile.csv";
        List<Student> students = convertCSVToStudents(path);
        students.forEach(System.out::println);
    }
}
