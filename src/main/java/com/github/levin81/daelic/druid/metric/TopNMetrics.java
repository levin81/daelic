package com.github.levin81.daelic.druid.metric;

public final class TopNMetrics {

    public static DimensionTopNMetric.DimensionTopNMetricBuilder DIMENSION() {
        return DimensionTopNMetric.builder();
    }

    public static InvertedTopNMetric.InvertedTopNMetricBuilder INVERTED() {
        return InvertedTopNMetric.builder();
    }

    public static NumericTopNMetric.NumericTopNMetricBuilder NUMERIC() {
        return NumericTopNMetric.builder();
    }
}
