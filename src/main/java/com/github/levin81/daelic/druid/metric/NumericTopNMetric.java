package com.github.levin81.daelic.druid.metric;

public class NumericTopNMetric implements TopNMetric {

    private final String type = "numeric";

    private String metric;

    NumericTopNMetric(String metric) {
        this.metric = metric;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getMetric() {
        return metric;
    }

    public static NumericTopNMetricBuilder builder() {
        return new NumericTopNMetricBuilder();
    }

    public static class NumericTopNMetricBuilder {

        private String metric;

        NumericTopNMetricBuilder() {

        }

        public NumericTopNMetricBuilder withMetric(String metric) {
            this.metric = metric;
            return this;
        }

        public NumericTopNMetric build() {
            return new NumericTopNMetric(metric);
        }
    }
}
