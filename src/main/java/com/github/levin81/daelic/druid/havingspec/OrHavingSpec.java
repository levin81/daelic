package com.github.levin81.daelic.druid.havingspec;

import java.util.ArrayList;
import java.util.List;

public class OrHavingSpec implements HavingSpec {

    private final String type = "or";

    private List<HavingSpec> havingSpecs;

    OrHavingSpec(List<HavingSpec> havingSpecs) {
        this.havingSpecs = havingSpecs;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<HavingSpec> getHavingSpecs() {
        return havingSpecs;
    }

    public static OrHavingSpecBuilder builder() {
        return new OrHavingSpecBuilder();
    }

    public static class OrHavingSpecBuilder {

        private List<HavingSpec> havingSpecs;

        OrHavingSpecBuilder() {

        }

        public OrHavingSpecBuilder withHavingSpecs(List<HavingSpec> havingSpecs) {
            this.havingSpecs = havingSpecs;
            return this;
        }

        public OrHavingSpecBuilder addHavingSpec(HavingSpec havingSpec) {
            if (this.havingSpecs == null) {
                this.havingSpecs = new ArrayList<>();
            }

            this.havingSpecs.add(havingSpec);
            return this;
        }

        public OrHavingSpec build() {
            return new OrHavingSpec(havingSpecs);
        }
    }
}
