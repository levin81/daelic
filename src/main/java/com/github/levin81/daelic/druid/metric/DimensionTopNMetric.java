package com.github.levin81.daelic.druid.metric;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DimensionTopNMetric implements TopNMetric {

    private final String type = "dimension";

    private String ordering;
    private String previousStop;

    @Override
    public String getType() {
        return type;
    }

    public String getOrdering() {
        return ordering;
    }

    public String getPreviousStop() {
        return previousStop;
    }

    DimensionTopNMetric(String ordering, String previousStop) {
        this.ordering = ordering;
        this.previousStop =  previousStop;
    }

    public static DimensionTopNMetricBuilder builder() {
        return new DimensionTopNMetricBuilder();
    }

    public static class DimensionTopNMetricBuilder {

        private String ordering;
        private String previousStop;

        DimensionTopNMetricBuilder() {

        }

        public DimensionTopNMetricBuilder withOrdering(String ordering) {
            this.ordering = ordering;
            return this;
        }

        public DimensionTopNMetricBuilder withPreviousStop(String previousStop) {
            this.previousStop = previousStop;
            return this;
        }

        public DimensionTopNMetric build() {
            return new DimensionTopNMetric(ordering, previousStop);
        }
    }
}
