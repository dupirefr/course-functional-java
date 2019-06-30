package com.fdpro.trainings.functionaljava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class FunctionalInterfaces_Consumer {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16),
          new Person("Amelia", 30)
        );

        //TODO Prints people names
        //TODO Prints people names and gather into a list
    }

    private void consumePeopleInfo(List<Person> people, Consumer<Person> consumer) {
        for (Person person : people) {
            consumer.accept(person);
        }
    }
}
