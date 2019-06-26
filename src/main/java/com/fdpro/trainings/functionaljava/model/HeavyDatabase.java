package com.fdpro.trainings.functionaljava.model;

public class HeavyDatabase implements Database {

    public HeavyDatabase() {
        System.out.println("Some heavy set ups");
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
