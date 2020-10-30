package de.unibonn.entities.ParkingLotVehicles;

import de.unibonn.Util.TimeUtil;
import de.unibonn.entities.ParkingLotVehicle;

import java.util.Date;

public class PayUpfrontParkingLotVehicle extends ParkingLotVehicle {

    //maximum allowed time in seconds
    private Long maximumAllowedTime;

    public Long getMaximumAllowedTime() {
        return maximumAllowedTime;
    }

    public void setMaximumAllowedTime(Long maximumAllowedTime) {
        this.maximumAllowedTime = maximumAllowedTime;
    }

    public double calculatePayment(Date outTime, Double extraTimeRate) {
        Long timeDifferenceInSeconds = getTimeDifferenceInSeconds(inTime, outTime);
        Long extraTimeInSeconds = timeDifferenceInSeconds - maximumAllowedTime;
        if(extraTimeInSeconds > 0) {
            double extraTimeInhours = TimeUtil.convertSecondsToHours(extraTimeInSeconds);
            return extraTimeInhours * extraTimeRate;
        }
        return 0.0;
    }
}
