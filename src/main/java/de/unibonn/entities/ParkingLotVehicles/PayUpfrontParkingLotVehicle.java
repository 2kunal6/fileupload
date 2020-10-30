package de.unibonn.entities.ParkingLotVehicles;

import de.unibonn.Util.TimeUtil;
import de.unibonn.entities.ParkingLotVehicle;
import de.unibonn.entities.Vehicle;

import java.util.Date;

public class PayUpfrontParkingLotVehicle extends ParkingLotVehicle {

    //maximum allowed time in seconds
    private Long maximumAllowedTime;

    public PayUpfrontParkingLotVehicle(Vehicle vehicle, Long maximumAllowedTime) {
        this.vehicle = vehicle;
        this.maximumAllowedTime = maximumAllowedTime;
    }

    public Long getMaximumAllowedTime() {
        return maximumAllowedTime;
    }

    public void setMaximumAllowedTime(Long maximumAllowedTime) {
        this.maximumAllowedTime = maximumAllowedTime;
    }

    public double calculateEntryPayment(Date outTime, Double hourlyRate) {
        // Before entering they need to pay the amount for the maximum time they are booking
        return TimeUtil.convertSecondsToHours(maximumAllowedTime) * hourlyRate;
    }

    // If someone overshoots their maximum allowed time then they need to pay an hourly fine
    public double calculateLeavePayment(Date outTime, Double hourlyRate, Double extraTimeRate) {
        Long timeDifferenceInSeconds = getTimeDifferenceInSeconds(inTime, outTime);
        Long extraTimeInSeconds = timeDifferenceInSeconds - maximumAllowedTime;
        if(extraTimeInSeconds > 0) {
            double extraTimeInhours = TimeUtil.convertSecondsToHours(extraTimeInSeconds);
            return extraTimeInhours * extraTimeRate;
        }
        return 0.0;
    }
}
