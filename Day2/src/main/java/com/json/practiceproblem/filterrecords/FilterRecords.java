package com.json.practiceproblem.filterrecords;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        try {
            // Initializing the ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // List to save filetered nodes
            List<JsonNode> filteredNodes = new ArrayList<JsonNode>();

            // Read JSON file
            JsonNode rootNode = objectMapper.readTree(new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\practiceproblem\\filterrecords\\Records.json"));

            // Filtering Records
            if (rootNode.isArray()) {
                for (JsonNode jsonNode : rootNode) {
                    if (jsonNode.has("age") && jsonNode.get("age").asInt() > 25) {
                        filteredNodes.add(jsonNode);
                    }
                }
            }

            // Converting the list to json string
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredNodes));
        }
        catch (IOException e) {
            System.out.println("Error while Opening the json file");
        }

    }
}
