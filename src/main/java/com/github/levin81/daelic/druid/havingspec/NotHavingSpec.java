package com.github.levin81.daelic.druid.havingspec;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotHavingSpec implements HavingSpec {

    private final String type = "not";

    private HavingSpec havingSpec;

    NotHavingSpec(HavingSpec havingSpecs) {
        this.havingSpec = havingSpecs;
    }

    @Override
    public String getType() {
        return type;
    }

    public HavingSpec getHavingSpec() {
        return havingSpec;
    }

    public static NotHavingSpecBuilder builder() {
        return new NotHavingSpecBuilder();
    }

    public static class NotHavingSpecBuilder {

        private HavingSpec havingSpec;

        NotHavingSpecBuilder() {

        }

        public NotHavingSpecBuilder withHavingSpec(HavingSpec havingSpec) {
            this.havingSpec = havingSpec;
            return this;
        }

        public NotHavingSpec build() {
            return new NotHavingSpec(havingSpec);
        }
    }
}
