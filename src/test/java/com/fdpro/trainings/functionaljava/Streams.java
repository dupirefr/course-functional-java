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

        assertThat(peopleOlderThanForty).containsExactly(
          new Person("Robert", 50),
          new Person("Anna", 43)
        );
    }

    @Test
    void givenPeople_whenStreamMap_thenResult() {

        assertThat(peopleNames).containsExactly(
          "Robert",
          "Anna"
        );
    }

    @Test
    void givenPeople_whenStreamCollect_thenResult() {

        assertThat(peopleSet).containsAll(people);
    }

    @Test
    void givenPeople_whenStreamForEach_thenResultPrinted() {
    }

    @Test
    void givenPeople_whenStreamMin_thenResult() {

        assertThat(youngestPerson)
          .isPresent()
          .contains(new Person("Kevin", 16));
    }

    @Test
    void givenPeople_whenStreamMax_thenResult() {

        assertThat(youngestPerson)
          .isPresent()
          .contains(new Person("Robert", 50));
    }

    @Test
    void givenPeople_whenStreamReduce_thenResult() {

        assertThat(averageAge).isEqualTo(34.75);
    }
}
