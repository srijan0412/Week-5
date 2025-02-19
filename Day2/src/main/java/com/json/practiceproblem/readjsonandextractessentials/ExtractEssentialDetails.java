package com.json.practiceproblem.readjsonandextractessentials;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;

public class ExtractEssentialDetails {
    public static void main(String[] args) {
        try {
            // Initializing ObjectMapper Object
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\practiceproblem\\readjsonandextractessentials\\Student.json"));

            // Extracting Name and Email
            String name = jsonNode.path("name").asText();
            String email = jsonNode.path("email").asText();

            //Displaying the result
            System.out.println("name: " + name + " email: " + email);
        }
        catch (Exception e) {
            System.out.println("Exception while working with JSON file!");
        }

    }
}
