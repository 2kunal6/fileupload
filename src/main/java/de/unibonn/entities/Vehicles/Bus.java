package de.unibonn.entities.Vehicles;

import de.unibonn.entities.Vehicle;

public class Bus extends Vehicle {

    public Bus(Vehicle.vehicle_type type, String registration_number) {
        this.type = type;
        this.registration_number = registration_number;
    }
}
