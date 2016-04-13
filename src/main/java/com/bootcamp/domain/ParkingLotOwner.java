package com.bootcamp.domain;

import com.bootcamp.parkinglot.ParkingLot;
import com.bootcamp.parkinglot.ParkingLotNotifications;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingLotOwner implements ParkingLotNotifications {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public ParkingLotOwner(){

    }
    public ParkingLotOwner(String id) {
        this.id = id;
    }

    public void showParkingFullSign(){
            System.out.println("parking lot is full");
    }

    public void removeParkingFullSign() {

        System.out.println("parking is available");
    }

}
