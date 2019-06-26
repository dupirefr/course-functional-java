package com.fdpro.trainings.functionaljava.examples;

import com.fdpro.trainings.functionaljava.examples.ConsumerExamples;
import com.fdpro.trainings.functionaljava.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ConsumerExamplesTest {

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
    void printPeopleInfo_Names() {
        ConsumerExamples.printPeopleInfo(people, person -> System.out.println(person.getName()));
    }

    @Test
    void printPeopleInfo_Ages() {
        ConsumerExamples.printPeopleInfo(people, person -> System.out.println(person.getAge()));
    }
}