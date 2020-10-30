package de.unibonn;

import de.unibonn.Util.TimeUtil;
import de.unibonn.entities.ParkingLotVehicle;
import de.unibonn.entities.ParkingLotVehicles.HourlyParkingLotVehicle;
import de.unibonn.entities.ParkingLotVehicles.PayUpfrontParkingLotVehicle;
import de.unibonn.entities.Vehicle;
import de.unibonn.entities.Vehicles.Bus;
import de.unibonn.entities.Vehicles.Car;
import de.unibonn.services.ParkingLotService;

import java.util.HashMap;

public class Demo extends Thread {
    public void giveDemo() {
        Vehicle car = new Car(Vehicle.vehicle_type.CAR, "TS00 0000");
        Vehicle bus = new Bus(Vehicle.vehicle_type.BUS, "TS01 1111");

        ParkingLotVehicle parkingLotVehicle1 = new HourlyParkingLotVehicle(car);
        ParkingLotVehicle parkingLotVehicle2 = new PayUpfrontParkingLotVehicle(bus, TimeUtil.convertHoursToSeconds(1.5));

        ParkingLotService parkingLotService = new ParkingLotService(100, createVehicleHourlyRates(), createVehicleExtraTimeRates());
        String result;
        result = parkingLotService.addVehicle(parkingLotVehicle1);
        System.out.println(result);
        parkingLotService.addVehicle(parkingLotVehicle2);

        parkingLotService.removeVehicle(parkingLotVehicle2);
        parkingLotService.removeVehicle(parkingLotVehicle1);
    }

    public String addVehicle(ParkingLotService parkingLotService, ParkingLotVehicle parkingLotVehicle) {
        if (!parkingLotService.isEntryPossible()) {
            return "PARKING LOT IS FULL";
        } else {
            // Making it synchronized so that only one thread can access
            synchronized (this) {
                double amountToPay = parkingLotService.getEntryPayAmount(parkingLotVehicle);
                parkingLotService.makeEntryPayment(parkingLotVehicle);

                // TODO: Change this to allow entry without payment. Collect total payment at the end
                if (parkingLotService.isEntryPaymentComplete(parkingLotVehicle)) {
                    parkingLotService.addVehicle(parkingLotVehicle);
                }
                return "SUCCESS";
            }
        }
    }

    public String removeVehicle(ParkingLotService parkingLotService, ParkingLotVehicle parkingLotVehicle) {
        if (!parkingLotService.isVehiclePresent(parkingLotVehicle)) {
            return "VEHICLE NOT PRESENT";
        } else {
            // Making it synchronized so that only one thread can access
            synchronized (this) {
                double amountToPay = parkingLotService.getLeavePayAmount(parkingLotVehicle);
                parkingLotService.makeLeavePayment(parkingLotVehicle);
                if (parkingLotService.isLeavePaymentComplete(parkingLotVehicle)) {
                    parkingLotService.removeVehicle(parkingLotVehicle);
                }
                return "SUCCESS";
            }
        }
    }

    public HashMap<Object, Double> createVehicleHourlyRates() {
        //TODO: Change this to somehow enforce provide rates for all vehicles types in enum
        HashMap<Object, Double> vehicleHourlyRates = new HashMap<>();
        vehicleHourlyRates.put(Vehicle.vehicle_type.CAR, 10.0);
        vehicleHourlyRates.put(Vehicle.vehicle_type.BUS, 20.0);
        return vehicleHourlyRates;
    }

    public HashMap<Object, Double> createVehicleExtraTimeRates() {
        //TODO: Change this to somehow enforce provide rates for all vehicles types in enum
        HashMap<Object, Double> vehicleExtraTimeRates = new HashMap<>();
        vehicleExtraTimeRates.put(Vehicle.vehicle_type.CAR, 15.0);
        vehicleExtraTimeRates.put(Vehicle.vehicle_type.BUS, 25.0);
        return vehicleExtraTimeRates;
    }
}