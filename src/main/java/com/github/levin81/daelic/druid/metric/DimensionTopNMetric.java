package com.github.levin81.daelic.druid.metric;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.sorting.SortingOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DimensionTopNMetric implements TopNMetric {

    private final String type = "dimension";

    private SortingOrder ordering;
    private String previousStop;

    @Override
    public String getType() {
        return type;
    }

    public SortingOrder getOrdering() {
        return ordering;
    }

    public String getPreviousStop() {
        return previousStop;
    }

    DimensionTopNMetric(SortingOrder ordering, String previousStop) {
        this.ordering = ordering;
        this.previousStop =  previousStop;
    }

    public static DimensionTopNMetricBuilder builder() {
        return new DimensionTopNMetricBuilder();
    }

    public static class DimensionTopNMetricBuilder {

        private SortingOrder ordering;
        private String previousStop;

        DimensionTopNMetricBuilder() {

        }

        public DimensionTopNMetricBuilder withOrdering(SortingOrder ordering) {
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
