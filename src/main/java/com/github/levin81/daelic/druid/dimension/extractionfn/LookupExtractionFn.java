package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.dimension.extractionfn.lookup.Lookup;
import com.github.levin81.daelic.util.Properties;

/***
 * Lookups are a concept in Druid where dimension values are (optionally) replaced with new values. For more documentation
 * on using lookups, please see here. Explicit lookups allow you to specify a set of keys and values to use when performing
 * the extraction.
 */
// TODO: fix documentation
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LookupExtractionFn implements ExtractionFn {

    private final String type = "lookup";

    private Lookup lookup;
    private boolean retainMissingValue;
    private boolean injective;
    private String replaceMissingValueWith;
    private boolean optimize;

    LookupExtractionFn(Lookup lookup, boolean retainMissingValue, boolean injective, String replaceMissingValueWith,
                       boolean optimize) {
        Properties.assertRequired(lookup, "Lookup is a required property");

        this.lookup = lookup;
        this.retainMissingValue = retainMissingValue;
        this.injective = injective;
        this.replaceMissingValueWith = replaceMissingValueWith;
        this.optimize = optimize;
    }

    @Override
    public String getType() {
        return type;
    }

    public Lookup getLookup() {
        return lookup;
    }

    public boolean isRetainMissingValue() {
        return retainMissingValue;
    }

    public boolean isInjective() {
        return injective;
    }

    public String getReplaceMissingValueWith() {
        return replaceMissingValueWith;
    }

    public boolean isOptimize() {
        return optimize;
    }

    public static LookupExtractionFnBuilder builder() {
        return new LookupExtractionFnBuilder();
    }

    public static class LookupExtractionFnBuilder {

        private Lookup lookup;
        private boolean retainMissingValue = false;
        private boolean injective = false;
        private String replaceMissingValueWith;
        private boolean optimize = true;

        LookupExtractionFnBuilder() {

        }

        public LookupExtractionFnBuilder withLookup(Lookup lookup) {
            this.lookup = lookup;
            return this;
        }

        public LookupExtractionFnBuilder withRetainMissingValue(boolean retainMissingValue) {
            this.retainMissingValue = retainMissingValue;
            return this;
        }

        public LookupExtractionFnBuilder withInjective(boolean injective) {
            this.injective = injective;
            return this;
        }

        public LookupExtractionFnBuilder withReplaceMissingValueWith(String replaceMissingValueWith) {
            this.replaceMissingValueWith = replaceMissingValueWith;
            return this;
        }

        public LookupExtractionFnBuilder withOptimize(boolean optimize) {
            this.optimize = optimize;
            return this;
        }

        public LookupExtractionFn build() {
            return new LookupExtractionFn(lookup, retainMissingValue, injective, replaceMissingValueWith, optimize);
        }
    }
}
