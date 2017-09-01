package com.github.levin81.daelic.druid.context;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Period;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupByV1Context extends Context {

    private final String groupByStrategy = "v1";

    private Boolean groupByIsSingleThreaded;
    private Integer maxIntermediateRows;
    private Integer maxResults;
    private Boolean useOffHeap;

    GroupByV1Context(Integer timeout, Integer priority, String queryId, Boolean useCache, Boolean populateCache,
                     Boolean bySegment, Boolean finalize, Period chunkPeriod, Boolean groupByIsSingleThreaded,
                     Integer maxIntermediateRows, Integer maxResults, Boolean useOffHeap) {

        super(timeout, priority, queryId, useCache, populateCache, bySegment, finalize, chunkPeriod);

        this.groupByIsSingleThreaded = groupByIsSingleThreaded;
        this.maxIntermediateRows = maxIntermediateRows;
        this.maxResults = maxResults;
        this.useOffHeap = useOffHeap;
    }

    public String getGroupByStrategy() {
        return groupByStrategy;
    }

    public Boolean getGroupByIsSingleThreaded() {
        return groupByIsSingleThreaded;
    }

    public Integer getMaxIntermediateRows() {
        return maxIntermediateRows;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public Boolean getUseOffHeap() {
        return useOffHeap;
    }

    public static GroupByV1ContextBuilder builder() {
        return new GroupByV1ContextBuilder();
    }

    public static class GroupByV1ContextBuilder extends ContextBuilder<GroupByV1ContextBuilder> {

        private Boolean groupByIsSingleThreaded;
        private Integer maxIntermediateRows;
        private Integer maxResults;
        private Boolean useOffHeap;

        GroupByV1ContextBuilder() {

        }

        public GroupByV1ContextBuilder withGroupByIsSingleThreaded(Boolean groupByIsSingleThreaded) {
            this.groupByIsSingleThreaded = groupByIsSingleThreaded;
            return this;
        }

        public GroupByV1ContextBuilder withMaxIntermediateRows(Integer maxIntermediateRows) {
            this.maxIntermediateRows = maxIntermediateRows;
            return this;
        }

        public GroupByV1ContextBuilder withMaxResults(Integer maxResults) {
            this.maxResults = maxResults;
            return this;
        }

        public GroupByV1ContextBuilder withUseOffHeap(Boolean useOffHeap) {
            this.useOffHeap = useOffHeap;
            return this;
        }

        public GroupByV1Context build() {
            return new GroupByV1Context(timeout, priority, queryId, useCache, populateCache, bySegment,
                    finalize, chunkPeriod, groupByIsSingleThreaded, maxIntermediateRows, maxResults, useOffHeap);
        }
    }
}
