package com.github.levin81.daelic.druid.aggregator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoubleLastAggregator implements Aggregator {

    private final String type = "doubleLast";

    private String name;
    private String fieldName;

    DoubleLastAggregator(String name, String fieldName) {
        Properties.assertRequired(name, "Name is a required property");
        Properties.assertRequired(fieldName, "FieldName is a required property");

        this.name = name;
        this.fieldName = fieldName;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static DoubleLastAggregatorBuilder builder() {
        return new DoubleLastAggregatorBuilder();
    }

    public static class DoubleLastAggregatorBuilder {
        private String name;
        private String fieldName;

        DoubleLastAggregatorBuilder() {

        }

        public DoubleLastAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoubleLastAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public DoubleLastAggregator build() {
            return new DoubleLastAggregator(name, fieldName);
        }
    }
}
