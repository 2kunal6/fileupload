package de.unibonn.entities.ParkingLotVehicles;

import de.unibonn.entities.Vehicle;
import de.unibonn.entities.ParkingLotVehicle;
import de.unibonn.Util.TimeUtil;

import java.util.Date;

public class HourlyParkingLotVehicle extends ParkingLotVehicle {

    public HourlyParkingLotVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double calculatePayment(Date outTime, Double hourlyRate) {
        this.outTIme = outTime;
        Long timeDifferenceInSeconds = getTimeDifferenceInSeconds(inTime, outTime);
        double timeDifferenceInHours = TimeUtil.convertSecondsToHours(timeDifferenceInSeconds);
        return timeDifferenceInHours * hourlyRate;
    }
}
