package com.github.levin81.daelic.druid.filter;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;
import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

public class InFilter implements Filter {

    private final String type = "in";

    private String dimension;
    private List<String> values;
    private ExtractionFn extractionFn;

    InFilter(String dimension, List<String> values, ExtractionFn extractionFn) {
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(values, "Values is a required property");

        this.dimension = dimension;
        this.values = values;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public List<String> getValues() {
        return values;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static InFilterBuilder builder() {
        return new InFilterBuilder();
    }

    public static class InFilterBuilder {

        private String dimension;
        private List<String> values;
        private ExtractionFn extractionFn;

        InFilterBuilder() {

        }

        public InFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public InFilterBuilder withValues(List<String> values) {
            this.values = values;
            return this;
        }

        public InFilterBuilder addValue(String value) {
            if (this.values == null) {
                this.values = new ArrayList<>();
            }

            this.values.add(value);
            return this;
        }

        public InFilterBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public InFilter build() {
            return new InFilter(dimension, values, extractionFn);
        }
    }
}
