package com.bootcamp.domain;

/**
 * Created by kausalyamani on 13/04/16.
 */
public class Car {
    private String id;
    private String modelName;

    public Car(String id, String name){
        this.id=id;
        this.modelName=name;
    }
    public String getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }
}
