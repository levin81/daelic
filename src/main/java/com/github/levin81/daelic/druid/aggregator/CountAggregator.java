package com.github.levin81.daelic.druid.aggregator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountAggregator implements Aggregator {

    private final String type = "count";
    private String name;

    CountAggregator(String name) {
        Properties.assertRequired(name, "Name is a required property");

        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static CountAggregatorBuilder builder() {
        return new CountAggregatorBuilder();
    }

    public static class CountAggregatorBuilder {

        private String name;

        CountAggregatorBuilder() {

        }

        public CountAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CountAggregator build() {
            return new CountAggregator(name);
        }
    }
}
