package com.github.levin81.daelic.druid.dimension;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultDimension implements Dimension {

    private final String type = "default";

    private String dimension;
    private String outputName;

    DefaultDimension(String dimension, String outputName) {
        Properties.assertRequired(dimension, "Dimension is a required property");

        this.dimension = dimension;
        this.outputName = outputName;
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

    public static DefaultDimensionBuilder builder() {
        return new DefaultDimensionBuilder();
    }

    public static class DefaultDimensionBuilder {

        private String dimension;
        private String outputName;

        DefaultDimensionBuilder() {

        }

        public DefaultDimensionBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public DefaultDimensionBuilder withOutputName(String outputName) {
            this.outputName = outputName;
            return this;
        }

        public DefaultDimension build() {
            return new DefaultDimension(dimension, outputName);
        }
    }
}
