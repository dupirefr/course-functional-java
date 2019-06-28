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
        Optional<Person> somebody = Optional.of(robert);

        assertThat(somebody)
          .isPresent()
          .contains(robert);
    }

    @Test
    void givenPerson_whenOptionalOfNullable_Filled_thenResult() {
        Optional<Person> somebody = Optional.ofNullable(robert);

        assertThat(somebody)
          .isPresent()
          .contains(robert);
    }

    @Test
    void givenPerson_whenOptionalOfNullable_Empty_thenResult() {
        Optional<Person> somebody = Optional.ofNullable(null);

        assertThat(somebody).isEmpty();
    }

    @Test
    void givenPerson_whenOptionalEmpty_thenResult() {
        Optional<Person> somebody = Optional.empty();

        assertThat(somebody).isEmpty();
    }

    @Test
    void givenPerson_whenOptionalFilter_Match_thenResult() {
        Optional<Person> somebody = Optional.of(robert)
          .filter(person -> person.getAge() >= 40);

        assertThat(somebody)
          .isPresent()
          .contains(robert);
    }

    @Test
    void givenPerson_whenOptionalFilter_NoMatch_thenResult() {
        Optional<Person> somebody = Optional.of(robert)
          .filter(person -> person.getAge() < 40);

        assertThat(somebody).isEmpty();
    }

    @Test
    void givenPerson_whenOptionalMap_thenResult() {
        Optional<Integer> somebody = Optional.of(robert)
          .map(Person::getAge);

        assertThat(somebody)
          .isPresent()
          .contains(50);
    }

    @Test
    void givenPerson_whenOptionalOrElse_Filled_thenResult() {
        Person somebody = Optional.of(robert).orElse(anna);

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalOrElse_Empty_thenResult() {
        Person somebody = Optional.<Person>empty().orElse(anna);

        assertThat(somebody).isEqualTo(anna);
    }

    @Test
    void givenPerson_whenOptionalOrElseGet_Filled_thenResult() {
        Supplier<Person> personSupplier = () -> {
            System.out.println("Supplied");
            return anna;
        };
        Person somebody = Optional.of(robert).orElseGet(personSupplier);

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalOrElseGet_Empty_thenResult() {
        Supplier<Person> personSupplier = () -> {
            System.out.println("Supplied");
            return anna;
        };
        Person somebody = Optional.<Person>empty().orElseGet(personSupplier);

        assertThat(somebody).isEqualTo(anna);
    }

    @Test
    void givenPerson_whenOptionalOrElseThrow_Filled_thenResult() {
        Person somebody = Optional.of(robert).orElseThrow(IllegalStateException::new);

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalOrElseThrow_Empty_thenResult() {
        assertThatThrownBy(() -> Optional.<Person>empty().orElseThrow(IllegalStateException::new))
          .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenPerson_whenOptionalGet_Filled_thenResult() {
        Person somebody = Optional.of(robert).get();

        assertThat(somebody).isEqualTo(robert);
    }

    @Test
    void givenPerson_whenOptionalGet_Empty_thenResult() {
        assertThatThrownBy(() -> Optional.<Person>empty().get())
          .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenPerson_whenOptionalIsPresent_Filled_thenResult() {
        Optional<Person> somebody = Optional.of(robert);
        if (somebody.isPresent()) {
            System.out.println("Robert's here!");
        }
    }

    @Test
    void givenPerson_whenOptionalIfPresent_Filled_thenResult() {
        Optional<Person> somebody = Optional.of(robert);
        somebody.ifPresent(person -> System.out.println("Robert's here!"));
    }
}
