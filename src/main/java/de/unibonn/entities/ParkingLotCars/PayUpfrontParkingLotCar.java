package de.unibonn.entities.ParkingLotCars;

import de.unibonn.Util.TimeUtil;
import de.unibonn.entities.ParkingLotCar;

import java.util.Date;

public class PayUpfrontParkingLotCar extends ParkingLotCar {

    private double hourlyRate;
    //maximum allowed time in seconds
    private Long maximumAllowedTime;
    private double extraTimeRate;

    public Long getMaximumAllowedTime() {
        return maximumAllowedTime;
    }

    public void setMaximumAllowedTime(Long maximumAllowedTime) {
        this.maximumAllowedTime = maximumAllowedTime;
    }

    public double getExtraTimeRate() {
        return extraTimeRate;
    }

    public void setExtraTimeRate(double extraTimeRate) {
        this.extraTimeRate = extraTimeRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculatePayment(Date inTime, Date outTime) {
        Long timeDifferenceInSeconds = getTimeDifferenceInSeconds(inTime, outTime);
        Long extraTimeInSeconds = timeDifferenceInSeconds - maximumAllowedTime;
        if(extraTimeInSeconds > 0) {
            double extraTimeInhours = TimeUtil.convertSecondsToHours(extraTimeInSeconds);
            return extraTimeInhours * extraTimeRate;
        }
        return 0.0;
    }
}
