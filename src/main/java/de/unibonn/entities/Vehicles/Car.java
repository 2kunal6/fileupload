package de.unibonn.entities.Vehicles;

import de.unibonn.entities.Vehicle;

public class Car extends Vehicle {
    public Car(Vehicle.vehicle_type model, String registration_number) {
        this.model = model;
        this.registration_number = registration_number;
    }
}
