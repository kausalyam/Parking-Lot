package com.bootcamp.parkinglot;

import com.bootcamp.com.bootcamp.constants.EventTypes;
import com.bootcamp.domain.PoliceDepartment;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class PoliceDepartmentTest {

    @Test
    public void testNotifySubmitsAPBReport() throws Exception {
        List<String> subscribeToEvents = new ArrayList<String>();
        subscribeToEvents.add(EventTypes.CARNOTFOUND);
        APBStub apb = new APBStub();
        PoliceDepartment police = new PoliceDepartment(subscribeToEvents, apb);
        police.notify(EventTypes.CARNOTFOUND, "CAR NOT FOUND");

        assertTrue(apb.isSubmittedReport());
    }
}