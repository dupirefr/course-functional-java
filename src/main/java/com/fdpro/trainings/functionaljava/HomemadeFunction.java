package com.fdpro.trainings.functionaljava;

@FunctionalInterface
public interface HomemadeFunction<T, U> {

    U apply(T input);
}
