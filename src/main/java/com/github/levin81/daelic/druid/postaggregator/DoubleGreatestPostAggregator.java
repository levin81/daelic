package com.github.levin81.daelic.druid.postaggregator;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
            this.fields = new ArrayList<>(fields);
            return this;
        }

        public DoubleGreatestPostAggregator build() {
            return new DoubleGreatestPostAggregator(name, fields);
        }
    }
}
