package com.github.levin81.daelic.druid.searchqueryspec;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainsSearchQuerySpec implements SearchQuerySpec {

    private final String type = "contains";

    private String value;
    private boolean caseSensitive;

    ContainsSearchQuerySpec(String value, boolean caseSensitive) {
        this.value = value;
        this.caseSensitive = caseSensitive;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public static ContainsSearchQuerySpecBuilder builder() {
        return new ContainsSearchQuerySpecBuilder();
    }

    public static class ContainsSearchQuerySpecBuilder {

        private String value;
        private boolean caseSensitive;

        ContainsSearchQuerySpecBuilder() {

        }

        public ContainsSearchQuerySpecBuilder withValue(String value) {
            this.value = value;
            return this;
        }

        public ContainsSearchQuerySpecBuilder withCaseSensitive(boolean caseSensitive) {
            this.caseSensitive = caseSensitive;
            return this;
        }

        public ContainsSearchQuerySpec build() {
            return new ContainsSearchQuerySpec(value, caseSensitive);
        }
    }
}
