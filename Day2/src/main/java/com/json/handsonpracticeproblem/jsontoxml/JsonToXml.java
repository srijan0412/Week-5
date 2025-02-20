package com.json.handsonpracticeproblem.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            // Read JSON file
            JsonNode jsonNode = jsonMapper.readTree(new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\handsonpracticeproblem\\jsontoxml\\Data.json"));

            // Convert JSON to XML
            String xml = xmlMapper.writeValueAsString(jsonNode);

            // Print XML Output
            System.out.println(xml);

        } catch (Exception e) {
            System.out.println("Error while acceesing the json file.");
        }
    }
}
