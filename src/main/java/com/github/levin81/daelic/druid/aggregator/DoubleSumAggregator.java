package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

public class DoubleSumAggregator implements Aggregator {

    private final String type = "doubleSum";

    private String name;
    private String fieldName;

    DoubleSumAggregator(String name, String fieldName) {
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

    public static DoubleSumAggregatorBuilder builder() {
        return new DoubleSumAggregatorBuilder();
    }

    public static class DoubleSumAggregatorBuilder {
        private String name;
        private String fieldName;

        DoubleSumAggregatorBuilder() {

        }

        public DoubleSumAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoubleSumAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public DoubleSumAggregator build() {
            return new DoubleSumAggregator(name, fieldName);
        }
    }
}
