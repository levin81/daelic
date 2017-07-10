package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.github.levin81.daelic.util.Properties;

/***
 * Returns the first matching group for the given regular expression. If there is no match, it returns the dimension value as is.
 *
 * For example, using "expr" : "(\\w\\w\\w).*" will transform 'Monday', 'Tuesday', 'Wednesday' into 'Mon', 'Tue', 'Wed'.
 *
 * If the replaceMissingValue property is true, the extraction function will transform dimension values that do not match the regex pattern
 * to a user-specified String. Default value is false.
 *
 * The replaceMissingValueWith property sets the String that unmatched dimension values will be replaced with, if replaceMissingValue is
 * true. If replaceMissingValueWith is not specified, unmatched dimension values will be replaced with nulls.
 *
 * For example, if expr is "(a\w+)" in the example JSON above, a regex that matches words starting with the letter a, the extraction
 * function will convert a dimension value like banana to foobar.
 */
public class RegexExtractionFn implements ExtractionFn {

    private final String type = "regex";

    private String expr;
    private boolean replaceMissingValue;
    private String replaceMissingValueWith;

    RegexExtractionFn(String expr, boolean replaceMissingValue, String replaceMissingValueWith) {
        Properties.assertRequired(expr, "Expr is a required property");

        this.expr = expr;
        this.replaceMissingValue = replaceMissingValue;
        this.replaceMissingValueWith = replaceMissingValueWith;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getExpr() {
        return expr;
    }

    public boolean isReplaceMissingValue() {
        return replaceMissingValue;
    }

    public String getReplaceMissingValueWith() {
        return replaceMissingValueWith;
    }

    public static RegexExtractionFnBuilder builder() {
        return new RegexExtractionFnBuilder();
    }

    public static class RegexExtractionFnBuilder {

        private String expr;
        private boolean replaceMissingValue = false;
        private String replaceMissingValueWith;

        RegexExtractionFnBuilder() {

        }

        public RegexExtractionFnBuilder withExpr(String expr) {
            this.expr = expr;
            return this;
        }

        public RegexExtractionFnBuilder withReplaceMissingValue(boolean replaceMissingValue) {
            this.replaceMissingValue = replaceMissingValue;
            return this;
        }

        public RegexExtractionFnBuilder withReplaceMissingValueWith(String replaceMissingValueWith) {
            this.replaceMissingValueWith = replaceMissingValueWith;
            return this;
        }

        public RegexExtractionFn build() {
            return new RegexExtractionFn(expr, replaceMissingValue, replaceMissingValueWith);
        }
    }
}
