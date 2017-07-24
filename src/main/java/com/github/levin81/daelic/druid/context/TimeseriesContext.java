package com.github.levin81.daelic.druid.context;

import java.time.Period;

public class TimeseriesContext extends Context {

    private boolean skipEmptyBuckets;

    TimeseriesContext(int timeout, int priority, String queryId, boolean useCache, boolean populateCache,
                      boolean bySegment, boolean finalize, Period chunkPeriod, boolean skipEmptyBuckets) {

        super(timeout, priority, queryId, useCache, populateCache, bySegment, finalize, chunkPeriod);

        this.skipEmptyBuckets = skipEmptyBuckets;
    }

    public boolean isSkipEmptyBuckets() {
        return skipEmptyBuckets;
    }

    public static TimeseriesContextBuilder builder() {
        return new TimeseriesContextBuilder();
    }

    public static class TimeseriesContextBuilder extends ContextBuilder<TimeseriesContextBuilder> {

        private boolean skipEmptyBuckets;

        TimeseriesContextBuilder() {

        }

        public TimeseriesContextBuilder withSkipEmptyBuckets(boolean skipEmptyBuckets) {
            this.skipEmptyBuckets = skipEmptyBuckets;
            return this;
        }

        public TimeseriesContext build() {
            return new TimeseriesContext(timeout, priority, queryId, useCache, populateCache, bySegment,
                    finalize, chunkPeriod, skipEmptyBuckets);
        }
    }
}
