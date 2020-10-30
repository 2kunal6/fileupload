Description: This project provides a ParkingLot service.

- Design:
    -  Abstract class Vehicle:
        - has enum type for types of vehicles like Car, Bus etc.
        - has registration_number to identify the vehicle
        - extended by vehicle types like Car, Bus etc.
    - Decorator class ParkingLotVehicle:
        - Contains Vehicle as member variable
        - has other ParkingLot information like InTime, OutTime, isPaymentMade etc.
    - Strategy pattern to extend ParkingLotVehicle to have different payment strategies like
        - HourlyParkingVehicle: pay as per number of hours
        - PayUpfrontParkingVehicle: pay in advance but pay penalty if time is overshoot.
    - Util.TimeUtil class provides some basic time related functions.
    - ParkingLotService: Service class for the core logic
        - uses a Hashmap to maintain vehicle information present in parking lot.
        - Needs to be initialized with:
            - maximumCapacity: maximum number of vehicles that can be kept at one time.
            - vehicleHourlyRates hashmap: keeps a map of rates for each vehicle type like Bus, Car etc.
            - vehicleExtraTimeRates hashmap: keeps penalty values for different vehicle types.
        - Before allowing a new vehicle checks if space available and payment is made
        - Before allowing to remove a vehicle checks if vehicle present, if payment made. 

- To Run:
    - From project root run: mvn install   
    - Run: java -jar target/parking-lot-1.0-SNAPSHOT-jar-with-dependencies.jar
    - Main Class: src/main/java/de/unibonn/App.java
