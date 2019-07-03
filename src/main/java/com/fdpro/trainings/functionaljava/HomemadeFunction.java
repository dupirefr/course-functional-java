package com.fdpro.trainings.functionaljava;

@FunctionalInterface
public interface HomemadeFunction<T, U> {

    U apply(T input);

    default <V> HomemadeFunction<T, V> andThen(HomemadeFunction<U, V> after) {
        return input -> after.apply(this.apply(input));
    }
}
