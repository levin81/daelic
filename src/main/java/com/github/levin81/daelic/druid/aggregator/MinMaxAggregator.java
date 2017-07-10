package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

/***
 * Computes the minimum (or maximum) of all metric values and Long.MAX_VALUE (or Long.MIN_VALUE)
 * Computes the minimum (or maximum) of all metric values and Double.POSITIVE_INFINITY (or Double.NEGATIVE_INFINITY)
 */
public class MinMaxAggregator implements Aggregator {

    private String type;
    private String name;
    private String fieldName;

    MinMaxAggregator(String type, String name, String fieldName) {
        Properties.assertRequired(type, "Type is a required property");
        Properties.assertRequired(name, "Name is a required property");
        Properties.assertRequired(fieldName, "FieldName is a required property");

        this.type = type;
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

    public static MinMaxAggregatorBuilder longMinBuilder() {
        return new MinMaxAggregatorBuilder("longMin");
    }

    public static MinMaxAggregatorBuilder longMaxBuilder() {
        return new MinMaxAggregatorBuilder("longMax");
    }

    public static MinMaxAggregatorBuilder doubleMinBuilder() {
        return new MinMaxAggregatorBuilder("doubleMin");
    }

    public static MinMaxAggregatorBuilder doubleMaxBuilder() {
        return new MinMaxAggregatorBuilder("doubleMax");
    }

    public static class MinMaxAggregatorBuilder {
        private final String type;
        private String name;
        private String fieldName;

        MinMaxAggregatorBuilder(String type) {
            this.type = type;
        }

        public MinMaxAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MinMaxAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public MinMaxAggregator build() {
            return new MinMaxAggregator(type, name, fieldName);
        }

    }
}
