package com.bootcamp.domain;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.parkinglot.Observer;

import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class PoliceDepartment extends Observer{
    private APB apb;
    public PoliceDepartment(List<String> events, APB apb) {
        super(events);
        this.apb=apb;
    }


    @Override
    public void notify(String eventType, String message) {
        if(eventType.equals(EventTypes.CARNOTFOUND))
        this.apb.submitReport(message);
    }

}
