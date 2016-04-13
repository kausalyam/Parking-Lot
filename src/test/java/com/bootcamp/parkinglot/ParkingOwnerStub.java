package com.bootcamp.parkinglot;

import com.bootcamp.domain.ParkingLotOwner;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingOwnerStub implements ParkingLotNotifications {

    private int notificationCountFull;
    private int notificationCountAvailable;

    public int getNotificationCountFull() {
        return notificationCountFull;
    }

    public int getNotificationCountAvailable() {
        return notificationCountAvailable;
    }

    public void showParkingFullSign(){
        this.notificationCountFull++;
    }

    public void removeParkingFullSign(){
        this.notificationCountAvailable++;
    }
}
