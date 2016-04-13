package com.bootcamp.domain;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.parkinglot.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class Agent extends Observer {
    private FilePaper filePaper;

    public Agent(List<String> events, FilePaper filePaper){
        super(events);
        this.filePaper = filePaper;
    }

    @Override
    public void notify(String eventType, String message) {
        if(eventType.equals(EventTypes.CARNOTFOUND))
        filePaper.filePaperFor("CAR NOT FOUND");
    }
}
