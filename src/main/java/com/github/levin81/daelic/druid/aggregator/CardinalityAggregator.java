package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

import java.util.List;

/***
 * Computes the cardinality of a set of Druid dimensions, using HyperLogLog to estimate the cardinality. Please note
 * that this aggregator will be much slower than indexing a column with the hyperUnique aggregator. This aggregator
 * also runs over a dimension column, which means the string dimension cannot be removed from the dataset to improve
 * rollup. In general, we strongly recommend using the hyperUnique aggregator instead of the cardinality aggregator
 * if you do not care about the individual values of a dimension.
 */
public class CardinalityAggregator implements Aggregator {

    private final String type = "cardinality";

    private String name;
    private List<String> fields;
    private boolean byRow;

    CardinalityAggregator(String name, List<String> fields, boolean byRow) {
        Properties.assertRequired(name, "Name is a required property");
        Properties.assertRequired(fields, "Fields is a required property");

        this.name = name;
        this.fields = fields;
        this.byRow = byRow;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<String> getFields() {
        return fields;
    }

    public boolean isByRow() {
        return byRow;
    }

    public static CardinalityAggregatorBuilder builder() {
        return new CardinalityAggregatorBuilder();
    }

    public static class CardinalityAggregatorBuilder {

        private String name;
        private List<String> fields;
        private boolean byRow;

        CardinalityAggregatorBuilder() {

        }

        public CardinalityAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CardinalityAggregatorBuilder withFields(List<String> fields) {
            this.fields = fields;
            return this;
        }

        public CardinalityAggregatorBuilder withByRow(boolean byRow) {
            this.byRow = byRow;
            return this;
        }

        public CardinalityAggregator build() {
            return new CardinalityAggregator(name, fields, byRow);
        }
    }
}
