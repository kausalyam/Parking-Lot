package com.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public abstract class Observer {

    private List<String> events;

    public List<String> getEvents() {
        return events;
    }

    public Observer(List<String> events){
        this.events = new ArrayList<String>(events);
    }

    public void notify(String eventType,String message){
        System.out.println("I got notified for this event "+eventType+" for this message "+message);
    }
}
