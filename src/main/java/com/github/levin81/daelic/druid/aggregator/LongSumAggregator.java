package com.github.levin81.daelic.druid.aggregator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LongSumAggregator implements Aggregator {

    private final String type = "longSum";

    private String name;
    private String fieldName;

    LongSumAggregator(String name, String fieldName) {
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

    public static LongSumAggregatorBuilder builder() {
        return new LongSumAggregatorBuilder();
    }

    public static class LongSumAggregatorBuilder {
        private String name;
        private String fieldName;

        LongSumAggregatorBuilder() {

        }

        public LongSumAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LongSumAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public LongSumAggregator build() {
            return new LongSumAggregator(name, fieldName);
        }
    }
}
