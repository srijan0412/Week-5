package com.json.handsonpracticeproblem.mergetwojsonobject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Defining two sample Json Object Strings
            String json1 = "{\"name\":\"Srijan\",\"age\":\"22\"}";
            JsonNode jsonNode1 = objectMapper.readTree(json1);

            String json2 = "{\"email\":\"srijan.soni02@gmail.com\",\"city\":\"Bhopal\"}";
            JsonNode jsonNode2 = objectMapper.readTree(json2);

            // Merging two Objects
            ObjectNode objectNode = objectMapper.createObjectNode();
            objectNode.setAll((ObjectNode) jsonNode1);
            objectNode.setAll((ObjectNode) jsonNode2);

            // Display output
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
        }
        catch(Exception e) {
            System.out.println("Error while working with Object Mapper!");
        }

    }
}
