package de.unibonn.entities;

import java.util.Date;

public abstract class ParkingLotCar {
    protected Car car;
    protected Date inTime;
    protected Date outTIme;

    public ParkingLotCar(Car car, Date inTime) {
        this.car = car;
        this.inTime = inTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public abstract double calculatePayment(Date inTime, Date outTime);
}
