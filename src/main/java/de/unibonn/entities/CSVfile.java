package de.unibonn.entities;

import java.util.Date;

public class CSVfile {
    private String name;
    private String emailId;
    private Date dob;

    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setEmailId(String emailId) {
        this.emailId=emailId;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setDOB(Date dob) {
        this.dob=dob;
    }
    public Date getDOB() {
        return dob;
    }

    public String toString() {
        return "name:" + name + ", emailId:" + emailId + ", dob:" + dob;
    }
}
