package com.bootcamp.parkinglot;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.domain.Car;
import com.bootcamp.domain.ParkingLotOwner;
import com.bootcamp.domain.Traveller;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.PARKINGAVAILABLE);
        subscribeToEvents.add(EventTypes.PARKINGFULL);
        owner = new ParkingLotOwner(subscribeToEvents);
        parkingLot = new ParkingLot(10);

        assertTrue(parkingLot.parkTheCar(car));
    }
    @Test
    public void testToParkTheCarWhenParkingIsFull(){

        car = new Car("123");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.PARKINGAVAILABLE);
        subscribeToEvents.add(EventTypes.PARKINGFULL);
        owner = new ParkingLotOwner(subscribeToEvents);

        parkingLot = new ParkingLot(0);
        parkingLot.registerObserver(owner);

        assertFalse(parkingLot.parkTheCar(car));
    }

    @Test
    public void testToParkTheCarTwice(){

        car = new Car("1234");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.PARKINGAVAILABLE);
        subscribeToEvents.add(EventTypes.PARKINGFULL);
        owner = new ParkingLotOwner(subscribeToEvents);


        parkingLot = new ParkingLot(10);

        parkingLot.parkTheCar(car);
        assertFalse(parkingLot.parkTheCar(car));
    }

    @Test
    public void testToUnparkParkedCar(){
        car = new Car("12349");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.PARKINGAVAILABLE);
        subscribeToEvents.add(EventTypes.PARKINGFULL);
        owner = new ParkingLotOwner(subscribeToEvents);

        parkingLot = new ParkingLot(10);

        parkingLot.parkTheCar(car);
        assertEquals(car, parkingLot.unparkTheCar(car));
    }

    @Test
    public void testToUnparkUnParkedCar(){
        car = new Car("123990");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.PARKINGAVAILABLE);
        subscribeToEvents.add(EventTypes.PARKINGFULL);
        owner = new ParkingLotOwner(subscribeToEvents);

        parkingLot = new ParkingLot(10);

        assertNotEquals(car, parkingLot.unparkTheCar(car));
    }

    @Test
    public void testIfOwnerIsNotifiedWhenParkingIsFull(){
        car = new Car("23457");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.PARKINGAVAILABLE);
        subscribeToEvents.add(EventTypes.PARKINGFULL);
        ParkingOwnerStub owner = new ParkingOwnerStub(subscribeToEvents);

        parkingLot = new ParkingLot(1);
        parkingLot.registerObserver(owner);
        parkingLot.parkTheCar(car);
        parkingLot.unparkTheCar(car);
        parkingLot.parkTheCar(car);
        int expectedNotifyCount=2;
        int actualNotifyCount=owner.getNotificationCountFull();
        assertEquals(expectedNotifyCount,actualNotifyCount);
    }

    @Test
    public void testIfOwnerIsNotifiedWhenParkingIsAvailable(){
        Car firstCar = new Car("2345700");
        Car secondCar = new Car("239089");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.PARKINGAVAILABLE);
        subscribeToEvents.add(EventTypes.PARKINGFULL);

        ParkingOwnerStub owner = new ParkingOwnerStub(subscribeToEvents);
        parkingLot = new ParkingLot(2);
        parkingLot.registerObserver(owner);
        parkingLot.parkTheCar(firstCar);
        parkingLot.parkTheCar(secondCar);
        parkingLot.unparkTheCar(firstCar);
        parkingLot.unparkTheCar(secondCar);
        int expectedNotifyCount=1;
        int actualNotifyCount=owner.getNotificationCountAvailable();
        assertEquals(expectedNotifyCount,actualNotifyCount);
    }

    @Test
    public void testIfAgentIsNotifiedWhen80percentFull(){
        Car firstCar = new Car("2000");
        Car secondCar = new Car("3000");
        Car thirdCar = new Car("100000");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.GREATERTHAN80PERCENT);
        subscribeToEvents.add(EventTypes.LESSTHAN80PERCENT);
        AgentStub agent = new AgentStub(subscribeToEvents);
        parkingLot = new ParkingLot(3);
        parkingLot.registerObserver(agent);
        parkingLot.parkTheCar(firstCar);
        parkingLot.parkTheCar(secondCar);
        int expectedNotifyCount=1;
        int actualNotifyCount=agent.getNotifyCountForGreaterThan80();
        assertEquals(expectedNotifyCount,actualNotifyCount);

    }

    @Test
    public void testIfAgentIsNotifiedWhenLessThan80percent(){
        Car firstCar = new Car("2000000");
        Car secondCar = new Car("3777000");
        Car thirdCar = new Car("188900000");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.GREATERTHAN80PERCENT);
        subscribeToEvents.add(EventTypes.LESSTHAN80PERCENT);
        AgentStub agent = new AgentStub(subscribeToEvents);
        parkingLot = new ParkingLot(3);
        parkingLot.registerObserver(agent);
        parkingLot.parkTheCar(firstCar);
        parkingLot.parkTheCar(secondCar);
        parkingLot.unparkTheCar(firstCar);
        int expectedNotifyCount=1;
        int actualNotifyCount=agent.getNotifyCountForLessThan80();
        assertEquals(expectedNotifyCount,actualNotifyCount);

    }

    @Test
    public void testParkedCarNotFoundForPolice(){
        Car firstCar = new Car("2000000");
        Car thirdCar = new Car("188900000");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.CARNOTFOUND);
        PoliceStub police = new PoliceStub(subscribeToEvents);
        parkingLot = new ParkingLot(3);
        parkingLot.registerObserver(police);
        parkingLot.unparkTheCar(firstCar);
        int expectedNotifyCount=1;
        int actualNotifyCount=police.getCarNotFound();
        assertEquals(expectedNotifyCount,actualNotifyCount);

    }

    @Test
    public void testParkedCarNotFoundForAgent(){
        Car firstCar = new Car("2000000");
        Car thirdCar = new Car("188900000");
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.CARNOTFOUND);
        AgentStub agent = new AgentStub(subscribeToEvents);
        parkingLot = new ParkingLot(3);
        parkingLot.registerObserver(agent);
        parkingLot.unparkTheCar(firstCar);
        int expectedNotifyCount=1;
        int actualNotifyCount=agent.getCarNotFound();
        assertEquals(expectedNotifyCount,actualNotifyCount);

    }

}