package com.github.levin81.daelic.druid.context;

import java.time.Period;

public class TopNContext extends Context {

    private Integer minTopNThreshold;

    TopNContext(Integer timeout, Integer priority, String queryId, Boolean useCache, Boolean populateCache,
                Boolean bySegment, Boolean finalize, Period chunkPeriod, Integer minTopNThreshold) {

        super(timeout, priority, queryId, useCache, populateCache, bySegment, finalize, chunkPeriod);

        this.minTopNThreshold = minTopNThreshold;
    }

    public Integer getMinTopNThreshold() {
        return minTopNThreshold;
    }

    public static TopNContextBuilder builder() {
        return new TopNContextBuilder();
    }

    public static class TopNContextBuilder extends ContextBuilder<TopNContextBuilder> {

        private Integer minTopNThreshold;

        TopNContextBuilder() {

        }

        public TopNContextBuilder withMinTopNThreshold(Integer minTopNThreshold) {
            this.minTopNThreshold = minTopNThreshold;
            return this;
        }

        public TopNContext build() {
            return new TopNContext(timeout, priority, queryId, useCache, populateCache, bySegment,
                    finalize, chunkPeriod, minTopNThreshold);
        }
    }
}
