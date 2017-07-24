package com.github.levin81.daelic.druid.context;

public final class Contexts {

    public static TimeseriesContext.TimeseriesContextBuilder TIMESERIES() {
        return TimeseriesContext.builder();
    }

    public static TopNContext.TopNContextBuilder TOPN() {
        return TopNContext.builder();
    }

    public static GroupByV1Context.GroupByV1ContextBuilder GROUP_BY_V1() {
        return GroupByV1Context.builder();
    }

    public static GroupByV2Context.GroupByV2ContextBuilder GROUP_BY_V2() {
        return GroupByV2Context.builder();
    }
}
