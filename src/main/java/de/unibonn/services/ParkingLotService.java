package de.unibonn.services;

import de.unibonn.entities.ParkingLotVehicle;

import java.time.LocalDateTime;
import java.util.Date;
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

    public boolean isEntryPossible() {
        return this.currentCapacity < this.maximumCapacity;
    }

    public boolean isAlreadyPresent(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicles.containsKey(parkingLotVehicle.getVehicle().getRegistration_number().toLowerCase());
    }

    public String addVehicle(ParkingLotVehicle parkingLotVehicle) {
        parkingLotVehicle.setInTime(new Date());
        parkingLotVehicles.put(parkingLotVehicle.getVehicle().getRegistration_number().toLowerCase(), parkingLotVehicle);
        this.currentCapacity++;
        return "PASS";
    }

    public String removeVehicle(ParkingLotVehicle parkingLotVehicle) {
        if(!parkingLotVehicle.isLeavePaymentComplete()) {
            return "PLEASE MAKE PAYMENT FIRST";
        }
        parkingLotVehicles.remove(parkingLotVehicle);
        return "PASS";
    }

    public boolean isVehiclePresent(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicles.containsKey(parkingLotVehicle.getVehicle().getRegistration_number().toLowerCase());
    }
    public boolean isEntryPaymentComplete(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicle.isEntryPaymentComplete();
    }

    public double getEntryPayAmount(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicle.calculateEntryPayment(new Date(), vehicleHourlyRates.get(parkingLotVehicle.getVehicle().getType()));
    }

    public void makeEntryPayment(ParkingLotVehicle parkingLotVehicle) {
        parkingLotVehicle.setEntryPaymentComplete(true);
    }

    public boolean isLeavePaymentComplete(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicle.isLeavePaymentComplete();
    }

    public double getLeavePayAmount(ParkingLotVehicle parkingLotVehicle) {
        return parkingLotVehicle.calculateLeavePayment(new Date(), vehicleHourlyRates.get(parkingLotVehicle.getVehicle().getType()),
                vehicleExtraTimeRates.get(parkingLotVehicle.getVehicle().getType()));
    }

    public void makeLeavePayment(ParkingLotVehicle parkingLotVehicle) {
        parkingLotVehicle.setLeavePaymentComplete(true);
    }
}
