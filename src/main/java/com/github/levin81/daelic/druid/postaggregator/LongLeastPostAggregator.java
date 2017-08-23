package com.github.levin81.daelic.druid.postaggregator;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LongLeastPostAggregator implements PostAggregator {

    private final String type = "longLeast";

    private String name;
    private List<PostAggregator> fields;

    LongLeastPostAggregator(String name, List<PostAggregator> fields) {
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

    public static LongLeastPostAggregatorBuilder builder() {
        return new LongLeastPostAggregatorBuilder();
    }

    public static class LongLeastPostAggregatorBuilder {

        private String name;
        private List<PostAggregator> fields;

        LongLeastPostAggregatorBuilder() {

        }

        public LongLeastPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LongLeastPostAggregatorBuilder withFields(List<PostAggregator> fields) {
            this.fields = fields;
            return this;
        }

        public LongLeastPostAggregator build() {
            return new LongLeastPostAggregator(name, fields);
        }
    }
}
