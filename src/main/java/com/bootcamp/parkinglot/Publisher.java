package com.bootcamp.parkinglot;

/**
 * Created by kausalyamani on 13/04/16.
 */
public interface Publisher {

    public void registerObserver(Observer observer);
    public void notifyAllObservers(String eventName,String message);

}
