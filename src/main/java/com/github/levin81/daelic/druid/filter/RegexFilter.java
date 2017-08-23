package com.github.levin81.daelic.druid.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

/***
 * The regular expression filter is similar to the selector filter, but using regular expressions. It matches
 * the specified dimension with the given pattern. The pattern can be any standard Java regular expression.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegexFilter implements Filter {

    private final String type = "regex";

    private String dimension;
    private String pattern;

    RegexFilter(String dimension, String pattern) {
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(pattern, "Pattern is a required property");

        this.dimension = dimension;
        this.pattern = pattern;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public String getPattern() {
        return pattern;
    }

    public static RegexFilterBuilder builder() {
        return new RegexFilterBuilder();
    }

    public static class RegexFilterBuilder {

        private String dimension;
        private String pattern;

        RegexFilterBuilder() {

        }

        public RegexFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public RegexFilterBuilder withPattern(String pattern) {
            this.pattern = pattern;
            return this;
        }

        public RegexFilter build() {
            return new RegexFilter(dimension, pattern);
        }
    }
}
