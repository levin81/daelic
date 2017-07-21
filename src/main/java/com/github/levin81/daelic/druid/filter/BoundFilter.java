package com.github.levin81.daelic.druid.filter;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;

public class BoundFilter implements Filter {

    private final String type = "bound";

    private String dimension;
    private String lower;
    private String upper;
    private boolean lowerStrict;
    private boolean upperStrict;
    private String ordering;
    private ExtractionFn extractionFn;

    BoundFilter(String dimension, String lower, String upper, boolean lowerStrict, boolean upperStrict,
                String ordering, ExtractionFn extractionFn) {

        this.dimension = dimension;
        this.lower = lower;
        this.upper = upper;
        this.lowerStrict = lowerStrict;
        this.upperStrict = upperStrict;
        this.ordering = ordering;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public String getLower() {
        return lower;
    }

    public String getUpper() {
        return upper;
    }

    public boolean isLowerStrict() {
        return lowerStrict;
    }

    public boolean isUpperStrict() {
        return upperStrict;
    }

    public String getOrdering() {
        return ordering;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static BoundFilterBuilder builder() {
        return new BoundFilterBuilder();
    }

    public static class BoundFilterBuilder {

        private String dimension;
        private String lower;
        private String upper;
        private boolean lowerStrict;
        private boolean upperStrict;
        private String ordering;
        private ExtractionFn extractionFn;

        BoundFilterBuilder() {

        }

        public BoundFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public BoundFilterBuilder withLower(String lower) {
            this.lower = lower;
            return this;
        }

        public BoundFilterBuilder withLower(Number lower) {
            this.lower = lower.toString();
            return this;
        }

        public BoundFilterBuilder withUpper(String upper) {
            this.upper = upper;
            return this;
        }

        public BoundFilterBuilder withUpper(Number upper) {
            this.upper = upper.toString();
            return this;
        }

        public BoundFilterBuilder withLowerStrict(boolean lowerStrict) {
            this.lowerStrict = lowerStrict;
            return this;
        }

        public BoundFilterBuilder withUpperStrict(boolean upperStrict) {
            this.upperStrict = upperStrict;
            return this;
        }

        public BoundFilterBuilder withOrdering(String ordering) {
            this.ordering = ordering;
            return this;
        }

        public BoundFilterBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public BoundFilter build() {
            return new BoundFilter(dimension, lower, upper, lowerStrict, upperStrict, ordering, extractionFn);
        }
    }
}
