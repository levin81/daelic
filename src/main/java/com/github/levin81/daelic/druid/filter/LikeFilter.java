package com.github.levin81.daelic.druid.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;
import com.github.levin81.daelic.util.Properties;

/**
 * Like filters can be used for basic wildcard searches. They are equivalent to the SQL LIKE operator. Special
 * characters supported are "%" (matches any number of characters) and "_" (matches any one character).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LikeFilter implements Filter {

    private final String type = "like";

    private String dimension;
    private String pattern;
    private String escape;
    private ExtractionFn extractionFn;

    LikeFilter(String dimension, String pattern, String escape, ExtractionFn extractionFn) {
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(pattern, "Pattern is a required property");

        this.dimension = dimension;
        this.pattern = pattern;
        this.escape = escape;
        this.extractionFn = extractionFn;
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

    public String getEscape() {
        return escape;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static LikeFilterBuilder builder() {
        return new LikeFilterBuilder();
    }

    public static class LikeFilterBuilder {

        private String dimension;
        private String pattern;
        private String escape;
        private ExtractionFn extractionFn;

        LikeFilterBuilder() {

        }

        public LikeFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public LikeFilterBuilder withPattern(String pattern) {
            this.pattern = pattern;
            return this;
        }

        public LikeFilterBuilder withEscape(String escape) {
            this.escape = escape;
            return this;
        }

        public LikeFilterBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public LikeFilter build() {
            return new LikeFilter(dimension, pattern, escape, extractionFn);
        }
    }
}
