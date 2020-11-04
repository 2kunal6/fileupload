package de.unibonn.services.Vendor;

import de.unibonn.entities.CSVfile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CSVtoObjectConverter {
    public List<CSVfile> convert(List<List<String>> csvData, Map<String, String> userDBcolumnNameMapping) {
        List<CSVfile> csvFiles = new ArrayList<CSVfile>();
        List<String> myColumnNames = new ArrayList<String>();

        for(String col : csvData.get(0)) {
            myColumnNames.add(userDBcolumnNameMapping.get(col));
        }
        for(int i=1;i<csvData.size();i++) {
            CSVfile csvFile = new CSVfile();
            for(int j=0;j<csvData.get(i).size();j++) {
                if(myColumnNames.get(j).equals("name"))csvFile.setName(csvData.get(i).get(j));
                else if(myColumnNames.get(j).equals("emailId"))csvFile.setEmailId(csvData.get(i).get(j));
                //have robust processing of date based on template
                else if(myColumnNames.get(j).equals("dob"))csvFile.setDOB(new Date(csvData.get(i).get(j)));
            }
            csvFiles.add(csvFile);
        }
        return csvFiles;
    }
}
