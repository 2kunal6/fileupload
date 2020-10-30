package de.unibonn.entities.ParkingLotVehicles;

import de.unibonn.entities.Vehicle;
import de.unibonn.entities.ParkingLotVehicle;
import de.unibonn.Util.TimeUtil;

import java.util.Date;

public class HourlyParkingLotVehicle extends ParkingLotVehicle {

    public HourlyParkingLotVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double calculateEntryPayment(Date outTime, Double hourlyRate) {
        return 0.0; //While entering hourly type vehicles don't need to pay anything in advance
    }

    public double calculateLeavePayment(Date outTime, Double hourlyRate, Double extraRate) {
        this.outTIme = outTime;
        Long timeDifferenceInSeconds = getTimeDifferenceInSeconds(inTime, outTime);
        double timeDifferenceInHours = TimeUtil.convertSecondsToHours(timeDifferenceInSeconds);
        return timeDifferenceInHours * hourlyRate;
    }
}
