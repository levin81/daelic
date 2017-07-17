package com.github.levin81.daelic.druid.having;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;

public class DimensionSelectorHaving implements Having {

    private final String type = "dimSelector";

    private String dimension;
    private String value;
    private ExtractionFn extractionFn;

    DimensionSelectorHaving(String dimension, String value, ExtractionFn extractionFn) {
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

    public static DimensionSelectorHavingBuilder builder() {
        return new DimensionSelectorHavingBuilder();
    }

    public static class DimensionSelectorHavingBuilder {

        private String dimension;
        private String value;
        private ExtractionFn extractionFn;

        DimensionSelectorHavingBuilder() {

        }

        public DimensionSelectorHavingBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public DimensionSelectorHavingBuilder withValue(String value) {
            this.value = value;
            return this;
        }

        public DimensionSelectorHavingBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public DimensionSelectorHaving build() {
            return new DimensionSelectorHaving(dimension, value, extractionFn);
        }
    }
}
