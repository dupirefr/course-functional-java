package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

class BiFunctionExamplesTest {

    private Person robert;
    private Person anna;

    @BeforeEach
    void initPeople() {
        robert = new Person("Robert", 50);
        anna = new Person("Anna", 43);
    }

    @Test
    void getInfo_MaxAge() {
        BiFunction<Person, Person, Integer> getMaxAge = (p1, p2) -> Math.max(p1.getAge(), p2.getAge());

        Integer maxAge = BiFunctionExamples.getInfo(robert, anna, getMaxAge);
        assertThat(maxAge).isEqualTo(50);
    }

    @Test
    void getInfo_PersonWithSmallestName() {
        BiFunction<Person, Person, Person> getPersonWithSmallestName = (p1, p2) -> p1.getName().length() <= p2.getName().length() ? p1 : p2;

        Person personWithSmallestName = BiFunctionExamples.getInfo(robert, anna, getPersonWithSmallestName);
        assertThat(personWithSmallestName).isEqualTo(anna);
    }

}