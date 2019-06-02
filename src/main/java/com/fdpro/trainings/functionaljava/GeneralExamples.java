package com.fdpro.trainings.functionaljava;

import java.util.function.Function;

public class GeneralExamples {

    public String transform(String input, Function<String, String> transformer) {
        return transformer.apply(input);
    }
}
