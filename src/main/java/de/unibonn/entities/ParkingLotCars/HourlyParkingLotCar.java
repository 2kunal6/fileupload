package de.unibonn.entities.ParkingLotCars;

import de.unibonn.entities.Car;
import de.unibonn.entities.ParkingLotCar;
import de.unibonn.Util.TimeUtil;

import java.util.Date;

public class HourlyParkingLotCar extends ParkingLotCar {

    private double hourlyRate;

    public HourlyParkingLotCar(Car car, double hourlyRate) {
        this.car = car;
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculatePayment(Date outTime) {
        this.outTIme = outTime;
        Long timeDifferenceInSeconds = getTimeDifferenceInSeconds(inTime, outTime);
        double timeDifferenceInHours = TimeUtil.convertSecondsToHours(timeDifferenceInSeconds);
        return timeDifferenceInHours * hourlyRate;
    }
}
