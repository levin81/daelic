package com.github.levin81.daelic.druid.havingspec;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AndHavingSpec implements HavingSpec {

    private final String type = "and";

    private List<HavingSpec> havingSpecs;

    AndHavingSpec(List<HavingSpec> havingSpecs) {
        this.havingSpecs = havingSpecs;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<HavingSpec> getHavingSpecs() {
        return havingSpecs;
    }

    public static AndHavingSpecBuilder builder() {
        return new AndHavingSpecBuilder();
    }

    public static class AndHavingSpecBuilder {

        private List<HavingSpec> havingSpecs;

        AndHavingSpecBuilder() {

        }

        public AndHavingSpecBuilder withHavingSpecs(List<HavingSpec> havingSpecs) {
            this.havingSpecs = havingSpecs;
            return this;
        }

        public AndHavingSpecBuilder addHavingSpec(HavingSpec havingSpec) {
            if (this.havingSpecs == null) {
                this.havingSpecs = new ArrayList<>();
            }

            this.havingSpecs.add(havingSpec);
            return this;
        }

        public AndHavingSpec build() {
            return new AndHavingSpec(havingSpecs);
        }
    }
}
