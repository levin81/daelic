package com.github.levin81.daelic.druid.context;

import java.time.Period;

public class TopNContext extends Context {

    private int minTopNThreshold;

    TopNContext(int timeout, int priority, String queryId, boolean useCache, boolean populateCache,
                boolean bySegment, boolean finalize, Period chunkPeriod, int minTopNThreshold) {

        super(timeout, priority, queryId, useCache, populateCache, bySegment, finalize, chunkPeriod);

        this.minTopNThreshold = minTopNThreshold;
    }

    public int getMinTopNThreshold() {
        return minTopNThreshold;
    }

    public static TopNContextBuilder builder() {
        return new TopNContextBuilder();
    }

    public static class TopNContextBuilder extends ContextBuilder<TopNContextBuilder> {

        private int minTopNThreshold;

        TopNContextBuilder() {

        }

        public TopNContextBuilder withMinTopNThreshold(int minTopNThreshold) {
            this.minTopNThreshold = minTopNThreshold;
            return this;
        }

        public TopNContext build() {
            return new TopNContext(timeout, priority, queryId, useCache, populateCache, bySegment,
                    finalize, chunkPeriod, minTopNThreshold);
        }
    }
}
