package com.bootcamp.parkinglot;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.domain.Agent;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class AgentTest {
    @Test
    public void testNotifyFilesAPaper() throws Exception {
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.CARNOTFOUND);
        FilePaperStub filePaper = new FilePaperStub();
        Agent agent = new Agent(subscribeToEvents, filePaper);
        agent.notify(EventTypes.CARNOTFOUND, "CAR NOT FOUND");

        assertTrue(filePaper.isPaperFiled());
    }

}