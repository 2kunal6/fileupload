package de.unibonn.entities;

public class Vendor {
    private String id;
    private String templateName;
    private String csvDataFileName;

    public String getCsvDataFileName() {
        return csvDataFileName;
    }

    public void setCsvDataFileName(String csvDataFileName) {
        this.csvDataFileName = csvDataFileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
