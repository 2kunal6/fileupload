package de.unibonn.entities.Vehicles;

import de.unibonn.entities.Vehicle;

public class Car extends Vehicle {
    public Car(Vehicle.vehicle_type type, String registration_number) {
        this.type = type;
        this.registration_number = registration_number;
    }
}
