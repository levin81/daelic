package com.github.levin81.daelic.druid.having;

import java.util.ArrayList;
import java.util.List;

public class AndHaving implements Having {

    private final String type = "and";

    private List<Having> havingSpecs;

    AndHaving(List<Having> havingSpecs) {
        this.havingSpecs = havingSpecs;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<Having> getHavingSpecs() {
        return havingSpecs;
    }

    public static AndHavingBuilder builder() {
        return new AndHavingBuilder();
    }

    public static class AndHavingBuilder {

        private List<Having> havingSpecs;

        AndHavingBuilder() {

        }

        public AndHavingBuilder withHavingSpecs(List<Having> havingSpecs) {
            this.havingSpecs = havingSpecs;
            return this;
        }

        public AndHavingBuilder addHavingSpec(Having havingSpec) {
            if (this.havingSpecs == null) {
                this.havingSpecs = new ArrayList<>();
            }

            this.havingSpecs.add(havingSpec);
            return this;
        }

        public AndHaving build() {
            return new AndHaving(havingSpecs);
        }
    }
}
