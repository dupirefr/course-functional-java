package com.fdpro.trainings.functionaljava;

import java.util.function.Supplier;

public class SupplierExample {

    private Database database;

    public SupplierExample(Database database) {
        this.database = database;
    }

    Database getDatabase(Database backupDatabase) {
        if (database.isAvailable()) {
            return database;
        } else {
            return backupDatabase;
        }
    }

    Database getDatabase(Supplier<Database> backupDatabaseSupplier) {
        if (database.isAvailable()) {
            return database;
        } else {
            return backupDatabaseSupplier.get();
        }
    }
}
