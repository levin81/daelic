package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CascadeExtractionFn implements ExtractionFn {

    private final String type = "cascade";

    private List<ExtractionFn> extractionFns;

    CascadeExtractionFn(List<ExtractionFn> extractionFns) {
        Properties.assertRequired(extractionFns, "ExtractionFns is a required property");

        this.extractionFns = extractionFns;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<ExtractionFn> getExtractionFns() {
        return extractionFns;
    }

    public static CascadeExtractionFnBuilder builder() {
        return new CascadeExtractionFnBuilder();
    }

    public static class CascadeExtractionFnBuilder {

        private List<ExtractionFn> extractionFns;

        CascadeExtractionFnBuilder() {

        }

        public CascadeExtractionFnBuilder addExtractionFn(ExtractionFn extractionFn) {
            if (this.extractionFns == null) {
                extractionFns = new ArrayList<>();
            }

            this.extractionFns.add(extractionFn);
            return this;
        }

        public CascadeExtractionFnBuilder withExtractionFns(List<ExtractionFn> extractionFns) {
            this.extractionFns = new ArrayList<>(extractionFns);
            return this;
        }

        public CascadeExtractionFn build() {
            return new CascadeExtractionFn(extractionFns);
        }
    }
}
