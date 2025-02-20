package com.json.iplandcensoranalyzer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class IplAndCensorAnalyzer {
    /** Read JSON File */
    public static List<Map<String, Object>> readJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), List.class);
    }

    /** Write JSON File */
    public static void writeJson(List<Map<String, Object>> data, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
    }

    /** Read CSV File */
    public static List<Map<String, String>> readCsv(String filePath) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class).with(schema).readValues(new File(filePath));
        return it.readAll();
    }

    /** Write CSV File */
    public static void writeCsv(List<Map<String, String>> data, String filePath) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.builder().addColumns(data.get(0).keySet(), CsvSchema.ColumnType.STRING).build().withHeader();
        mapper.writer(schema).writeValue(new File(filePath), data);
    }

    /** Apply Censorship Rules to JSON */
    public static List<Map<String, Object>> applyCensorship(List<Map<String, Object>> matches) {
        for (Map<String, Object> match : matches) {
            match.put("team1", censorTeamName((String) match.get("team1")));
            match.put("team2", censorTeamName((String) match.get("team2")));
            match.put("player_of_match", "REDACTED");

            // Censor team names inside score field
            if (match.containsKey("score")) {
                Map<String, Object> score = (Map<String, Object>) match.get("score");
                Map<String, Object> newScore = new LinkedHashMap<>();
                for (Map.Entry<String, Object> entry : score.entrySet()) {
                    newScore.put(censorTeamName(entry.getKey()), entry.getValue());
                }
                match.put("score", newScore);
            }
        }
        return matches;
    }

    /** Apply Censorship Rules to CSV */
    public static List<Map<String, String>> applyCensorshipCsv(List<Map<String, String>> matches) {
        for (Map<String, String> match : matches) {
            match.put("team1", censorTeamName(match.get("team1")));
            match.put("team2", censorTeamName(match.get("team2")));
            match.put("player_of_match", "REDACTED");
        }
        return matches;
    }

    /** Mask Team Names (e.g., "Mumbai Indians" → "Mumbai ***") */
    public static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***"; // Replace last word with "***"
        }
        return String.join(" ", words);
    }
    public static void main(String[] args) throws IOException {
        String jsonInputFile = "S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\iplandcensoranalyzer\\SampleIPLData.json";
        String csvInputFile = "S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\iplandcensoranalyzer\\SampleIPLData.csv";

        String jsonOutputFile = "S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\iplandcensoranalyzer\\censoredIPLData.json";
        String csvOutputFile = "S:\\Capgemini\\Week-5\\Day2\\src\\main\\java\\com\\json\\iplandcensoranalyzer\\censoredIPLData.csv";

        // Process JSON Data
        List<Map<String, Object>> jsonMatches = readJson(jsonInputFile);
        jsonMatches = applyCensorship(jsonMatches);
        writeJson(jsonMatches, jsonOutputFile);

        // Process CSV Data
        List<Map<String, String>> csvMatches = readCsv(csvInputFile);
        csvMatches = applyCensorshipCsv(csvMatches);
        writeCsv(csvMatches, csvOutputFile);

        System.out.println("Censorship applied and files saved successfully!");
    }
}
