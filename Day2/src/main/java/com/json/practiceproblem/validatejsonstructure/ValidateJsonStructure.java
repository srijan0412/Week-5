package com.json.practiceproblem.validatejsonstructure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJsonStructure {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\practiceproblem\\validatejsonstructure\\Sample.json");

        try {
            // Parsing JSON file to check if it's valid
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            System.out.println("Valid Json Structure:\n" + jsonNode.toPrettyString());
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
        }
        catch(IOException e) {
            System.out.println("Invalid Json: " + e.getMessage());
        }
    }
}
