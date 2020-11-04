package de.unibonn.services.Vendor;

import de.unibonn.Util.MyFileReader;
import de.unibonn.entities.CSVfile;
import de.unibonn.entities.Vendor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.simple.JSONObject;

public class VendorService {
    private MyFileReader filereader;
    private CSVtoObjectConverter csvToObjectConverter;

    public void insertData(Vendor vendor) {
        //Ideally these should be autowired using Spring
        filereader = new MyFileReader();
        csvToObjectConverter = new CSVtoObjectConverter();

        List<List<String>> csvData = filereader.readFile(vendor.getCsvDataFileName());
        JSONObject jsonObject = filereader.readJSON(vendor.getTemplateName());

        HashMap<String, String> mappings = new Gson().fromJson(jsonObject.get("mappings").toString(), HashMap.class);
        List<CSVfile> csVfileList = csvToObjectConverter.convert(csvData, mappings);

    }
}
