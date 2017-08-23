package com.github.levin81.daelic.druid.searchqueryspec;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InsensitiveContainsSearchQuerySpec implements SearchQuerySpec {

    private final String type = "insensitive_contains";

    private String value;

    InsensitiveContainsSearchQuerySpec(String value) {
        this.value = value;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public static InsensitiveContainsSearchQuerySpecBuilder builder() {
        return new InsensitiveContainsSearchQuerySpecBuilder();
    }

    public static class InsensitiveContainsSearchQuerySpecBuilder {

        private String value;

        InsensitiveContainsSearchQuerySpecBuilder() {

        }

        public InsensitiveContainsSearchQuerySpecBuilder withValue(String value) {
            this.value = value;
            return this;
        }

        public InsensitiveContainsSearchQuerySpec build() {
            return new InsensitiveContainsSearchQuerySpec(value);
        }
    }
}
