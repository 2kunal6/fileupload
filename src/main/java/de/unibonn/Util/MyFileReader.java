package de.unibonn.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyFileReader {
    public List<List<String>> readFile(String filePath) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add((Arrays.asList(values)).stream().map(String::trim).collect(Collectors.toList()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
    public JSONObject readJSON(String filePath) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(new File(filePath))) {
            /*String line;
            BufferedReader breader = new BufferedReader(reader);
            while((line = breader.readLine()) != null) {
                System.out.println(line);
            }*/
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            return ((JSONObject)obj);
            //JSONArray jsonArray = (JSONArray) obj;
            //System.out.println(((JSONObject)obj).get("mappings"));
            //return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
