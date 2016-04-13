package com.bootcamp.parkinglot;

import com.bootcamp.domain.APB;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class APBStub extends APB {

    private boolean submittedReport;

    public boolean isSubmittedReport() {
        return submittedReport;
    }

    public void submitReport(String message){
        submittedReport=true;
    }
}
