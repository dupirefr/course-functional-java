package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class SupplierExampleTest {

    @Test
    void getDatabase_Database_NotAvailable() {
        Database database = new LightweightDatabase(false);
        Database backupDatabase = new HeavyDatabase();

        SupplierExample supplierExample = new SupplierExample(database);

        assertThat(supplierExample.getDatabase(backupDatabase)).isInstanceOf(HeavyDatabase.class);
    }

    @Test
    void getDatabase_Database_Available() {
        Database database = new LightweightDatabase(true);
        Database backupDatabase = new HeavyDatabase();

        SupplierExample supplierExample = new SupplierExample(database);

        assertThat(supplierExample.getDatabase(backupDatabase)).isInstanceOf(LightweightDatabase.class);
    }

    @Test
    void getDatabase_Supplier_NotAvailable() {
        Database database = new LightweightDatabase(false);
        Supplier<Database> backupDatabaseSupplier = () -> new HeavyDatabase();

        SupplierExample supplierExample = new SupplierExample(database);

        assertThat(supplierExample.getDatabase(backupDatabaseSupplier)).isInstanceOf(HeavyDatabase.class);
    }

    @Test
    void getDatabase_Supplier_Available() {
        Database database = new LightweightDatabase(true);
        Supplier<Database> backupDatabaseSupplier = HeavyDatabase::new;

        SupplierExample supplierExample = new SupplierExample(database);

        assertThat(supplierExample.getDatabase(backupDatabaseSupplier)).isInstanceOf(LightweightDatabase.class);
    }
}