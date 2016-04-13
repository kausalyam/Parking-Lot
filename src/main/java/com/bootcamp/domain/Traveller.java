package com.bootcamp.domain;

import com.bootcamp.parkinglot.ParkingLot;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class Traveller {

    private String id;
    private String name;
    private Car car;
    private ParkingLot parkingLot;

    public Traveller(String id, String name,Car car){
        this.id=id;
        this.name=name;
        this.car=car;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public void getParkingLot() {
//        parkingLot = new ParkingLot();
//    }

//    public boolean parkTheCar(){
//
//        return parkingLot.addCarToTheParkingLot(this.car);
//    }
//
//    public boolean unParkTheCar() {
//        return parkingLot.removeCarFromTheParkingLot(this.car);
//    }
}
