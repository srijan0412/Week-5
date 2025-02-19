package com.json.practiceproblem.javaobjecttojson;

import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    private int rollNumber;
    private String name;
    private int age;

    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
}

public class JavaObjectToJson {
    public static void main(String[] args) {
        try {
            // Initializing the ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            //Object that needs to be converted
            Student student = new Student(21, "Srijan Soni", 22);

            //Converting Java Object into Json String format
            String jsonString = objectMapper.writeValueAsString(student);

            // Output
            System.out.println(jsonString);
        }

        catch (Exception e) {
            System.out.println("Error while working with Object mapper");
        }
    }
}
