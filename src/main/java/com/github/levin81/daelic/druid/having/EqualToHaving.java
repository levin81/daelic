package com.github.levin81.daelic.druid.having;

public class EqualToHaving implements Having {

    private final String type = "equalTo";

    private String aggregation;
    private Number value;

    EqualToHaving(String aggregation, Number value) {
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

    public static EqualToHavingBuilder builder() {
        return new EqualToHavingBuilder();
    }

    public static class EqualToHavingBuilder {

        private String aggregation;
        private Number value;

        EqualToHavingBuilder() {

        }

        public EqualToHavingBuilder withAggregation(String aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        public EqualToHavingBuilder withValue(Number value) {
            this.value = value;
            return this;
        }

        public EqualToHaving build() {
            return new EqualToHaving(aggregation, value);
        }

    }
}
