package com.bootcamp.parkinglot;

import com.bootcamp.domain.Car;
import com.bootcamp.domain.ParkingLotOwner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingLot {
    private static ParkingLot instance = null;
    private String id;
    private Integer numOfSlots;
    private ParkingLotNotifications notifiableOwner;
    private List<Car> parkedCars;
    private boolean notifiedFullToOwner;


    public ParkingLot(ParkingLotNotifications owner, int noOfSlots) {
        this.numOfSlots = noOfSlots;
        parkedCars = new ArrayList<Car>(numOfSlots);
        this.notifiableOwner = owner;
    }

    public boolean parkTheCar(Car car) {
        if (!parkedCars.contains(car) && !isParkingFull()) {
            parkedCars.add(car);
            if (isParkingFull()) {
                notifiableOwner.showParkingFullSign();
                notifiedFullToOwner = true;
            }
            return true;
        }
        return false;
    }

    private boolean isParkingFull() {
        return parkedCars.size() == this.numOfSlots;
    }

    public Car unparkTheCar(Car car) {
        if (parkedCars.remove(car)) {
            if (notifiedFullToOwner && !isParkingFull()) {
                notifiableOwner.removeParkingFullSign();
                notifiedFullToOwner = false;
            }
            return car;
        }
        return null;
    }
}
