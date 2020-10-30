package de.unibonn.entities;

// TODO: Convert it to vehicle and set type as car, bus, truck etc.
public abstract class Vehicle {
    public enum vehicle_type {
        CAR, BUS, TRUCK;
    }
    protected vehicle_type type;
    protected String registration_number;

    public vehicle_type getType() {
        return type;
    }

    public void setType(vehicle_type type) {
        this.type = type;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public boolean equals(Vehicle other) {
        return this.registration_number.toLowerCase().equals(other.getRegistration_number().toLowerCase());
    }
}
