package com.github.levin81.daelic.druid.having;

public class LessThanHaving implements Having {

    private final String type = "lessThan";

    private String aggregation;
    private Number value;

    LessThanHaving(String aggregation, Number value) {
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

    public static LessThanHavingBuilder builder() {
        return new LessThanHavingBuilder();
    }

    public static class LessThanHavingBuilder {

        private String aggregation;
        private Number value;

        LessThanHavingBuilder() {

        }

        public LessThanHavingBuilder withAggregation(String aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        public LessThanHavingBuilder withValue(Number value) {
            this.value = value;
            return this;
        }

        public LessThanHaving build() {
            return new LessThanHaving(aggregation, value);
        }
    }
}
