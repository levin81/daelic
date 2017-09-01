package com.github.levin81.daelic.druid;

public final class Queries {

    public static GroupBy.GroupByBuilder GROUP_BY() {
        return GroupBy.builder();
    }

    public static Search.SearchBuilder SEARCH() {
        return Search.builder();
    }

    public static Select.SelectBuilder SELECT() {
        return Select.builder();
    }

    public static Timeseries.TimeseriesBuilder TIMESERIES() {
        return Timeseries.builder();
    }

    public static TopN.TopNBuilder TOPN() {
        return TopN.builder();
    }
}
