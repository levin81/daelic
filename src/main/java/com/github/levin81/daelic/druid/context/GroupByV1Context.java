package com.github.levin81.daelic.druid.context;

import java.time.Period;

public class GroupByV1Context extends Context {

    private final String groupByStrategy = "v1";

    private boolean groupByIsSingleThreaded;
    private int maxIntermediateRows;
    private int maxResults;
    private boolean useOffHeap;

    GroupByV1Context(int timeout, int priority, String queryId, boolean useCache, boolean populateCache,
                     boolean bySegment, boolean finalize, Period chunkPeriod, boolean groupByIsSingleThreaded,
                     int maxIntermediateRows, int maxResults, boolean useOffHeap) {

        super(timeout, priority, queryId, useCache, populateCache, bySegment, finalize, chunkPeriod);

        this.groupByIsSingleThreaded = groupByIsSingleThreaded;
        this.maxIntermediateRows = maxIntermediateRows;
        this.maxResults = maxResults;
        this.useOffHeap = useOffHeap;
    }

    public String getGroupByStrategy() {
        return groupByStrategy;
    }

    public boolean isGroupByIsSingleThreaded() {
        return groupByIsSingleThreaded;
    }

    public int getMaxIntermediateRows() {
        return maxIntermediateRows;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public boolean isUseOffHeap() {
        return useOffHeap;
    }

    public static GroupByV1ContextBuilder builder() {
        return new GroupByV1ContextBuilder();
    }

    public static class GroupByV1ContextBuilder extends ContextBuilder<GroupByV1ContextBuilder> {

        private boolean groupByIsSingleThreaded;
        private int maxIntermediateRows;
        private int maxResults;
        private boolean useOffHeap;

        GroupByV1ContextBuilder() {

        }

        public GroupByV1ContextBuilder withGroupByIsSingleThreaded(boolean groupByIsSingleThreaded) {
            this.groupByIsSingleThreaded = groupByIsSingleThreaded;
            return this;
        }

        public GroupByV1ContextBuilder withMaxIntermediateRows(int maxIntermediateRows) {
            this.maxIntermediateRows = maxIntermediateRows;
            return this;
        }

        public GroupByV1ContextBuilder withMaxResults(int maxResults) {
            this.maxResults = maxResults;
            return this;
        }

        public GroupByV1ContextBuilder withUseOffHeap(boolean useOffHeap) {
            this.useOffHeap = useOffHeap;
            return this;
        }

        public GroupByV1Context build() {
            return new GroupByV1Context(timeout, priority, queryId, useCache, populateCache, bySegment,
                    finalize, chunkPeriod, groupByIsSingleThreaded, maxIntermediateRows, maxResults, useOffHeap);
        }
    }
}
