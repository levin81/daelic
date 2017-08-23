package com.github.levin81.daelic.druid.postaggregator;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HyperUniqueCardinalityPostAggregator implements PostAggregator {

    private final String type = "hyperUniqueCardinality";

    private String name;
    private String fieldName;

    HyperUniqueCardinalityPostAggregator(String name, String fieldName) {
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

    public static HyperUniqueCardinalityPostAggregatorBuilder builder() {
        return new HyperUniqueCardinalityPostAggregatorBuilder();
    }

    public static class HyperUniqueCardinalityPostAggregatorBuilder {

        private String name;
        private String fieldName;

        HyperUniqueCardinalityPostAggregatorBuilder() {

        }

        public HyperUniqueCardinalityPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public HyperUniqueCardinalityPostAggregatorBuilder withFieldName(String name) {
            this.fieldName = fieldName;
            return this;
        }

        public HyperUniqueCardinalityPostAggregator build() {
            return new HyperUniqueCardinalityPostAggregator(name, fieldName);
        }
    }
}
