package com.json.handsonpracticeproblem.csvtojson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            // Create CSV Mapper and Schema (with auto-detection of columns)
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            // Read CSV File
            File csvFile = new File("S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\handsonpracticeproblem\\csvtojson\\SampleCSV.csv");
            MappingIterator<Object> iterator = csvMapper.readerFor(Object.class).with(schema).readValues(csvFile);

            // Convert to List of JSON Objects
            List<Object> list = iterator.readAll();

            // Convert List to JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

            // Print JSON Output
            System.out.println(json);

        } catch (Exception e) {
            System.out.println("Error during accessing file.");
        }
    }
}
