package com.github.levin81.daelic.druid.metric;

public class InvertedTopNMetric implements TopNMetric {

    private String metric;

    @Override
    public String getType() {
        return "inverted";
    }

    public String getMetric() {
        return metric;
    }

    InvertedTopNMetric(String metric) {
        this.metric = metric;
    }

    public static InvertedTopNMetricBuilder builder() {
        return new InvertedTopNMetricBuilder();
    }

    public static class InvertedTopNMetricBuilder {
        private String metric;

        InvertedTopNMetricBuilder() {

        }

        public InvertedTopNMetricBuilder withMetric(String metric) {
            this.metric = metric;
            return this;
        }

        public InvertedTopNMetric build() {
            return new InvertedTopNMetric(metric);
        }
    }
}
