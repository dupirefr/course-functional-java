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

        Predicate<Person> olderThanForty = person -> person.getAge() >= 40;
        List<Person> peopleOlderThanForty = getPeopleMatching(people, olderThanForty);

        Predicate<Person> hasShortName = person -> person.getName().length() <= 5;

        List<Person> peopleOlderThanFortyWithShortNames = getPeopleMatching(people, olderThanForty.and(hasShortName));

        List<Person> peopleOlderThanFortyOrWithShortNames = getPeopleMatching(people, olderThanForty.or(hasShortName));

        List<Person> peopleYoungerThanForty = getPeopleMatching(people, olderThanForty.negate());
        System.out.println(peopleYoungerThanForty);
    }

    private static List<Person> getPeopleMatching(List<Person> people, Predicate<Person> predicate) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
