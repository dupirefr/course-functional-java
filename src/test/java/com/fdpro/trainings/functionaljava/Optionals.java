package com.fdpro.trainings.functionaljava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Optionals {

    private Person robert;
    private Person anna;

    @BeforeEach
    void initPeople() {
        robert = new Person("Robert", 50);
        anna = new Person("Anna", 43);
    }

    @Test
    void givenPerson_whenOptionalOf_thenResult() {
        Optional<Person> somebody = null;

        assertThat(somebody)
          .isPresent()
          .contains(robert);
    }

    @Test
    void givenPerson_whenOptionalOfNullable_Filled_thenResult() {
        Optional<Person> somebody = null;

        assertThat(somebody)
          .isPresent()
          .contains(robert);
    }

    @Test
    void givenPerson_whenOptionalOfNullable_Empty_thenResult() {
        Optional<Person> somebody = null;

        assertThat(somebody).isEmpty();
    }

    @Test
    void givenPerson_whenOptionalEmpty_thenResult() {
        Optional<Person> somebody = null;

        assertThat(somebody).isEmpty();
    }

    @Test
    void givenPerson_whenOptionalFilter_Match_thenResult() {
        Optional<Person> somebody = null;

        assertThat(somebody)
          .isPresent()
          .contains(robert);
    }

    @Test
    void givenPerson_whenOptionalFilter_NoMatch_thenResult() {
        Optional<Person> somebody = null;

        assertThat(somebody).isEmpty();
    }

    @Test
    void givenPerson_whenOptionalMap_thenResult() {
        Optional<Integer> somebody = null;

        assertThat(somebody)
          .isPresent()
          .contains(50);
    }

    @Test
    void givenPerson_whenOptionalOrElse_Filled_thenResult() {
        Person somebody = null;

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalOrElse_Empty_thenResult() {
        Person somebody = null;

        assertThat(somebody).isEqualTo(anna);
    }

    @Test
    void givenPerson_whenOptionalOrElseGet_Filled_thenResult() {
        Person somebody = null;

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalOrElseGet_Empty_thenResult() {
        Person somebody = null;

        assertThat(somebody).isEqualTo(anna);
    }

    @Test
    void givenPerson_whenOptionalOrElseThrow_Filled_thenResult() {
        Person somebody = null;

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalOrElseThrow_Empty_thenResult() {
        assertThatThrownBy(null)
          .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenPerson_whenOptionalGet_Filled_thenResult() {
        Person somebody = null;

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalGet_Empty_thenResult() {
        assertThatThrownBy(null)
          .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenPerson_whenOptionalIsPresent_Filled_thenResult() {

    }

    @Test
    void givenPerson_whenOptionalIfPresent_Filled_thenResult() {

    }
}
