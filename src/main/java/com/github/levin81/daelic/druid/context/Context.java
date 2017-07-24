package com.github.levin81.daelic.druid.context;

import java.time.Period;

public abstract class Context {

    private int timeout;
    private int priority;
    private String queryId;
    private boolean useCache;
    private boolean populateCache;
    private boolean bySegment;
    private boolean finalize;
    private Period chunkPeriod;

    Context(int timeout, int priority, String queryId, boolean useCache, boolean populateCache,
            boolean bySegment, boolean finalize, Period chunkPeriod) {
        this.timeout = timeout;
        this.priority = priority;
        this.queryId = queryId;
        this.useCache = useCache;
        this.populateCache = populateCache;
        this.bySegment = bySegment;
        this.finalize = finalize;
        this.chunkPeriod = chunkPeriod;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getPriority() {
        return priority;
    }

    public String getQueryId() {
        return queryId;
    }

    public boolean isUseCache() {
        return useCache;
    }

    public boolean isPopulateCache() {
        return populateCache;
    }

    public boolean isBySegment() {
        return bySegment;
    }

    public boolean isFinalize() {
        return finalize;
    }

    public Period getChunkPeriod() {
        return chunkPeriod;
    }

    @SuppressWarnings(value = {"unchecked"})
    protected static abstract class ContextBuilder<T extends ContextBuilder<?>> {

        int timeout;
        int priority;
        String queryId;
        boolean useCache;
        boolean populateCache;
        boolean bySegment;
        boolean finalize;
        Period chunkPeriod;

        ContextBuilder() {

        }

        public T withTimeout(int timeout) {
            this.timeout = timeout;
            return (T) this;
        }

        public T withPriority(int priority) {
            this.priority = priority;
            return (T) this;
        }

        public T withQueryId(String queryId) {
            this.queryId = queryId;
            return (T) this;
        }

        public T withUseCache(boolean useCache) {
            this.useCache = useCache;
            return (T) this;
        }

        public T withPopulateCache(boolean populateCache) {
            this.populateCache = populateCache;
            return (T) this;
        }

        public T withBySegment(boolean bySegment) {
            this.bySegment = bySegment;
            return (T) this;
        }

        public T withFinalize(boolean finalize) {
            this.finalize = finalize;
            return (T) this;
        }

        public T withChunkPeriod(Period chunkPeriod) {
            this.chunkPeriod = chunkPeriod;
            return (T) this;
        }

        public T withChunkPeriod(String chunkPeriod) {
            this.chunkPeriod = Period.parse(chunkPeriod);
            return (T) this;
        }
    }
}
