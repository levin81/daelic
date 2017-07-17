package com.github.levin81.daelic.druid.dimension;

public final class Dimensions {

    public static DefaultDimension.DefaultDimensionBuilder DEFAULT() {
        return DefaultDimension.builder();
    }

    public static ExtractionDimension.ExtractionDimensionBuilder EXTRACTION() {
        return ExtractionDimension.builder();
    }
}
