package com.bootcamp.parkinglot;

import com.bootcamp.domain.Car;
import com.bootcamp.domain.ParkingLotOwner;
import com.bootcamp.domain.Traveller;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingLotTest {

    private Car car;
    private ParkingLotOwner owner;
    private ParkingLot parkingLot;

    @Test
    public void testToParkTheCar(){

        car = new Car("123");
        owner = new ParkingLotOwner("12");
        parkingLot = new ParkingLot(owner,10);

        assertTrue(parkingLot.parkTheCar(car));
    }
    @Test
    public void testToParkTheCarWhenParkingIsFull(){

        car = new Car("123");
        owner = new ParkingLotOwner("12");
        parkingLot = new ParkingLot(owner,0);

        assertFalse(parkingLot.parkTheCar(car));
    }

    @Test
    public void testToParkTheCarTwice(){

        car = new Car("1234");
        owner = new ParkingLotOwner("123");

        parkingLot = new ParkingLot(owner,10);

        parkingLot.parkTheCar(car);
        assertFalse(parkingLot.parkTheCar(car));
    }

    @Test
    public void testToUnparkParkedCar(){
        car = new Car("12349");
        owner = new ParkingLotOwner("189");

        parkingLot = new ParkingLot(owner,10);

        parkingLot.parkTheCar(car);
        assertEquals(car, parkingLot.unparkTheCar(car));
    }

    @Test
    public void testToUnparkUnParkedCar(){
        car = new Car("123990");
        owner = new ParkingLotOwner("990");

        parkingLot = new ParkingLot(owner,10);

        assertNotEquals(car, parkingLot.unparkTheCar(car));
    }

    @Test
    public void testIfOwnerIsNotifiedWhenParkingIsFull(){
        car = new Car("23457");
        ParkingOwnerStub owner = new ParkingOwnerStub();
        parkingLot = new ParkingLot(owner,1);
        parkingLot.parkTheCar(car);
        parkingLot.unparkTheCar(car);
        parkingLot.parkTheCar(car);
        int expectedNotifyCount=2;
        int actualNotifyCount=owner.getNotificationCountFull();
        assertEquals(expectedNotifyCount,actualNotifyCount);
    }

    @Test
    public void testIfOwnerIsNotifiedWhenParkingIsAvailable(){
        Car firstCar = new Car("23457");
        Car secondCar = new Car("239089");
        ParkingOwnerStub owner = new ParkingOwnerStub();
        parkingLot = new ParkingLot(owner,2);
        parkingLot.parkTheCar(firstCar);
        parkingLot.parkTheCar(secondCar);
        parkingLot.unparkTheCar(firstCar);
        parkingLot.unparkTheCar(secondCar);
        int expectedNotifyCount=1;
        int actualNotifyCount=owner.getNotificationCountAvailable();
        assertEquals(expectedNotifyCount,actualNotifyCount);
    }

}