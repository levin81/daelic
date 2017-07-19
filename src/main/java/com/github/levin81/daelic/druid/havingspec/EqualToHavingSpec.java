package com.github.levin81.daelic.druid.havingspec;

public class EqualToHavingSpec implements HavingSpec {

    private final String type = "equalTo";

    private String aggregation;
    private Number value;

    EqualToHavingSpec(String aggregation, Number value) {
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

    public static EqualToHavingSpecBuilder builder() {
        return new EqualToHavingSpecBuilder();
    }

    public static class EqualToHavingSpecBuilder {

        private String aggregation;
        private Number value;

        EqualToHavingSpecBuilder() {

        }

        public EqualToHavingSpecBuilder withAggregation(String aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        public EqualToHavingSpecBuilder withValue(Number value) {
            this.value = value;
            return this;
        }

        public EqualToHavingSpec build() {
            return new EqualToHavingSpec(aggregation, value);
        }

    }
}
