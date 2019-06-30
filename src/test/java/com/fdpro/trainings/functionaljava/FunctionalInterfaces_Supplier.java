package com.fdpro.trainings.functionaljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

class FunctionalInterfaces_Supplier {

    public static void main(String[] args) {
        List<String> peopleNames = Arrays.asList(
          "Robert",
          "Anna",
          "Kevin",
          "Amelia"
        );

        //TODO Generate people with random ages
    }

    private List<Person> giveAges(List<String> peopleNames, Supplier<Integer> supplier) {
        List<Person> people = new ArrayList<>();
        for (String personName : peopleNames) {
            people.add(new Person(personName, supplier.get()));
        }
        return people;
    }
}