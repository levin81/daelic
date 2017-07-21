package com.github.levin81.daelic.druid.filter;

import com.github.levin81.daelic.druid.Interval;
import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;

import java.util.ArrayList;
import java.util.List;

public class IntervalFilter implements Filter {

    private final String type = "interval";

    private String dimension;
    private List<Interval> intervals;
    private ExtractionFn extractionFn;

    IntervalFilter(String dimension, List<Interval> intervals, ExtractionFn extractionFn) {
        this.dimension = dimension;
        this.intervals = intervals;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static IntervalFilterBuilder builder() {
        return new IntervalFilterBuilder();
    }

    public static class IntervalFilterBuilder {

        private String dimension;
        private List<Interval> intervals;
        private ExtractionFn extractionFn;

        IntervalFilterBuilder() {

        }

        public IntervalFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public IntervalFilterBuilder withIntervals(List<Interval> intervals) {
            this.intervals = intervals;
            return this;
        }

        public IntervalFilterBuilder addInterval(Interval interval) {
            if (this.intervals == null) {
                this.intervals = new ArrayList<>();
            }

            this.intervals.add(interval);
            return this;
        }

        public IntervalFilterBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public IntervalFilter build() {
            return new IntervalFilter(dimension, intervals, extractionFn);
        }
    }
}
