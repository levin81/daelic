package com.github.levin81.daelic.druid.having;

public final class HavingSpecs {

    public static AndHaving.AndHavingBuilder AND() {
        return AndHaving.builder();
    }

    public static DimensionSelectorHaving.DimensionSelectorHavingBuilder DIMENSION_SELECTOR() {
        return DimensionSelectorHaving.builder();
    }

    public static EqualToHaving.EqualToHavingBuilder EQUAL_TO() {
        return EqualToHaving.builder();
    }

    public static GreaterThanHaving.GreaterThanHavingBuilder GREATER_THAN() {
        return GreaterThanHaving.builder();
    }

    public static LessThanHaving.LessThanHavingBuilder LESS_THAN() {
        return LessThanHaving.builder();
    }

    public static NotHaving.NotHavingBuilder NOT() {
        return NotHaving.builder();
    }

    public static OrHaving.OrHavingBuilder OR() {
        return OrHaving.builder();
    }

    public static QueryFilterHaving.QueryFilterHavingBuilder QUERY_FILTER() {
        return QueryFilterHaving.builder();
    }
}
