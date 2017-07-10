package com.github.levin81.daelic.util;

import com.github.levin81.daelic.exception.InvalidPropertyException;
import com.github.levin81.daelic.exception.RequiredPropertyException;

import java.util.function.Function;

public final class Properties {

    private Properties() {

    }

    public static <T> void assertRequired(T property, String errorMessage) {
        if (property == null) {
            throw new RequiredPropertyException(errorMessage);
        }
    }

    public static <T, E> void assertRequiredDependency(T property, E dependency, String errorMessage) {
        if (property != null && dependency == null) {
            throw new RequiredPropertyException(errorMessage);
        }
    }

    public static <T> void assertValid(T property, Function<T, Boolean> booleanExpression, String errorMessage) {
        if (!booleanExpression.apply(property)) {
            throw new InvalidPropertyException(errorMessage);
        }
    }
}
