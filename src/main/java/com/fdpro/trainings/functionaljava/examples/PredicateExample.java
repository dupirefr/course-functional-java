package com.fdpro.trainings.functionaljava.examples;

import com.fdpro.trainings.functionaljava.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static List<Person> getPeopleMatching(List<Person> people, Predicate<Person> matcher) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (matcher.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
