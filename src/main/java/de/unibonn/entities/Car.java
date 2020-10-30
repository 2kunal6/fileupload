package de.unibonn.entities;

// TODO: Convert it to vehicle and set type as car, bus, truck etc.
public class Car {
    private String model;
    private String registration_number;

    public Car(String model, String registration_number) {
        this.model = model;
        this.registration_number = registration_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public boolean equals(Car other) {
        return this.registration_number.toLowerCase().equals(other.getRegistration_number().toLowerCase());
    }
}
