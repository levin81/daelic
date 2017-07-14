package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

/**
 * Computes the minimum of all metric values and Double.POSITIVE_INFINITY
 */
public class DoubleMinAggregator implements Aggregator {

    private final String type = "doubleMin";

    private String name;
    private String fieldName;

    DoubleMinAggregator(String name, String fieldName) {
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

    public static DoubleMinAggregatorBuilder builder() {
        return new DoubleMinAggregatorBuilder();
    }

    public static class DoubleMinAggregatorBuilder {
        private String name;
        private String fieldName;

        DoubleMinAggregatorBuilder() {

        }

        public DoubleMinAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoubleMinAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public DoubleMinAggregator build() {
            return new DoubleMinAggregator(name, fieldName);
        }
    }
}
