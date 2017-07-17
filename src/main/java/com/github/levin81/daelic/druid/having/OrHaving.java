package com.github.levin81.daelic.druid.having;

import java.util.ArrayList;
import java.util.List;

public class OrHaving implements Having {

    private final String type = "or";

    private List<Having> havingSpecs;

    OrHaving(List<Having> havingSpecs) {
        this.havingSpecs = havingSpecs;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<Having> getHavingSpecs() {
        return havingSpecs;
    }

    public static OrHavingBuilder builder() {
        return new OrHavingBuilder();
    }

    public static class OrHavingBuilder {

        private List<Having> havingSpecs;

        OrHavingBuilder() {

        }

        public OrHavingBuilder withHavingSpecs(List<Having> havingSpecs) {
            this.havingSpecs = havingSpecs;
            return this;
        }

        public OrHavingBuilder addHavingSpec(Having havingSpec) {
            if (this.havingSpecs == null) {
                this.havingSpecs = new ArrayList<>();
            }

            this.havingSpecs.add(havingSpec);
            return this;
        }

        public OrHaving build() {
            return new OrHaving(havingSpecs);
        }
    }
}
