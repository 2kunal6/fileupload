package de.unibonn.entities;

import java.util.Date;

public abstract class ParkingLotVehicle {
    protected Vehicle vehicle;
    protected Date inTime;
    protected Date outTIme;
    private boolean isPaymentComplete = false;

    public boolean isPaymentComplete() {
        return isPaymentComplete;
    }

    public void setPaymentComplete(boolean paymentComplete) {
        isPaymentComplete = paymentComplete;
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

    public abstract double calculatePayment(Date outTime, Double hourlyRate);
}
