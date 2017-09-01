package com.github.levin81.daelic.druid.context;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Period;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Context {

    private Integer timeout;
    private Integer priority;
    private String queryId;
    private Boolean useCache;
    private Boolean populateCache;
    private Boolean bySegment;
    private Boolean finalize;
    private Period chunkPeriod;

    Context(Integer timeout, Integer priority, String queryId, Boolean useCache, Boolean populateCache,
            Boolean bySegment, Boolean finalize, Period chunkPeriod) {
        this.timeout = timeout;
        this.priority = priority;
        this.queryId = queryId;
        this.useCache = useCache;
        this.populateCache = populateCache;
        this.bySegment = bySegment;
        this.finalize = finalize;
        this.chunkPeriod = chunkPeriod;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getQueryId() {
        return queryId;
    }

    public Boolean getUseCache() {
        return useCache;
    }

    public Boolean getPopulateCache() {
        return populateCache;
    }

    public Boolean getBySegment() {
        return bySegment;
    }

    public Boolean getFinalize() {
        return finalize;
    }

    public Period getChunkPeriod() {
        return chunkPeriod;
    }

    @SuppressWarnings(value = {"unchecked"})
    protected static abstract class ContextBuilder<T extends ContextBuilder<?>> {

        Integer timeout;
        Integer priority;
        String queryId;
        Boolean useCache;
        Boolean populateCache;
        Boolean bySegment;
        Boolean finalize;
        Period chunkPeriod;

        ContextBuilder() {

        }

        public T withTimeout(Integer timeout) {
            this.timeout = timeout;
            return (T) this;
        }

        public T withPriority(Integer priority) {
            this.priority = priority;
            return (T) this;
        }

        public T withQueryId(String queryId) {
            this.queryId = queryId;
            return (T) this;
        }

        public T withUseCache(Boolean useCache) {
            this.useCache = useCache;
            return (T) this;
        }

        public T withPopulateCache(Boolean populateCache) {
            this.populateCache = populateCache;
            return (T) this;
        }

        public T withBySegment(Boolean bySegment) {
            this.bySegment = bySegment;
            return (T) this;
        }

        public T withFinalize(Boolean finalize) {
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
