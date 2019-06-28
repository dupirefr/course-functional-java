package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfaces_Predicate {

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

    private List<Person> getPeopleMatching(List<Person> people, Predicate<Person> predicate) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    @Test
    void givenPeople_whenGetPeopleMatching_AgeAboveForty_thenResult() {
        Predicate<Person> ageAboveForty = person -> person.getAge() >= 40;
        List<Person> peopleAges = getPeopleMatching(people, ageAboveForty);

        assertThat(peopleAges).containsExactly(
          new Person("Robert", 50),
          new Person("Anna", 43)
        );
    }

    @Test
    void givenPeople_whenGetPeopleMatching_AgeAboveFortyAndShortName_thenResult() {
        Predicate<Person> ageAboveForty = person -> person.getAge() >= 40;
        Predicate<Person> shortName = person -> person.getName().length() <= 5;
        List<Person> peopleAges = getPeopleMatching(people, ageAboveForty.and(shortName));

        assertThat(peopleAges).containsExactly(
          new Person("Anna", 43)
        );
    }

    @Test
    void givenPeople_whenGetPeopleMatching_AgeAboveFortyOrShortName_thenResult() {
        Predicate<Person> ageAboveForty = person -> person.getAge() >= 40;
        Predicate<Person> shortName = person -> person.getName().length() <= 5;
        List<Person> peopleAges = getPeopleMatching(people, ageAboveForty.or(shortName));

        assertThat(peopleAges).containsExactly(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16)
        );
    }

    @Test
    void givenPeople_whenGetPeopleMatching_AgeBesideForty_thenResult() {
        Predicate<Person> ageAboveForty = person -> person.getAge() >= 40;
        List<Person> peopleAges = getPeopleMatching(people, ageAboveForty.negate());

        assertThat(peopleAges).containsExactly(
          new Person("Kevin", 16),
          new Person("Amelia", 30)
        );
    }
}
