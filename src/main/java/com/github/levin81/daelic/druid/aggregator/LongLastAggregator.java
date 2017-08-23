package com.github.levin81.daelic.druid.aggregator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LongLastAggregator implements Aggregator {

    private final String type = "longLast";

    private String name;
    private String fieldName;

    LongLastAggregator(String name, String fieldName) {
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

    public static LongLastAggregatorBuilder builder() {
        return new LongLastAggregatorBuilder();
    }

    public static class LongLastAggregatorBuilder {
        private String name;
        private String fieldName;

        LongLastAggregatorBuilder() {

        }

        public LongLastAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LongLastAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public LongLastAggregator build() {
            return new LongLastAggregator(name, fieldName);
        }
    }
}
