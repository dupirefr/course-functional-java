package com.fdpro.trainings.functionaljava.examples;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class GeneralExamplesTest {

    @Test
    void transform_toUpperCase() {
        Function<String, String> toUpperCase = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        assertThat(toUpperCase.apply("Input")).isEqualTo("INPUT");
    }

    @Test
    void transform_toLowerCase() {
        Function<String, String> toLowerCase = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        };

        assertThat(toLowerCase.apply("Input")).isEqualTo("input");
    }

    @Test
    void transform_doubleString_lambda() {
        Function<String, String> doubleString = s -> s + s;

        assertThat(doubleString.apply("Input")).isEqualTo("InputInput");
    }

    @Test
    void transform_trim_methodReference() {
        Function<String, String> trim = String::trim;

        assertThat(trim.apply("  Input  ")).isEqualTo("Input");
    }
}