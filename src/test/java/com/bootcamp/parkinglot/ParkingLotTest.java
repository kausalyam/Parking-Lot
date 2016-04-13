package com.bootcamp.parkinglot;

import com.bootcamp.domain.Car;
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
    private Traveller traveller;
    private ParkingLot parkingLot;

    @Test
    public void testToParkTheCar(){

        car = new Car("123", "UUUU");
        parkingLot = new ParkingLot();

        assertTrue(parkingLot.addCarToTheParkingLot(car));
    }

    @Test
    public void testToParkTheCarAgain(){

        car = new Car("1234", "UUUU");
        parkingLot = new ParkingLot();

        parkingLot.addCarToTheParkingLot(car);
        assertFalse(parkingLot.addCarToTheParkingLot(car));
    }

    @Test
    public void testToUnparkAParkedCar(){
        car = new Car("12349", "UUUU");
        parkingLot = new ParkingLot();

        parkingLot.addCarToTheParkingLot(car);
        assertTrue(parkingLot.removeCarFromTheParkingLot(car));
    }

    @Test
    public void testToUnparkAUnParkedCar(){
        car = new Car("123990", "UUUU");
        parkingLot = new ParkingLot();

        assertFalse(parkingLot.removeCarFromTheParkingLot(car));
    }
}