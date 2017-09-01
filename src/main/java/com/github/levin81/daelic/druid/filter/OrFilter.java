package com.github.levin81.daelic.druid.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrFilter implements Filter {

    private final String type = "or";

    private List<Filter> fields;

    OrFilter(List<Filter> fields) {
        Properties.assertRequired(fields, "Fields is a required property");

        this.fields = fields;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<Filter> getFields() {
        return fields;
    }

    public static OrFilterBuilder builder() {
        return new OrFilterBuilder();
    }

    public static class OrFilterBuilder {

        private List<Filter> fields;

        OrFilterBuilder() {

        }

        public OrFilterBuilder withFields(List<Filter> fields) {
            this.fields = new ArrayList<>(fields);
            return this;
        }

        public OrFilterBuilder addField(Filter field) {
            if (this.fields == null) {
                this.fields = new ArrayList<>();
            }

            this.fields.add(field);
            return this;
        }

        public OrFilter build() {
            return new OrFilter(fields);
        }
    }
}
