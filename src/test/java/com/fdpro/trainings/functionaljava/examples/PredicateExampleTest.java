package com.fdpro.trainings.functionaljava.examples;

import com.fdpro.trainings.functionaljava.examples.PredicateExample;
import com.fdpro.trainings.functionaljava.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class PredicateExampleTest {

    private List<Person> people;

    @BeforeEach
    void initPeople() {
        people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 15)
        );
    }

    @Test
    void getPeopleMatching_AgeOlderThanForty() {
        Predicate<Person> olderThanForty = person -> person.getAge() >= 40;
        List<Person> oldPeople = PredicateExample.getPeopleMatching(people, olderThanForty);

        assertThat(oldPeople).containsExactly(
          new Person("Robert", 50),
          new Person("Anna", 43)
        );
    }

    @Test
    void getPeopleMatching_AgeOlderThanFortyAndWithFourLetterName() {
        Predicate<Person> olderThanForty = person -> person.getAge() >= 40;
        Predicate<Person> olderThanFortyAndWithFourLetterName = olderThanForty.and(person -> person.getName().length() == 4);
        List<Person> oldPeople = PredicateExample.getPeopleMatching(people, olderThanFortyAndWithFourLetterName);

        assertThat(oldPeople).containsExactly(
          new Person("Anna", 43)
        );
    }
}