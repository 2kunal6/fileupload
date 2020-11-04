package de.unibonn.dao;

import de.unibonn.entities.CSVfile;

import java.util.List;

public class EmployeeDao {
    public void insertData(List<CSVfile> csVfileList) {
            for (CSVfile csv : csVfileList) {
                System.out.println("Inserting to DB : " + csv.toString());
            }
    }
}
