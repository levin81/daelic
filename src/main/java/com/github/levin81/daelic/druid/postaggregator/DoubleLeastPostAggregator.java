package com.github.levin81.daelic.druid.postaggregator;

import java.util.List;

public class DoubleLeastPostAggregator implements PostAggregator {

    private final String type = "doubleLeast";

    private String name;
    private List<PostAggregator> fields;

    DoubleLeastPostAggregator(String name, List<PostAggregator> fields) {
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

    public static DoubleLeastPostAggregatorBuilder builder() {
        return new DoubleLeastPostAggregatorBuilder();
    }

    public static class DoubleLeastPostAggregatorBuilder {

        private String name;
        private List<PostAggregator> fields;

        DoubleLeastPostAggregatorBuilder() {

        }

        public DoubleLeastPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoubleLeastPostAggregatorBuilder withFields(List<PostAggregator> fields) {
            this.fields = fields;
            return this;
        }

        public DoubleLeastPostAggregator build() {
            return new DoubleLeastPostAggregator(name, fields);
        }
    }
}
