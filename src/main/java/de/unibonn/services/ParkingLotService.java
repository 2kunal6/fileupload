package de.unibonn.services;

import de.unibonn.entities.ParkingLotCar;

import java.util.HashMap;

public class ParkingLotService {
    private long maximumCapacity;
    private long currentCapacity;
    private HashMap<String, ParkingLotCar> parkingLotCars = new HashMap<String, ParkingLotCar>();

    public ParkingLotService(long maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public String addCar(ParkingLotCar parkingLotCar) {
        if(currentCapacity == maximumCapacity) {
            return "FULL";
        }
        if(parkingLotCars.containsKey(parkingLotCar.getCar().getRegistration_number().toLowerCase())) {
            return "ALREADY PRESENT";
        }
        parkingLotCars.put(parkingLotCar.getCar().getRegistration_number().toLowerCase(), parkingLotCar);
        return "PASS";
    }
    public String removeCar(ParkingLotCar parkingLotCar) {
        if(!parkingLotCars.containsKey(parkingLotCar.getCar().getRegistration_number().toLowerCase())) {
            return "NOT PRESENT";
        }
        parkingLotCars.remove(parkingLotCar);
        return "PASS";
    }
}
