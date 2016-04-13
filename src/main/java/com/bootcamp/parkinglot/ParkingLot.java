package com.bootcamp.parkinglot;

import com.bootcamp.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingLot {
    private static ParkingLot instance= null;
    private List<String> parkedCars;

    public ParkingLot() {
        parkedCars=new ArrayList<String>();
    }

    private boolean checkIfCarIsAlreadyParked(Car car) {
       return this.parkedCars.contains(car.getId());
    }

    public boolean addCarToTheParkingLot(Car car){
        if(!checkIfCarIsAlreadyParked(car)) {
            parkedCars.add(car.getId());
            return true;
        }
        return false;
    }

    public boolean removeCarFromTheParkingLot(Car car) {
        if(checkIfCarIsAlreadyParked(car)) {
            parkedCars.remove(car.getId());
            return true;
        }
        return false;
    }
}
