package com.csvdatahandling.advanceproblems.mergetwocsvfiles;

import java.util.*;
import java.io.*;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;
    private String grade;

    public Student(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }

    // Getters and setters (optional)
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class MergeTwoCSVFiles {
    public static Map<Integer, Student> readStudents1(String filePath) {
        Map<Integer, Student> studentsMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                Student student = new Student(id, name, age, 0, ""); // Set marks and grade as placeholders
                studentsMap.put(id, student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsMap;
    }

    public static void mergeAndWriteCSV(String filePath1, String filePath2, String outputFilePath) {
        Map<Integer, Student> studentsMap = readStudents1(filePath1);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int marks = Integer.parseInt(data[1]);
                String grade = data[2];

                if (studentsMap.containsKey(id)) {
                    Student student = studentsMap.get(id);
                    student.setMarks(marks);
                    student.setGrade(grade);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while working with the file");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Student student : studentsMap.values()) {
                bw.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error while working with the file");
        }
    }

    public static void main(String[] args) {
        String filePath1 = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\advanceproblems\\mergetwocsvfiles\\student1.csv";
        String filePath2 = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\advanceproblems\\mergetwocsvfiles\\student2.csv";
        String outputFilePath = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\advanceproblems\\mergetwocsvfiles\\outputfile.csv";

        mergeAndWriteCSV(filePath1, filePath2, outputFilePath);

        System.out.println("Merging completed! Merged file created at: " + outputFilePath);
    }
}
