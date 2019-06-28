package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfaces_Supplier {

    private List<String> peopleNames;

    @BeforeEach
    void initPeople() {
        peopleNames = Arrays.asList(
          "Robert",
          "Anna",
          "Kevin",
          "Amelia"
        );
    }

    private List<Person> giveAges(List<String> peopleNames, Supplier<Integer> supplier) {
        List<Person> people = new ArrayList<>();
        for (String personName : peopleNames) {
            people.add(new Person(personName, supplier.get()));
        }
        return people;
    }

    @Test
    void givenPeople_whenGiveAges_thenResult() {
        Supplier<Integer> generateAge = () -> new Random().nextInt(75);
        List<Person> people = giveAges(peopleNames, generateAge);

        assertThat(people).allMatch(person -> person.getAge() >= 0 && person.getAge() <= 74);
    }
}
