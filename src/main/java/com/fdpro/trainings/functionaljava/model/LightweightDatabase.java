package com.fdpro.trainings.functionaljava.model;

public class LightweightDatabase implements Database {
    private boolean available;

    public LightweightDatabase(boolean available) {
        this.available = available;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }
}
