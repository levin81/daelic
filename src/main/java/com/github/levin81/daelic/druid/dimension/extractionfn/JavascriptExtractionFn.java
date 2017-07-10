package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.github.levin81.daelic.util.Properties;

/***
 * Returns the dimension value, as transformed by the given JavaScript function.
 *
 * For regular dimensions, the input value is passed as a string.
 *
 * For the __time dimension, the input value is passed as a number representing the number of milliseconds since
 * January 1, 1970 UTC.
 *
 * A property of injective specifies if the javascript function preserves uniqueness. The default value is false
 * meaning uniqueness is not preserved
 */
public class JavascriptExtractionFn implements ExtractionFn {

    private final String type = "javascript";

    private String function;
    private boolean injective;

    JavascriptExtractionFn(String function, boolean injective) {
        Properties.assertRequired(function, "Function is a required property");

        this.function = function;
        this.injective = injective;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getFunction() {
        return function;
    }

    public boolean isInjective() {
        return injective;
    }

    public static JavascriptExtractionFnBuilder builder() {
        return new JavascriptExtractionFnBuilder();
    }

    public static class JavascriptExtractionFnBuilder {

        private String function;
        private boolean injective = false;

        JavascriptExtractionFnBuilder() {

        }

        public JavascriptExtractionFnBuilder withFunction(String function) {
            this.function = function;
            return this;
        }

        public JavascriptExtractionFnBuilder withInjective(boolean injective) {
            this.injective = injective;
            return this;
        }

        public JavascriptExtractionFn build() {
            return new JavascriptExtractionFn(function, injective);
        }
    }
}
