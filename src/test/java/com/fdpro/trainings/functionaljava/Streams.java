package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Streams {

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

    @Test
    void givenPeople_whenStreamFilter_thenResult() {
        List<Person> peopleOlderThanForty = null;

        assertThat(peopleOlderThanForty).containsExactly(
          new Person("Robert", 50),
          new Person("Anna", 43)
        );
    }

    @Test
    void givenPeople_whenStreamMap_thenResult() {
        List<String> peopleNames = null;

        assertThat(peopleNames).containsExactly(
          "Robert",
          "Anna"
        );
    }

    @Test
    void givenPeople_whenStreamCollect_thenResult() {
        Set<Person> peopleSet = null;

        assertThat(peopleSet).containsAll(people);
    }

    @Test
    void givenPeople_whenStreamForEach_thenResultPrinted() {
    }

    @Test
    void givenPeople_whenStreamMin_thenResult() {
        Optional<Person> youngestPerson = null;

        assertThat(youngestPerson)
          .isPresent()
          .contains(new Person("Kevin", 16));
    }

    @Test
    void givenPeople_whenStreamMax_thenResult() {
        Optional<Person> oldestPerson = null;

        assertThat(oldestPerson)
          .isPresent()
          .contains(new Person("Robert", 50));
    }

    @Test
    void givenPeople_whenStreamReduce_thenResult() {
        double averageAge = 0d;

        assertThat(averageAge).isEqualTo(34.75);
    }
}
