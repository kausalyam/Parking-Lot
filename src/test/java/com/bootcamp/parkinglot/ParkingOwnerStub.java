package com.bootcamp.parkinglot;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.domain.ParkingLotOwner;

import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingOwnerStub extends Observer {

    private int notificationCountFull;
    private int notificationCountAvailable;

    public ParkingOwnerStub(List<String> events) {
        super(events);
    }

    public int getNotificationCountFull() {
        return notificationCountFull;
    }

    public int getNotificationCountAvailable() {
        return notificationCountAvailable;
    }

    @Override
    public void notify(String eventType, String message) {
        if (eventType.equals(EventTypes.PARKINGFULL))
            notificationCountFull++;
        if (eventType.equals(EventTypes.PARKINGAVAILABLE))
            notificationCountAvailable++;

    }

}
