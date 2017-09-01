package com.github.levin81.daelic.druid.context;

import java.time.Period;

public class TimeseriesContext extends Context {

    private Boolean skipEmptyBuckets;

    TimeseriesContext(Integer timeout, Integer priority, String queryId, Boolean useCache, Boolean populateCache,
                      Boolean bySegment, Boolean finalize, Period chunkPeriod, Boolean skipEmptyBuckets) {

        super(timeout, priority, queryId, useCache, populateCache, bySegment, finalize, chunkPeriod);

        this.skipEmptyBuckets = skipEmptyBuckets;
    }

    public Boolean isSkipEmptyBuckets() {
        return skipEmptyBuckets;
    }

    public static TimeseriesContextBuilder builder() {
        return new TimeseriesContextBuilder();
    }

    public static class TimeseriesContextBuilder extends ContextBuilder<TimeseriesContextBuilder> {

        private Boolean skipEmptyBuckets;

        TimeseriesContextBuilder() {

        }

        public TimeseriesContextBuilder withSkipEmptyBuckets(Boolean skipEmptyBuckets) {
            this.skipEmptyBuckets = skipEmptyBuckets;
            return this;
        }

        public TimeseriesContext build() {
            return new TimeseriesContext(timeout, priority, queryId, useCache, populateCache, bySegment,
                    finalize, chunkPeriod, skipEmptyBuckets);
        }
    }
}
