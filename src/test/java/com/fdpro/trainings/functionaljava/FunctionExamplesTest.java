package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionExamplesTest {

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
    void getPeopleNames() {
        List<String> names = FunctionExamples.getPeopleNames(people);

        assertThat(names).containsExactly("Robert", "Anna", "Kevin");
    }

    @Test
    void getPeopleAges() {
        List<Integer> ages = FunctionExamples.getPeopleAges(people);

        assertThat(ages).containsExactly(50, 43, 15);
    }

    @Test
    void getPeopleInfo_Names() {
        Function<Person, String> getName = person -> person.getName();
        List<String> names = FunctionExamples.getPeopleInfo(people, getName);

        assertThat(names).containsExactly("Robert", "Anna", "Kevin");
    }

    @Test
    void getPeopleInfo_Ages() {
        Function<Person, Integer> getAge = Person::getAge;
        List<Integer> ages = FunctionExamples.getPeopleInfo(people, getAge);

        assertThat(ages).containsExactly(50, 43, 15);
    }
}