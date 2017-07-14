package com.github.levin81.daelic.druid.filter;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;
import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter {

    private final String type = "and";

    private List<Filter> fields;
    private ExtractionFn extractionFn;

    AndFilter(List<Filter> fields, ExtractionFn extractionFn) {
        Properties.assertRequired(fields, "Fields is a required property");

        this.fields = fields;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<Filter> getFields() {
        return fields;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static AndFilterBuilder build() {
        return new AndFilterBuilder();
    }

    public static class AndFilterBuilder {

        private List<Filter> fields;
        private ExtractionFn extractionFn;

        AndFilterBuilder() {

        }

        public AndFilterBuilder withFields(List<Filter> fields) {
            this.fields = fields;
            return this;
        }

        public AndFilterBuilder addField(Filter field) {
            if (this.fields == null) {
                this.fields = new ArrayList<>();
            }

            this.fields.add(field);
            return this;
        }

        public AndFilterBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public AndFilter build() {
            return new AndFilter(fields, extractionFn);
        }
    }
}
