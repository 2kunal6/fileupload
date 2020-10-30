package de.unibonn;

import de.unibonn.entities.Vehicle;
import de.unibonn.entities.ParkingLotVehicle;
import de.unibonn.entities.ParkingLotVehicles.HourlyParkingLotVehicle;
import de.unibonn.entities.Vehicles.Bus;
import de.unibonn.entities.Vehicles.Car;
import de.unibonn.services.ParkingLotService;

import java.util.HashMap;

public class App {
    public static void main( String[] args ) {
        Vehicle car = new Car(Vehicle.vehicle_type.CAR, "TS00 0000");
        Vehicle bus = new Bus(Vehicle.vehicle_type.BUS, "TS01 1111");

        ParkingLotVehicle parkingLotVehicle1 = new HourlyParkingLotVehicle(car);
        ParkingLotVehicle parkingLotVehicle2 = new HourlyParkingLotVehicle(bus);

        ParkingLotService parkingLotService = new ParkingLotService(100, createVehicleHourlyRates(),createVehicleExtraTimeRates());
        parkingLotService.addVehicle(parkingLotVehicle1);
        parkingLotService.addVehicle(parkingLotVehicle2);

        if(parkingLotService.isPaymentComplete(parkingLotVehicle1)) {
            parkingLotService.removeCar(parkingLotVehicle1);
        } else {
            double amountToPay = parkingLotService.getPayAmount(parkingLotVehicle1);
            //if user made payment
            parkingLotVehicle1.setPaymentComplete(true);
            parkingLotService.removeCar(parkingLotVehicle1);
        }
    }
    public static HashMap<Object, Double> createVehicleHourlyRates() {
        //TODO: Change this to somehow enforce provide rates for all vehicles types in enum
        HashMap<Object, Double> vehicleHourlyRates = new HashMap<>();
        vehicleHourlyRates.put(Vehicle.vehicle_type.CAR, 10.0);
        vehicleHourlyRates.put(Vehicle.vehicle_type.BUS, 20.0);
        return vehicleHourlyRates;
    }
    public static HashMap<Object, Double> createVehicleExtraTimeRates() {
        //TODO: Change this to somehow enforce provide rates for all vehicles types in enum
        HashMap<Object, Double> vehicleExtraTimeRates = new HashMap<>();
        vehicleExtraTimeRates.put(Vehicle.vehicle_type.CAR, 15.0);
        vehicleExtraTimeRates.put(Vehicle.vehicle_type.BUS, 25.0);
        return vehicleExtraTimeRates;
    }
}
