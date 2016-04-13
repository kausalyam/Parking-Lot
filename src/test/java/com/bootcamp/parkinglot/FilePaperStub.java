package com.bootcamp.parkinglot;

import com.bootcamp.domain.FilePaper;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class FilePaperStub extends FilePaper{
    public boolean isPaperFiled() {

        return paperFiled;
    }

    private boolean paperFiled;
    public void filePaperFor(String message){
        paperFiled = true;
    }

}
