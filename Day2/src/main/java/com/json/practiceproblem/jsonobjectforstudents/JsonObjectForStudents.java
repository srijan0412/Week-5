package com.json.practiceproblem.jsonobjectforstudents;

import org.json.JSONObject;
import org.json.JSONArray;

public class JsonObjectForStudents {
    public static void main(String[] args) {
        //Initializing the jsonObject
        JSONObject jsonObject = new JSONObject();

        // Defining Json array
        JSONArray subjects = new JSONArray();
        subjects.put("Physics");
        subjects.put("Chemistry");
        subjects.put("Maths");

        // Adding Student details to the object
        jsonObject.put("Name", "Srijan");
        jsonObject.put("Age", "22");
        jsonObject.put("Subjects", subjects);

        // Displaying the result
        System.out.println(jsonObject.toString());
    }
}
