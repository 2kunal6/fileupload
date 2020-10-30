package de.unibonn;

import de.unibonn.entities.Car;
import de.unibonn.entities.ParkingLotCar;
import de.unibonn.entities.ParkingLotCars.HourlyParkingLotCar;
import de.unibonn.services.ParkingLotService;

import java.time.LocalDateTime;

public class App {
    public static void main( String[] args ) {
        Car car1 = new Car("i10", "TS00 0000");
        Car car2 = new Car("Swift", "TS01 1111");

        ParkingLotCar parkingLotCar1 = new HourlyParkingLotCar(car1, 10.0);
        ParkingLotCar parkingLotCar2 = new HourlyParkingLotCar(car1, 10.0);

        ParkingLotService parkingLotService = new ParkingLotService(100);
        parkingLotService.addCar(parkingLotCar1);
        parkingLotService.addCar(parkingLotCar2);

        if(parkingLotService.isPaymentComplete(parkingLotCar1.getCar().getRegistration_number())) {
            parkingLotService.removeCar(parkingLotCar1);
        } else {
            double amountToPay = parkingLotService.getPayAmount(parkingLotCar1);
            //if user made payment
            parkingLotCar1.setPaymentComplete(true);
            parkingLotService.removeCar(parkingLotCar1);
        }
    }
}
