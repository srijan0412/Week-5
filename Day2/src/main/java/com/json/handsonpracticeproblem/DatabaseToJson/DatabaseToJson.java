package com.json.handsonpracticeproblem.DatabaseToJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

public class DatabaseToJson {
    public static void main(String[] args) {
        // Database Credentials
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "your_password";

        // Query to fetch data
        String query = "SELECT id, name, email, age FROM users"; // Change table name

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            List<Map<String, Object>> records = new ArrayList<>();

            // Process ResultSet
            while (rs.next()) {
                Map<String, Object> record = new HashMap<>();
                record.put("id", rs.getInt("id"));
                record.put("name", rs.getString("name"));
                record.put("email", rs.getString("email"));
                record.put("age", rs.getInt("age"));
                records.add(record);
            }

            // Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

            // Save JSON to File
            objectMapper.writeValue(new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\handsonpracticeproblem\\DatabaseToJson\\report.json"), records);

            // Print JSON Output
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
