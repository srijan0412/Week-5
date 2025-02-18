package com.csvdatahandling.intermediateproblems.sortcsvrecords;

import java.io.*;
import java.util.*;

class Employee {
    private String id;
    private String name;
    private int age;
    private int salary;

    public Employee(String id, String name, String age, String salary) {
        this.id = id;
        this.name = name;
        this.age = Integer.parseInt(age);
        this.salary = Integer.parseInt(salary);
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return (this.id+","+this.name+","+this.age+","+this.salary);
    }
}

// Comparator to sort the list of employees in decending order
class SortBySalary implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return b.getSalary() - a.getSalary();
    }
}

public class SortCSVRecords {
    public static void main(String[] args) {
        String path = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\sortcsvrecords\\SampleCSVFile.csv";
        String newPath = "S:\\Capgemini\\Week-5\\Day1\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\sortcsvrecords\\SortedCSVFile.csv";

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<Employee> employees = new ArrayList<>();

            //Converting CSV records to a List of objects
            String line;
            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");
                Employee employee = new Employee(col[0], col[1], col[2], col[3]);
                employees.add(employee);
            }
            br.close();

            // Sorting the list of objects on the base of Salary
            Collections.sort(employees, new SortBySalary());

            // Displaying Salary of the top 5 employees
            int k = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (k == 5) break;
                System.out.println(employees.get(i));
                k++;
            }

            // Writing to the new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(newPath));
            for (Employee employee : employees) {
                writer.write(employee.toString() + "\n");
            }
            System.out.println("Sorted data Successfully saved in the new file.");
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error while working with the file.");
        }
    }
}
