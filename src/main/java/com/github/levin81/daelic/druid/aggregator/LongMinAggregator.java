package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

/**
 * Computes the minimum of all metric values and Long.MAX_VALUE
 */
public class LongMinAggregator implements Aggregator {

    private final String type = "longMin";

    private String name;
    private String fieldName;

    LongMinAggregator(String name, String fieldName) {
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

    public static LongMinAggregatorBuilder builder() {
        return new LongMinAggregatorBuilder();
    }

    public static class LongMinAggregatorBuilder {
        private String name;
        private String fieldName;

        LongMinAggregatorBuilder() {

        }

        public LongMinAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LongMinAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public LongMinAggregator build() {
            return new LongMinAggregator(name, fieldName);
        }
    }
}
