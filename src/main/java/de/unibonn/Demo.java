package de.unibonn;

import de.unibonn.entities.Vendor;
import de.unibonn.services.Vendor.VendorService;

public class Demo extends Thread {
    public void giveDemo() {
        VendorService vendorService = new VendorService();
        Vendor vendor1 = new Vendor();
        //use root file location from properties file
        vendor1.setTemplateName("/home/kunal/Documents/FileUpload/file-upload/resources/template_1.json");
        vendor1.setCsvDataFileName("/home/kunal/Documents/FileUpload/file-upload/resources/csvdata_1.csv");

        vendorService.insertData(vendor1);
    }

}