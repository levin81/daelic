package com.github.levin81.daelic.druid.postaggregator;

import java.util.List;

public class DoubleGreatestPostAggregator implements PostAggregator {

    private final String type = "doubleGreatest";

    private String name;
    private List<PostAggregator> fields;

    DoubleGreatestPostAggregator(String name, List<PostAggregator> fields) {
        this.name = name;
        this.fields = fields;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<PostAggregator> getFields() {
        return fields;
    }

    public static DoubleGreatestPostAggregatorBuilder builder() {
        return new DoubleGreatestPostAggregatorBuilder();
    }

    public static class DoubleGreatestPostAggregatorBuilder {

        private String name;
        private List<PostAggregator> fields;

        DoubleGreatestPostAggregatorBuilder() {

        }

        public DoubleGreatestPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoubleGreatestPostAggregatorBuilder withFields(List<PostAggregator> fields) {
            this.fields = fields;
            return this;
        }

        public DoubleGreatestPostAggregator build() {
            return new DoubleGreatestPostAggregator(name, fields);
        }
    }
}
