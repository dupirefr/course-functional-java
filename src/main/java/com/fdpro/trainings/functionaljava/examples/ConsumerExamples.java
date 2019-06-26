package com.fdpro.trainings.functionaljava.examples;

import com.fdpro.trainings.functionaljava.model.Person;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExamples {

    public static void printPeopleInfo(List<Person> people, Consumer<Person> printer) {
        for (Person person : people) {
            printer.accept(person);
        }
    }
}
