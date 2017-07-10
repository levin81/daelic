package com.github.levin81.daelic.druid.metric;

import com.github.levin81.daelic.druid.SortingOrder;

public class DimensionTopNMetric implements TopNMetric {

    private String ordering = SortingOrder.LEXICOGRAPHIC;
    private String previousStop;

    @Override
    public String getType() {
        return "dimension";
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
