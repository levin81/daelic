package com.github.levin81.daelic.druid.havingspec;

public class GreaterThanHavingSpec implements HavingSpec {

    private final String type = "greaterThan";

    private String aggregation;
    private Number value;

    GreaterThanHavingSpec(String aggregation, Number value) {
        this.aggregation = aggregation;
        this.value = value;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getAggregation() {
        return aggregation;
    }

    public Number getValue() {
        return value;
    }

    public static GreaterThanHavingSpecBuilder builder() {
        return new GreaterThanHavingSpecBuilder();
    }

    public static class GreaterThanHavingSpecBuilder {

        private String aggregation;
        private Number value;

        GreaterThanHavingSpecBuilder() {

        }

        public GreaterThanHavingSpecBuilder withAggregation(String aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        public GreaterThanHavingSpecBuilder withValue(Number value) {
            this.value = value;
            return this;
        }

        public GreaterThanHavingSpec build() {
            return new GreaterThanHavingSpec(aggregation, value);
        }
    }
}
