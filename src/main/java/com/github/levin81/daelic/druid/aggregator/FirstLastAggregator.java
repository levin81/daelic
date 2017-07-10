package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

/***
 * Computes the metric value with the minimum (or maximum) timestamp or 0 if no row exist
 */
public class FirstLastAggregator implements Aggregator {

    private String type;
    private String name;
    private String fieldName;

    FirstLastAggregator(String type, String name, String fieldName) {
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

    public static FirstLastAggregatorBuilder longFirstBuilder() {
        return new FirstLastAggregatorBuilder("longFirst");
    }

    public static FirstLastAggregatorBuilder longLastBuilder() {
        return new FirstLastAggregatorBuilder("longLast");
    }

    public static FirstLastAggregatorBuilder doubleFirstBuilder() {
        return new FirstLastAggregatorBuilder("doubleFirst");
    }

    public static FirstLastAggregatorBuilder doubleLastBuilder() {
        return new FirstLastAggregatorBuilder("doubleLast");
    }

    public static class FirstLastAggregatorBuilder {
        private final String type;
        private String name;
        private String fieldName;

        FirstLastAggregatorBuilder(String type) {
            this.type = type;
        }

        public FirstLastAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FirstLastAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public FirstLastAggregator build() {
            return new FirstLastAggregator(type, name, fieldName);
        }

    }
}
