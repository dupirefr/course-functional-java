package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Comparatorss {

    private List<Person> people;

    @BeforeEach
    void initPeople() {
        people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16),
          new Person("Mike", 16),
          new Person("Amelia", 30)
        );
    }

    @Test
    void givenPeople_whenSort_Ages_thenResult() {
        people.sort(Comparator.comparing(Person::getAge));

        assertThat(people).containsExactly(
          new Person("Kevin", 16),
          new Person("Mike", 16),
          new Person("Amelia", 30),
          new Person("Anna", 43),
          new Person("Robert", 50)
        );
    }

    @Test
    void givenPeople_whenSort_AgesThenNamesLength_thenResult() {
        people.sort(
          Comparator.comparing(Person::getAge)
            .thenComparing(person -> person.getName().length())
        );

        assertThat(people).containsExactly(
          new Person("Mike", 16),
          new Person("Kevin", 16),
          new Person("Amelia", 30),
          new Person("Anna", 43),
          new Person("Robert", 50)
        );
    }

    @Test
    void givenPeople_whenSort_AgesThenNamesReversed_thenResult() {
        people.sort(
          Comparator.comparing(Person::getAge)
            .thenComparing(person -> person.getName().length())
            .reversed()
        );

        assertThat(people).containsExactly(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Amelia", 30),
          new Person("Kevin", 16),
          new Person("Mike", 16)
        );
    }
}
