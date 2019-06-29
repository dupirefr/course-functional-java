package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfaces_Functions {

    private List<Person> people;

    @BeforeEach
    void initPeople() {
        people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16)
        );
    }

    private <T> List<T> getPeopleInfo(List<Person> people, Function<Person, T> function) {
        List<T> result = new ArrayList<>();
        for (Person person : people) {
            result.add(function.apply(person));
        }
        return result;
    }

    @Test
    void givenPeople_whenGetPeopleInfo_Ages_thenResult() {

        List<Integer> peopleAges = getPeopleInfo(people, null);

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }

    @Test
    void givenPeople_whenGetPeopleInfo_YearOfBirth_AndThen_thenResult() {

        List<Year> peopleYearOfBirth = getPeopleInfo(people, null);

        assertThat(peopleYearOfBirth).containsExactly(Year.of(1969), Year.of(1976), Year.of(2003));
    }

    @Test
    void givenPeople_whenGetPeopleInfo_YearOfBirth_Compose_thenResult() {

        List<Year> peopleYearOrfBirth = getPeopleInfo(people, null);

        assertThat(peopleYearOrfBirth).containsExactly(Year.of(1969), Year.of(1976), Year.of(2003));
    }
}
