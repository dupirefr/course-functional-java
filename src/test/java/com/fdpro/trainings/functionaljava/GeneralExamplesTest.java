package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class GeneralExamplesTest {

    @Test
    void transform_toUpperCase() {
        Function<String, String> toUpperCase = null;

        assertThat(toUpperCase.apply("Input")).isEqualTo("INPUT");
    }

    @Test
    void transform_toLowerCase() {
        Function<String, String> toLowerCase = null;

        assertThat(toLowerCase.apply("Input")).isEqualTo("input");
    }

    @Test
    void transform_doubleString_lambda() {
        Function<String, String> doubleString = null;

        assertThat(doubleString.apply("Input")).isEqualTo("InputInput");
    }

    @Test
    void transform_trim_methodReference() {
        Function<String, String> trim = null;

        assertThat(trim.apply("  Input  ")).isEqualTo("Input");
    }
}