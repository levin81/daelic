package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

/**
 * Computes the maximum of all metric values and Long.MIN_VALUE
 */
public class LongMaxAggregator implements Aggregator {

    private final String type = "longMax";

    private String name;
    private String fieldName;

    LongMaxAggregator(String name, String fieldName) {
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

    public static LongMaxAggregatorBuilder builder() {
        return new LongMaxAggregatorBuilder();
    }

    public static class LongMaxAggregatorBuilder {
        private String name;
        private String fieldName;

        LongMaxAggregatorBuilder() {

        }

        public LongMaxAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LongMaxAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public LongMaxAggregator build() {
            return new LongMaxAggregator(name, fieldName);
        }
    }
}
