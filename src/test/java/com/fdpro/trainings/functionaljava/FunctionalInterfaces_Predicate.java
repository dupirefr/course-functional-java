package com.fdpro.trainings.functionaljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class FunctionalInterfaces_Predicate {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16),
          new Person("Amelia", 30)
        );

        //TODO Get people older than forty
        //TODO Get people older than forty and having short names
        //TODO Get people older than forty or having short names
        //TODO Get people younger than forty
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
}
