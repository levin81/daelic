package com.github.levin81.daelic.druid.postaggregator;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConstantPostAggregator implements PostAggregator {

    private final String type = "constant";

    private String name;
    private Number value;

    ConstantPostAggregator(String name, Number value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Number getValue() {
        return value;
    }

    public static ConstantPostAggregatorBuilder builder() {
        return new ConstantPostAggregatorBuilder();
    }

    public static class ConstantPostAggregatorBuilder {

        private String name;
        private Number value;

        ConstantPostAggregatorBuilder() {

        }

        public ConstantPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ConstantPostAggregatorBuilder withValue(Number value) {
            this.value = value;
            return this;
        }

        public ConstantPostAggregator build() {
            return new ConstantPostAggregator(name, value);
        }
    }
}
