package com.bootcamp.domain;

import com.bootcamp.parkinglot.Observer;

import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingLotOwner extends Observer {


    public ParkingLotOwner(List<String> events) {
        super(events);
    }


}
