package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalProgramming {

    private List<Person> people;

    @BeforeEach
    void initPeople() {
        people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16)
        );
    }

    @Test
    void givenPeople_whenGetPeopleNames_thenResult() {
        List<String> peopleNames = getPeopleNames(people);

        assertThat(peopleNames).containsExactly("Robert", "Anna", "Kevin");
    }


    @Test
    void givenPeople_whenGetPeopleAges_thenResult() {
        List<Integer> peopleAges = getPeopleAges(people);

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }


    @Test
    void givenPeople_whenGetPeopleInfo_Names_thenResult() {

        List<String> peopleNames = getPeopleInfo(people, );

        assertThat(peopleNames).containsExactly("Robert", "Anna", "Kevin");
    }

    @Test
    void givenPeople_whenGetPeopleInfo_Ages_thenResult() {

        List<Integer> peopleAges = getPeopleInfo(people, );

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }

    private <T> List<T> getPeopleInfoWithFunction(List<Person> people, Function<Person, T> function) {
        List<T> result = new ArrayList<>();
        for (Person person : people) {
            result.add(function.apply(person));
        }
        return result;
    }

    @Test
    void givenPeople_whenGetPeopleInfoWithFunction_Ages_thenResult() {

        List<Integer> peopleAges = getPeopleInfoWithFunction(people, );

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }

    @Test
    void givenPeople_whenGetPeopleInfoWithFunction_Ages_Lambda_thenResult() {

        List<Integer> peopleAges = getPeopleInfoWithFunction(people, );

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }

    @Test
    void givenPeople_whenGetPeopleInfoWithFunction_Ages_MethodReference_thenResult() {

        List<Integer> peopleAges = getPeopleInfoWithFunction(people, );

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }
}
