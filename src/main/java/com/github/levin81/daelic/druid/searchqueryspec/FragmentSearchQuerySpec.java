package com.github.levin81.daelic.druid.searchqueryspec;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FragmentSearchQuerySpec implements SearchQuerySpec {

    private final String type = "fragment";

    private List<String> values;
    private boolean caseSensitive;

    FragmentSearchQuerySpec(List<String> values, boolean caseSensitive) {
        this.values = values;
        this.caseSensitive = caseSensitive;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<String> getValues() {
        return values;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public static FragmentSearchQuerySpecBuilder builder() {
        return new FragmentSearchQuerySpecBuilder();
    }

    public static class FragmentSearchQuerySpecBuilder {

        private List<String> values;
        private boolean caseSensitive;

        FragmentSearchQuerySpecBuilder() {

        }

        public FragmentSearchQuerySpecBuilder withValues(List<String> values) {
            this.values = values;
            return this;
        }

        public FragmentSearchQuerySpecBuilder addValue(String value) {
            if (this.values == null) {
                this.values = new ArrayList<>();
            }

            this.values.add(value);
            return this;
        }

        public FragmentSearchQuerySpecBuilder withCaseSensitive(boolean caseSensitive) {
            this.caseSensitive = caseSensitive;
            return this;
        }

        public FragmentSearchQuerySpec build() {
            return new FragmentSearchQuerySpec(values, caseSensitive);
        }
    }
}
