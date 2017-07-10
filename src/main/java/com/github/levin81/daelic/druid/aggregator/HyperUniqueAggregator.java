package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.util.Properties;

/***
 * Uses HyperLogLog to compute the estimated cardinality of a dimension that has been aggregated as a "hyperUnique"
 * metric at indexing time.
 */
public class HyperUniqueAggregator implements Aggregator {

    private final String type = "hyperUnique";

    private String name;
    private String fieldName;

    HyperUniqueAggregator(String name, String fieldName) {
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

    public static HyperUniqueAggregatorBuilder builder() {
        return new HyperUniqueAggregatorBuilder();
    }

    public static class HyperUniqueAggregatorBuilder {

        private String name;
        private String fieldName;

        HyperUniqueAggregatorBuilder() {

        }

        public HyperUniqueAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public HyperUniqueAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public HyperUniqueAggregator build() {
            return new HyperUniqueAggregator(name, fieldName);
        }
    }
}
