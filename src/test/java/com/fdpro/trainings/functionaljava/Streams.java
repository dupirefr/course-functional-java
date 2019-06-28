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
        List<Person> peopleOlderThanForty = people.stream()
          .filter(person -> person.getAge() >= 40)
          .collect(Collectors.toList());

        assertThat(peopleOlderThanForty).containsExactly(
          new Person("Robert", 50),
          new Person("Anna", 43)
        );
    }

    @Test
    void givenPeople_whenStreamMap_thenResult() {
        List<String> peopleNames = people.stream()
          .map(Person::getName)
          .collect(Collectors.toList());

        assertThat(peopleNames).containsExactly(
          "Robert",
          "Anna"
        );
    }

    @Test
    void givenPeople_whenStreamCollect_thenResult() {
        Set<Object> peopleSet = this.people.stream()
          .collect(Collectors.toSet());

        assertThat(peopleSet).containsAll(people);
    }

    @Test
    void givenPeople_whenStreamForEach_thenResultPrinted() {
         people.stream()
          .forEach(System.out::println);
    }

    @Test
    void givenPeople_whenStreamMin_thenResult() {
        Optional<Person> youngestPerson = people.stream()
          .min(Comparator.comparing(Person::getAge));

        assertThat(youngestPerson)
          .isPresent()
          .contains(new Person("Kevin", 16));
    }

    @Test
    void givenPeople_whenStreamMax_thenResult() {
        Optional<Person> youngestPerson = people.stream()
          .max(Comparator.comparing(Person::getAge));

        assertThat(youngestPerson)
          .isPresent()
          .contains(new Person("Robert", 50));
    }

    @Test
    void givenPeople_whenStreamReduce_thenResult() {
        Double averageAge = people.stream()
          .map(Person::getAge)
          .reduce(
            0d,
            (result, age) -> result + ((double) age / people.size()),
            (result1, result2) -> (result1 + result2) / 2
          );

        assertThat(averageAge).isEqualTo(34.75);
    }
}
