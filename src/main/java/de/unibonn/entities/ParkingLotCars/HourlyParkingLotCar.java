package de.unibonn.entities.ParkingLotCars;

import de.unibonn.entities.Car;
import de.unibonn.entities.ParkingLotCar;
import de.unibonn.Util.TimeUtil;

import java.util.Date;

public class HourlyParkingLotCar extends ParkingLotCar {

    private double hourlyRate;

    public HourlyParkingLotCar(Car car, Date inTime, double hourlyRate) {
        this.car = car;
        this.inTime = inTime;
        this.outTIme = outTIme;
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculatePayment(Date inTime, Date outTime) {
        Long timeDifferenceInSeconds = getTimeDifferenceInSeconds(inTime, outTime);
        double timeDifferenceInHours = TimeUtil.convertSecondsToHours(timeDifferenceInSeconds);
        return timeDifferenceInHours * hourlyRate;
    }
}
