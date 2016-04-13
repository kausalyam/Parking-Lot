package com.bootcamp.parkinglot;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.domain.Agent;

import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class AgentStub extends Observer {
    private int notifyCountForGreaterThan80;
    private int notifyCountForLessThan80;


    private int carNotFound ;

    public int getCarNotFound() {
        return carNotFound;
    }

    public AgentStub(List<String> events) {
        super(events);
    }

    public int getNotifyCountForGreaterThan80() {
        return notifyCountForGreaterThan80;
    }

    public int getNotifyCountForLessThan80() {
        return notifyCountForLessThan80;
    }

    @Override
    public void notify(String eventType,String message) {
        if(eventType.equals(EventTypes.GREATERTHAN80PERCENT))
            notifyCountForGreaterThan80++;
        if(eventType.equals(EventTypes.LESSTHAN80PERCENT))
            notifyCountForLessThan80++;
        if(eventType.equals(EventTypes.CARNOTFOUND))
            carNotFound++;
    }
}
