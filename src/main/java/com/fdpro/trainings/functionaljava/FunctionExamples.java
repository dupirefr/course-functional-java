package com.fdpro.trainings.functionaljava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExamples {

    public static List<String> getPeopleNames(List<Person> people) {
        List<String> names = new ArrayList<>();
        for (Person person : people) {
            names.add(person.getName());
        }
        return names;
    }

    public static List<Integer> getPeopleAges(List<Person> people) {
        List<Integer> ages = new ArrayList<>();
        for (Person person : people) {
            ages.add(person.getAge());
        }
        return ages;
    }














    public static <T> List<T> getPeopleInfo(List<Person> people, Function<Person, T> extract) {
        List<T> result = new ArrayList<>();
        for (Person person : people) {
            result.add(extract.apply(person));
        }
        return result;
    }
}
