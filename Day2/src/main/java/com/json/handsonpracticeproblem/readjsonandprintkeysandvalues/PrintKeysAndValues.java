package com.json.handsonpracticeproblem.readjsonandprintkeysandvalues;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class PrintKeysAndValues {
    // Recursive function to print keys and values
    private static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), parentKey.isEmpty() ? entry.getKey() : parentKey + "." + entry.getKey());
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), parentKey + "[" + i + "]");
            }
        } else {
            System.out.println(parentKey + " : " + node.asText());
        }
    }
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\handsonpracticeproblem\\readjsonandprintkeysandvalues\\Sample.json"));
            printJson(jsonNode, "");
        }
        catch (IOException e) {
            System.out.println("Error while accessing the file!");
        }

    }
}
