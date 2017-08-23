package com.github.levin81.daelic.druid.postaggregator;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JavascriptPostAggregator implements PostAggregator {

    private final String type = "javascript";

    private String name;
    private List<String> fieldNames;
    private String function;

    JavascriptPostAggregator(String name, List<String> fieldNames, String function) {
        this.name = name;
        this.fieldNames = fieldNames;
        this.function = function;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public String getFunction() {
        return function;
    }

    public static JavascriptPostAggregatorBuilder builder() {
        return new JavascriptPostAggregatorBuilder();
    }

    public static class JavascriptPostAggregatorBuilder {

        private String name;
        private List<String> fieldNames;
        private String function;

        JavascriptPostAggregatorBuilder() {

        }

        public JavascriptPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public JavascriptPostAggregatorBuilder withFieldNames(List<String> fieldNames) {
            this.fieldNames = fieldNames;
            return this;
        }

        public JavascriptPostAggregatorBuilder addFieldName(String fieldName) {
            if (this.fieldNames == null) {
                this.fieldNames = new ArrayList<>();
            }

            this.fieldNames.add(fieldName);
            return this;
        }

        public JavascriptPostAggregatorBuilder withFunction(String function) {
            this.function = function;
            return this;
        }

        public JavascriptPostAggregator build() {
            return new JavascriptPostAggregator(name, fieldNames, function);
        }
    }
}
