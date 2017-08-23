package com.github.levin81.daelic.druid.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotFilter implements Filter {

    private final String type = "not";

    private Filter field;

    NotFilter(Filter field) {
        Properties.assertRequired(field, "Field is a required property");

        this.field = field;
    }

    @Override
    public String getType() {
        return type;
    }

    public Filter getField() {
        return field;
    }

    public static NotFilterBuilder builder() {
        return new NotFilterBuilder();
    }

    public static class NotFilterBuilder {

        private Filter field;

        NotFilterBuilder() {

        }

        public NotFilterBuilder withField(Filter field) {
            this.field = field;
            return this;
        }

        public NotFilter build() {
            return new NotFilter(field);
        }
    }
}
