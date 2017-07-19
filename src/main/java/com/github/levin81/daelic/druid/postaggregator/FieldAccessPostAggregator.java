package com.github.levin81.daelic.druid.postaggregator;

public class FieldAccessPostAggregator implements PostAggregator {

    private final String type = "fieldAccess";

    private String name;
    private String fieldName;

    FieldAccessPostAggregator(String name, String fieldName) {
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

    public static FieldAccessPostAggregatorBuilder builder() {
        return new FieldAccessPostAggregatorBuilder();
    }

    public static class FieldAccessPostAggregatorBuilder {

        private String name;
        private String fieldName;

        FieldAccessPostAggregatorBuilder() {

        }

        public FieldAccessPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FieldAccessPostAggregatorBuilder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public FieldAccessPostAggregator build() {
            return new FieldAccessPostAggregator(name, fieldName);
        }
    }
}
