package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

public class DoubleFirstAggregator implements Aggregator {

    private final String type = "doubleFirst";

    private String name;
    private String fieldName;

    DoubleFirstAggregator(String name, String fieldName) {
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

    public static DoubleFirstAggregatorBuilder builder() {
        return new DoubleFirstAggregatorBuilder();
    }

    public static class DoubleFirstAggregatorBuilder {
        private String name;
        private String fieldName;

        DoubleFirstAggregatorBuilder() {

        }

        public DoubleFirstAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoubleFirstAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public DoubleFirstAggregator build() {
            return new DoubleFirstAggregator(name, fieldName);
        }
    }
}
