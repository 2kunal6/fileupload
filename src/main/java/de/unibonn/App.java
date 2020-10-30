package de.unibonn;

import de.unibonn.entities.Car;
import de.unibonn.entities.ParkingLotCar;
import de.unibonn.entities.ParkingLotCars.HourlyParkingLotCar;

import java.time.LocalDateTime;

public class App {
    public static void main( String[] args ) {
        Car car1 = new Car("i10", "TS00 0000");
        Car car2 = new Car("Swift", "TS01 1111");

        ParkingLotCar parkingLotCar1 = new HourlyParkingLotCar(car1, LocalDateTime.now(), 10.0);
    }
}
