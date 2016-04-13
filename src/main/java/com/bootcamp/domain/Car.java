package com.bootcamp.domain;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class Car {
    private String id;

    public Car(String id){
        this.id=id;
    }
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car) {
            return this.id.equals(((Car) obj).getId());
        }
        return false;
    }
}
