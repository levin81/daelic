package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

public class SumAggregator {

    private String type;
    private String name;
    private String fieldName;

    SumAggregator(String type, String name, String fieldName) {
        Properties.assertRequired(type, "Type is a required property");
        Properties.assertRequired(name, "Name is a required property");
        Properties.assertRequired(fieldName, "FieldName is a required property");

        this.type = type;
        this.name = name;
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static SumAggregatorBuilder longBuilder() {
        return new SumAggregatorBuilder("longSum");
    }

    public static SumAggregatorBuilder doubleBuilder() {
        return new SumAggregatorBuilder("doubleSum");
    }

    public static class SumAggregatorBuilder {
        private final String type;
        private String name;
        private String fieldName;

        SumAggregatorBuilder(String type) {
            this.type = type;
        }

        public SumAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SumAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public SumAggregator build() {
            return new SumAggregator(type, name, fieldName);
        }

    }
}
