package com.fdpro.trainings.functionaljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class FunctionalProgramming {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16)
        );

        List<String> names = getPeopleNames(people);

        List<Integer> ages = getPeopleAges(people);

        HomemadeFunction<Person, String> getName = new HomemadeFunction<Person, String>() {
            @Override
            public String apply(Person input) {
                return input.getName();
            }
        };
        names = getPeopleInfo(people, getName);

        HomemadeFunction<Person, Integer> getAge = new HomemadeFunction<Person, Integer>() {
            @Override
            public Integer apply(Person input) {
                return input.getAge();
            }
        };
        ages = getPeopleInfo(people, getAge);

        Function<Person, Integer> getAge2 = Person::getAge;
        ages = getPeopleInfo(people, getAge2);
        System.out.println(ages);
    }

    private static <T> List<T> getPeopleInfo(List<Person> people, Function<Person, T> function) {
        List<T> result = new ArrayList<>();
        for (Person person : people) {
            result.add(function.apply(person));
        }
        return result;
    }

    private static <T> List<T> getPeopleInfo(List<Person> people, HomemadeFunction<Person, T> function) {
        List<T> result = new ArrayList<>();
        for (Person person : people) {
            result.add(function.apply(person));
        }
        return result;
    }

    private static List<Integer> getPeopleAges(List<Person> people) {
        List<Integer> result = new ArrayList<>();
        for (Person person : people) {
            result.add(person.getAge());
        }
        return result;
    }

    private static List<String> getPeopleNames(List<Person> people) {
        List<String> result = new ArrayList<>();
        for (Person person : people) {
            result.add(person.getName());
        }
        return result;
    }
}