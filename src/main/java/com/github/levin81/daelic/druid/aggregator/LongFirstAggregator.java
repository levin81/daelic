package com.github.levin81.daelic.druid.aggregator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LongFirstAggregator implements Aggregator {

    private final String type = "longFirst";

    private String name;
    private String fieldName;

    LongFirstAggregator(String name, String fieldName) {
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

    public static LongFirstAggregatorBuilder builder() {
        return new LongFirstAggregatorBuilder();
    }

    public static class LongFirstAggregatorBuilder {
        private String name;
        private String fieldName;

        LongFirstAggregatorBuilder() {

        }

        public LongFirstAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LongFirstAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public LongFirstAggregator build() {
            return new LongFirstAggregator(name, fieldName);
        }
    }
}
