package com.fdpro.trainings.functionaljava;

import java.util.function.BiFunction;

public class BiFunctionExamples {

    public static <T> T getInfo(Person personA, Person personB, BiFunction<Person, Person, T> infoCollector) {
        return infoCollector.apply(personA, personB);
    }
}
