package com.github.levin81.daelic.druid.having;

public class GreaterThanHaving implements Having {

    private final String type = "greaterThan";

    private String aggregation;
    private Number value;

    GreaterThanHaving(String aggregation, Number value) {
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

    public static GreaterThanHavingBuilder builder() {
        return new GreaterThanHavingBuilder();
    }

    public static class GreaterThanHavingBuilder {

        private String aggregation;
        private Number value;

        GreaterThanHavingBuilder() {

        }

        public GreaterThanHavingBuilder withAggregation(String aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        public GreaterThanHavingBuilder withValue(Number value) {
            this.value = value;
            return this;
        }

        public GreaterThanHaving build() {
            return new GreaterThanHaving(aggregation, value);
        }
    }
}
