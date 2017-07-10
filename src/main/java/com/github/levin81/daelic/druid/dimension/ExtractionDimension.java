package com.github.levin81.daelic.druid.dimension;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;
import com.github.levin81.daelic.util.Properties;

public class ExtractionDimension implements Dimension {

    private final String type = "extraction";

    private String dimension;
    private String outputName;
    private ExtractionFn extractionFn;

    ExtractionDimension(String dimension, String outputName, ExtractionFn extractionFn) {
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(extractionFn, "ExtractionFn is a required property");

        this.dimension = dimension;
        this.outputName = outputName;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public String getOutputName() {
        return outputName;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static ExtractionDimensionBuilder build() {
        return new ExtractionDimensionBuilder();
    }

    public static class ExtractionDimensionBuilder {

        private String dimension;
        private String outputName;
        private ExtractionFn extractionFn;

        ExtractionDimensionBuilder() {

        }

        public ExtractionDimensionBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public ExtractionDimensionBuilder withOutputName(String outputName) {
            this.outputName = outputName;
            return this;
        }

        public ExtractionDimensionBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public ExtractionDimension build() {
            return new ExtractionDimension(dimension, outputName, extractionFn);
        }
    }
}
