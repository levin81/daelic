package com.github.levin81.daelic.druid.havingspec;

public class LessThanHavingSpec implements HavingSpec {

    private final String type = "lessThan";

    private String aggregation;
    private Number value;

    LessThanHavingSpec(String aggregation, Number value) {
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

    public static LessThanHavingSpecBuilder builder() {
        return new LessThanHavingSpecBuilder();
    }

    public static class LessThanHavingSpecBuilder {

        private String aggregation;
        private Number value;

        LessThanHavingSpecBuilder() {

        }

        public LessThanHavingSpecBuilder withAggregation(String aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        public LessThanHavingSpecBuilder withValue(Number value) {
            this.value = value;
            return this;
        }

        public LessThanHavingSpec build() {
            return new LessThanHavingSpec(aggregation, value);
        }
    }
}
