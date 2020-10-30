package de.unibonn.entities.Vehicles;

import de.unibonn.entities.Vehicle;

public class Bus extends Vehicle {

    public Bus(Vehicle.vehicle_type model, String registration_number) {
        this.model = model;
        this.registration_number = registration_number;
    }
}
