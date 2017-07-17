package com.github.levin81.daelic.druid.having;

public class NotHaving implements Having {

    private final String type = "not";

    private Having havingSpec;

    NotHaving(Having havingSpecs) {
        this.havingSpec = havingSpecs;
    }

    @Override
    public String getType() {
        return type;
    }

    public Having getHavingSpec() {
        return havingSpec;
    }

    public static NotHavingBuilder builder() {
        return new NotHavingBuilder();
    }

    public static class NotHavingBuilder {

        private Having havingSpec;

        NotHavingBuilder() {

        }

        public NotHavingBuilder withHavingSpec(Having havingSpecs) {
            this.havingSpec = havingSpec;
            return this;
        }

        public NotHaving build() {
            return new NotHaving(havingSpec);
        }
    }
}
