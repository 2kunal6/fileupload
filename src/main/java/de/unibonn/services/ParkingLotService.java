package de.unibonn.services;

import de.unibonn.entities.ParkingLotCar;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ParkingLotService {
    private long maximumCapacity;
    private long currentCapacity=0;
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
        parkingLotCar.setInTime(LocalDateTime.now());
        parkingLotCars.put(parkingLotCar.getCar().getRegistration_number().toLowerCase(), parkingLotCar);
        currentCapacity++;
        return "PASS";
    }
    public boolean isPaymentComplete(ParkingLotCar parkingLotCar) {
        return parkingLotCar.isPaymentComplete();
    }
    public double getPayAmount(ParkingLotCar parkingLotCar) {
        return parkingLotCar.calculatePayment(LocalDateTime.now());
    }
    public void makePayment(ParkingLotCar parkingLotCar) {
        parkingLotCar.setPaymentComplete(true);
    }
    public String removeCar(ParkingLotCar parkingLotCar) {
        if(!parkingLotCars.containsKey(parkingLotCar.getCar().getRegistration_number().toLowerCase())) {
            return "NOT PRESENT";
        }
        if(!parkingLotCar.isPaymentComplete()) {
            return "PLEASE MAKE PAYMENT FIRST";
        }
        parkingLotCars.remove(parkingLotCar);
        return "PASS";
    }
}
