package com.bootcamp.parkinglot;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.domain.APB;

import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class PoliceStub extends Observer{

    private int carNotFound ;

    public int getCarNotFound() {
        return carNotFound;
    }

    public PoliceStub(List<String> events) {
        super(events);
    }

    @Override
    public void notify(String eventType, String message) {
        if (eventType.equals(EventTypes.CARNOTFOUND)){
            carNotFound++;
        }



    }
}
