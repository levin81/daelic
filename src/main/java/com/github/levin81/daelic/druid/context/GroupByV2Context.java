package com.github.levin81.daelic.druid.context;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Period;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupByV2Context extends Context {

    private final String groupByStrategy = "v2";

    private Integer bufferGrouperInitialBuckets;
    private Integer bufferGrouperMaxLoadFactor;
    private Integer maxMergingDictionarySize;
    private Integer maxOnDiskStorage;
    private Boolean sortByDimsFirst;

    GroupByV2Context(Integer timeout, Integer priority, String queryId, Boolean useCache, Boolean populateCache,
                     Boolean bySegment, Boolean finalize, Period chunkPeriod, Integer bufferGrouperInitialBuckets,
                     Integer bufferGrouperMaxLoadFactor, Integer maxMergingDictionarySize, Integer maxOnDiskStorage,
                     Boolean sortByDimsFirst) {

        super(timeout, priority, queryId, useCache, populateCache, bySegment, finalize, chunkPeriod);

        this.bufferGrouperInitialBuckets = bufferGrouperInitialBuckets;
        this.bufferGrouperMaxLoadFactor = bufferGrouperMaxLoadFactor;
        this.maxMergingDictionarySize = maxMergingDictionarySize;
        this.maxOnDiskStorage = maxOnDiskStorage;
        this.sortByDimsFirst = sortByDimsFirst;
    }

    public String getGroupByStrategy() {
        return groupByStrategy;
    }

    public Integer getBufferGrouperInitialBuckets() {
        return bufferGrouperInitialBuckets;
    }

    public Integer getBufferGrouperMaxLoadFactor() {
        return bufferGrouperMaxLoadFactor;
    }

    public Integer getMaxMergingDictionarySize() {
        return maxMergingDictionarySize;
    }

    public Integer getMaxOnDiskStorage() {
        return maxOnDiskStorage;
    }

    public Boolean isSortByDimsFirst() {
        return sortByDimsFirst;
    }

    public static GroupByV2ContextBuilder builder() {
        return new GroupByV2ContextBuilder();
    }

    public static class GroupByV2ContextBuilder extends ContextBuilder<GroupByV2ContextBuilder> {

        private Integer bufferGrouperInitialBuckets;
        private Integer bufferGrouperMaxLoadFactor;
        private Integer maxMergingDictionarySize;
        private Integer maxOnDiskStorage;
        private Boolean sortByDimsFirst;

        public GroupByV2ContextBuilder withBufferGrouperInitialBuckets(Integer bufferGrouperInitialBuckets) {
            this.bufferGrouperInitialBuckets = bufferGrouperInitialBuckets;
            return this;
        }

        public GroupByV2ContextBuilder withBufferGrouperMaxLoadFactor(Integer bufferGrouperMaxLoadFactor) {
            this.bufferGrouperMaxLoadFactor = bufferGrouperMaxLoadFactor;
            return this;
        }

        public GroupByV2ContextBuilder withMaxMergingDictionarySize(Integer maxMergingDictionarySize) {
            this.maxMergingDictionarySize = maxMergingDictionarySize;
            return this;
        }

        public GroupByV2ContextBuilder withMaxOnDiskStorage(Integer maxOnDiskStorage) {
            this.maxOnDiskStorage = maxOnDiskStorage;
            return this;
        }

        public GroupByV2ContextBuilder withSortByDimsFirst(Boolean sortByDimsFirst) {
            this.sortByDimsFirst = sortByDimsFirst;
            return this;
        }

        public GroupByV2Context build() {
            return new GroupByV2Context(timeout, priority, queryId, useCache, populateCache, bySegment,
                    finalize, chunkPeriod, bufferGrouperInitialBuckets, bufferGrouperMaxLoadFactor,
                    maxMergingDictionarySize, maxOnDiskStorage, sortByDimsFirst);
        }
    }
}
