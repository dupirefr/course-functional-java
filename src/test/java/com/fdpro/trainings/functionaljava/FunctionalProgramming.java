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

    private List<String> getPeopleNames(List<Person> people) {
        List<String> result = new ArrayList<>();
        for (Person person : people) {
            result.add(person.getName());
        }
        return result;
    }

    @Test
    void givenPeople_whenGetPeopleNames_thenResult() {
        List<String> peopleNames = getPeopleNames(people);

        assertThat(peopleNames).containsExactly("Robert", "Anna", "Kevin");
    }

    private List<Integer> getPeopleAges(List<Person> people) {
        List<Integer> result = new ArrayList<>();
        for (Person person : people) {
            result.add(person.getAge());
        }
        return result;
    }

    @Test
    void givenPeople_whenGetPeopleAges_thenResult() {
        List<Integer> peopleAges = getPeopleAges(people);

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }

    private <T> List<T> getPeopleInfo(List<Person> people, HomemadeFunction<Person, T> function) {
        List<T> result = new ArrayList<>();
        for (Person person : people) {
            result.add(function.apply(person));
        }
        return result;
    }

    @Test
    void givenPeople_whenGetPeopleInfo_Names_thenResult() {
        HomemadeFunction<Person, String> getName = new HomemadeFunction<Person, String>() {
            @Override
            public String apply(Person input) {
                return input.getName();
            }
        };
        List<String> peopleNames = getPeopleInfo(people, getName);

        assertThat(peopleNames).containsExactly("Robert", "Anna", "Kevin");
    }

    @Test
    void givenPeople_whenGetPeopleInfo_Ages_thenResult() {
        HomemadeFunction<Person, Integer> getAge = new HomemadeFunction<Person, Integer>() {
            @Override
            public Integer apply(Person input) {
                return input.getAge();
            }
        };
        List<Integer> peopleAges = getPeopleInfo(people, getAge);

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
        Function<Person, Integer> getAge = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person input) {
                return input.getAge();
            }
        };
        List<Integer> peopleAges = getPeopleInfoWithFunction(people, getAge);

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }

    @Test
    void givenPeople_whenGetPeopleInfoWithFunction_Ages_Lambda_thenResult() {
        Function<Person, Integer> getAge = input -> input.getAge();
        List<Integer> peopleAges = getPeopleInfoWithFunction(people, getAge);

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }

    @Test
    void givenPeople_whenGetPeopleInfoWithFunction_Ages_MethodReference_thenResult() {
        Function<Person, Integer> getAge = Person::getAge;
        List<Integer> peopleAges = getPeopleInfoWithFunction(people, getAge);

        assertThat(peopleAges).containsExactly(50, 43, 16);
    }
}
