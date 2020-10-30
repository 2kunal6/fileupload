package de.unibonn.services;

import de.unibonn.entities.ParkingLotVehicle;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ParkingLotService {
    private long maximumCapacity;
    private long currentCapacity=0;
    private HashMap<String, ParkingLotVehicle> parkingLotVehicles = new HashMap<String, ParkingLotVehicle>();
    private HashMap<Object, Double> vehicleHourlyRates = new HashMap<Object, Double>();
    private HashMap<Object, Double> vehicleExtraTimeRates = new HashMap<Object, Double>();

    public HashMap<Object, Double> getVehicleExtraTimeRates() {
        return vehicleExtraTimeRates;
    }

    public void setVehicleExtraTimeRates(HashMap<Object, Double> vehicleExtraTimeRates) {
        this.vehicleExtraTimeRates = vehicleExtraTimeRates;
    }

    public HashMap<Object, Double> getVehicleHourlyRates() {
        return vehicleHourlyRates;
    }

    public void setVehicleHourlyRates(HashMap<Object, Double> vehicleHourlyRates) {
        this.vehicleHourlyRates = vehicleHourlyRates;
    }

    public ParkingLotService(long maximumCapacity, HashMap<Object, Double> vehicleHourlyRates, HashMap<Object, Double> vehicleExtraTimeRates) {
        this.maximumCapacity = maximumCapacity;
        this.vehicleHourlyRates = vehicleHourlyRates;
        this.vehicleExtraTimeRates = vehicleExtraTimeRates;
    }

    public String addVehicle(ParkingLotVehicle parkingLotVehicle) {
        if(currentCapacity == maximumCapacity) {
            return "FULL";
        }
        if(parkingLotVehicles.containsKey(parkingLotVehicle.getVehicle().getRegistration_number().toLowerCase())) {
            return "ALREADY PRESENT";
        }
        parkingLotVehicle.setInTime(LocalDateTime.now());
        parkingLotVehicles.put(parkingLotVehicle.getVehicle().getRegistration_number().toLowerCase(), parkingLotVehicle);
        currentCapacity++;
        return "PASS";
    }

    public boolean isPaymentComplete(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicle.isPaymentComplete();
    }

    public double getPayAmount(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicle.calculatePayment(LocalDateTime.now(), vehicleHourlyRates.get(parkingLotVehicle.getVehicle().getType()));
    }

    public void makePayment(ParkingLotVehicle parkingLotVehicle) {
        parkingLotVehicle.setPaymentComplete(true);
    }

    public String removeCar(ParkingLotVehicle parkingLotVehicle) {
        if(!parkingLotVehicles.containsKey(parkingLotVehicle.getVehicle().getRegistration_number().toLowerCase())) {
            return "NOT PRESENT";
        }
        if(!parkingLotVehicle.isPaymentComplete()) {
            return "PLEASE MAKE PAYMENT FIRST";
        }
        parkingLotVehicles.remove(parkingLotVehicle);
        return "PASS";
    }
}
