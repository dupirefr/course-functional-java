package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfaces_Consumer {

    private List<Person> people;

    @BeforeEach
    void initPeople() {
        people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16),
          new Person("Amelia", 30)
        );
    }

    private void consumePeopleInfo(List<Person> people, Consumer<Person> consumer) {
        for (Person person : people) {
            consumer.accept(person);
        }
    }

    @Test
    void givenPeople_whenConsumePeopleInfo_PrintNames_thenNamesPrinter() {

        consumePeopleInfo(people, printName);
    }

    @Test
    void givenPeople_whenConsumePeopleInfo_PrintNamesAndGather_thenNamesPrintedAndResult() {
        List<Person> gatheredPeople = new ArrayList<>();


        assertThat(gatheredPeople).isEqualTo(people);
    }
}
