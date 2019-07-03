package com.fdpro.trainings.functionaljava;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class FunctionalInterfaces_Functions {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
          new Person("Robert", 50),
          new Person("Anna", 43),
          new Person("Kevin", 16)
        );

        Function<Person, Integer> getAge = Person::getAge;
        Function<Integer, Year> getYearOfBirth = age -> Year.now().minusYears(age);
        List<Year> years = getPeopleInfo(people, getAge.andThen(getYearOfBirth));

        years = getPeopleInfo(people, getYearOfBirth.compose(getAge));
        System.out.println(years);
    }

    private static <T> List<T> getPeopleInfo(List<Person> people, Function<Person, T> function) {
        List<T> result = new ArrayList<>();
        for (Person person : people) {
            result.add(function.apply(person));
        }
        return result;
    }
}
