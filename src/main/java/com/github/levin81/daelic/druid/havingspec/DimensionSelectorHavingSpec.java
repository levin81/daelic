package com.github.levin81.daelic.druid.havingspec;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;

public class DimensionSelectorHavingSpec implements HavingSpec {

    private final String type = "dimSelector";

    private String dimension;
    private String value;
    private ExtractionFn extractionFn;

    DimensionSelectorHavingSpec(String dimension, String value, ExtractionFn extractionFn) {
        this.dimension = dimension;
        this.value = value;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public String getValue() {
        return value;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static DimensionSelectorHavingSpecBuilder builder() {
        return new DimensionSelectorHavingSpecBuilder();
    }

    public static class DimensionSelectorHavingSpecBuilder {

        private String dimension;
        private String value;
        private ExtractionFn extractionFn;

        DimensionSelectorHavingSpecBuilder() {

        }

        public DimensionSelectorHavingSpecBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public DimensionSelectorHavingSpecBuilder withValue(String value) {
            this.value = value;
            return this;
        }

        public DimensionSelectorHavingSpecBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public DimensionSelectorHavingSpec build() {
            return new DimensionSelectorHavingSpec(dimension, value, extractionFn);
        }
    }
}
