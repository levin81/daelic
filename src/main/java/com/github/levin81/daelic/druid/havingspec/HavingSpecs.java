package com.github.levin81.daelic.druid.havingspec;

public final class HavingSpecs {

    public static AndHavingSpec.AndHavingSpecBuilder AND() {
        return AndHavingSpec.builder();
    }

    public static DimensionSelectorHavingSpec.DimensionSelectorHavingSpecBuilder DIMENSION_SELECTOR() {
        return DimensionSelectorHavingSpec.builder();
    }

    public static EqualToHavingSpec.EqualToHavingSpecBuilder EQUAL_TO() {
        return EqualToHavingSpec.builder();
    }

    public static GreaterThanHavingSpec.GreaterThanHavingSpecBuilder GREATER_THAN() {
        return GreaterThanHavingSpec.builder();
    }

    public static LessThanHavingSpec.LessThanHavingSpecBuilder LESS_THAN() {
        return LessThanHavingSpec.builder();
    }

    public static NotHavingSpec.NotHavingSpecBuilder NOT() {
        return NotHavingSpec.builder();
    }

    public static OrHavingSpec.OrHavingSpecBuilder OR() {
        return OrHavingSpec.builder();
    }

    public static QueryFilterHavingSpec.QueryFilterHavingSpecBuilder QUERY_FILTER() {
        return QueryFilterHavingSpec.builder();
    }
}
