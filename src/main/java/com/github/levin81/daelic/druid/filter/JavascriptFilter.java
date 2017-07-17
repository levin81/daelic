package com.github.levin81.daelic.druid.filter;

import com.github.levin81.daelic.util.Properties;

/**
 * The JavaScript filter matches a dimension against the specified JavaScript function predicate. The filter
 * matches values for which the function returns true.
 *
 * The function takes a single argument, the dimension value, and returns either true or false.
 */
public class JavascriptFilter implements Filter {

    private final String type = "javascript";

    private String dimension;
    private String function;

    JavascriptFilter(String dimension, String function) {
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(function, "Function is a required property");

        this.dimension = dimension;
        this.function = function;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public String getFunction() {
        return function;
    }

    public static JavascriptFilterBuilder builder() {
        return new JavascriptFilterBuilder();
    }

    public static class JavascriptFilterBuilder {

        private String dimension;
        private String function;

        JavascriptFilterBuilder() {

        }

        public JavascriptFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public JavascriptFilterBuilder withFunction(String function) {
            this.function = function;
            return this;
        }

        public JavascriptFilter build() {
            return new JavascriptFilter(dimension, function);
        }
    }
}
