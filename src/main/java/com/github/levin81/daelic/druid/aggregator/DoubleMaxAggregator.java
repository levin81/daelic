package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

/**
 * Computes the maximum of all metric values and Double.NEGATIVE_INFINITY
 */
public class DoubleMaxAggregator implements Aggregator {

    private final String type = "doubleMax";

    private String name;
    private String fieldName;

    DoubleMaxAggregator(String name, String fieldName) {
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

    public static DoubleMaxAggregatorBuilder builder() {
        return new DoubleMaxAggregatorBuilder();
    }

    public static class DoubleMaxAggregatorBuilder {
        private String name;
        private String fieldName;

        DoubleMaxAggregatorBuilder() {

        }

        public DoubleMaxAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoubleMaxAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public DoubleMaxAggregator build() {
            return new DoubleMaxAggregator(name, fieldName);
        }
    }
}
