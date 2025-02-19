package com.json.handsonpracticeproblem.validateemailfield;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import java.io.File;

public class EmailValidator {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON schema
            JsonNode schemaNode = objectMapper.readTree(new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\handsonpracticeproblem\\validateemailfield\\schema.json"));
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema jsonSchema = schemaFactory.getJsonSchema(schemaNode);

            // Load JSON data
            JsonNode jsonData = objectMapper.readTree(new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\handsonpracticeproblem\\validateemailfield\\data.json"));

            // Validate JSON
            ProcessingReport report = jsonSchema.validate(jsonData);

            // Print validation result
            if (report.isSuccess()) {
                System.out.println("Valid JSON!");
            } else {
                System.out.println("Invalid JSON:");
                report.forEach(msg -> System.out.println(msg));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
