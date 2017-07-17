package com.github.levin81.daelic.druid.postaggregator;

public class FieldAccessorPostAggregator implements PostAggregator {

    private final String type = "fieldAccess";

    private String name;
    private String fieldName;

    FieldAccessorPostAggregator(String name, String fieldName) {
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

    public static FieldAccessorPostAggregatorBuilder builder() {
        return new FieldAccessorPostAggregatorBuilder();
    }

    public static class FieldAccessorPostAggregatorBuilder {

        private String name;
        private String fieldName;

        FieldAccessorPostAggregatorBuilder() {

        }

        public FieldAccessorPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FieldAccessorPostAggregatorBuilder withFieldName(String name) {
            this.fieldName = fieldName;
            return this;
        }

        public FieldAccessorPostAggregator build() {
            return new FieldAccessorPostAggregator(name, fieldName);
        }
    }
}
