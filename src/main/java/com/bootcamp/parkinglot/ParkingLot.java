package com.bootcamp.parkinglot;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class ParkingLot implements Publisher {
    private List<Observer> observers = null;
    private String id;
    private Integer numOfSlots;
    private List<Car> parkedCars;
    private boolean notifiedFullToOwner;



    public ParkingLot(int noOfSlots) {
        this.numOfSlots = noOfSlots;
        parkedCars = new ArrayList<Car>(numOfSlots);
        this.observers = new ArrayList<Observer>();
    }

    public boolean parkTheCar(Car car) {
        if (!parkedCars.contains(car) && !isParkingFull()) {
            parkedCars.add(car);
            if (isParkingFull()) {
                this.notifyAllObservers(EventTypes.PARKINGFULL,"Parking is full");
                notifiedFullToOwner = true;
            }
            if(isParking80percentFull()){
                this.notifyAllObservers(EventTypes.GREATERTHAN80PERCENT,"Parking is Greater than 80 % ");
            }
            if(!isParking80percentFull()){
                this.notifyAllObservers(EventTypes.LESSTHAN80PERCENT,"Parking is less than 80 % ");
            }
            return true;
        }
        return false;
    }

    public Car unparkTheCar(Car car) {
        if (parkedCars.remove(car)) {
            if (notifiedFullToOwner && !isParkingFull()) {
                notifyAllObservers(EventTypes.PARKINGAVAILABLE, "Parking is available");
                notifiedFullToOwner = false;
            }
            return car;
        }
        this.notifyAllObservers(EventTypes.CARNOTFOUND,"Car not found ");
        return null;
    }

    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }



    public void notifyAllObservers(String eventName,String message) {
        for(Observer observer : this.observers){
            List<String> events = observer.getEvents();
            if(events!=null){
                for(String event : events){
                    if(event.equals(eventName)){
                        observer.notify(event,message);
                    }
                }
            }
        }
    }


    private boolean isParking80percentFull() {
        return parkedCars.size() >= Math.floor(0.8 * numOfSlots);
    }

    private boolean isParkingFull() {
        return parkedCars.size() == this.numOfSlots;
    }
}
