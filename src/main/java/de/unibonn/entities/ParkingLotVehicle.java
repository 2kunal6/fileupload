package de.unibonn.entities;

import java.util.Date;

// TODO: Change the payment methods to not pass unused parameters (Ex. ExtraTimeRate is not used in HourlyParkingLotVehicle)
public abstract class ParkingLotVehicle {
    protected Vehicle vehicle;
    protected Date inTime;
    protected Date outTIme;
    private boolean isEntryPaymentComplete = false;
    private boolean isLeavePaymentComplete = false;

    public boolean isEntryPaymentComplete() {
        return isEntryPaymentComplete;
    }

    public void setEntryPaymentComplete(boolean entryPaymentComplete) {
        isEntryPaymentComplete = entryPaymentComplete;
    }

    public boolean isLeavePaymentComplete() {
        return isLeavePaymentComplete;
    }

    public void setLeavePaymentComplete(boolean leavePaymentComplete) {
        isLeavePaymentComplete = leavePaymentComplete;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTIme() {
        return outTIme;
    }

    public void setOutTIme(Date outTIme) {
        this.outTIme = outTIme;
    }

    public Long getTimeDifferenceInSeconds(Date inTime, Date outTime) {
        return (inTime.getTime() - outTime.getTime())/1000;
    }

    // To calculate the amount that needs to be payed before entering the parking lot
    public abstract double calculateEntryPayment(Date outTime, Double hourlyRate);

    // To calculate the amount that needs to be payed before leaving the parking lot
    public abstract double calculateLeavePayment(Date outTime, Double hourlyRate, Double extraRate);
}
