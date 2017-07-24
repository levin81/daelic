package com.github.levin81.daelic.druid.context;

import java.time.Period;

public class GroupByV2Context extends Context {

    private final String groupByStrategy = "v2";

    private int bufferGrouperInitialBuckets;
    private int bufferGrouperMaxLoadFactor;
    private int maxMergingDictionarySize;
    private int maxOnDiskStorage;
    private boolean sortByDimsFirst;

    GroupByV2Context(int timeout, int priority, String queryId, boolean useCache, boolean populateCache,
                     boolean bySegment, boolean finalize, Period chunkPeriod, int bufferGrouperInitialBuckets,
                     int bufferGrouperMaxLoadFactor, int maxMergingDictionarySize, int maxOnDiskStorage,
                     boolean sortByDimsFirst) {

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

    public int getBufferGrouperInitialBuckets() {
        return bufferGrouperInitialBuckets;
    }

    public int getBufferGrouperMaxLoadFactor() {
        return bufferGrouperMaxLoadFactor;
    }

    public int getMaxMergingDictionarySize() {
        return maxMergingDictionarySize;
    }

    public int getMaxOnDiskStorage() {
        return maxOnDiskStorage;
    }

    public boolean isSortByDimsFirst() {
        return sortByDimsFirst;
    }

    public static GroupByV2ContextBuilder builder() {
        return new GroupByV2ContextBuilder();
    }

    public static class GroupByV2ContextBuilder extends ContextBuilder<GroupByV2ContextBuilder> {

        private int bufferGrouperInitialBuckets;
        private int bufferGrouperMaxLoadFactor;
        private int maxMergingDictionarySize;
        private int maxOnDiskStorage;
        private boolean sortByDimsFirst;

        public GroupByV2ContextBuilder withBufferGrouperInitialBuckets(int bufferGrouperInitialBuckets) {
            this.bufferGrouperInitialBuckets = bufferGrouperInitialBuckets;
            return this;
        }

        public GroupByV2ContextBuilder withBufferGrouperMaxLoadFactor(int bufferGrouperMaxLoadFactor) {
            this.bufferGrouperMaxLoadFactor = bufferGrouperMaxLoadFactor;
            return this;
        }

        public GroupByV2ContextBuilder withMaxMergingDictionarySize(int maxMergingDictionarySize) {
            this.maxMergingDictionarySize = maxMergingDictionarySize;
            return this;
        }

        public GroupByV2ContextBuilder withMaxOnDiskStorage(int maxOnDiskStorage) {
            this.maxOnDiskStorage = maxOnDiskStorage;
            return this;
        }

        public GroupByV2ContextBuilder withSortByDimsFirst(boolean sortByDimsFirst) {
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
