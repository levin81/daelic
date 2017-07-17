package com.github.levin81.daelic.druid.aggregator;

public final class Aggregators {

    public static CardinalityAggregator.CardinalityAggregatorBuilder CARDINALITY() {
        return CardinalityAggregator.builder();
    }

    public static CountAggregator.CountAggregatorBuilder COUNT() {
        return CountAggregator.builder();
    }

    public static DoubleFirstAggregator.DoubleFirstAggregatorBuilder DOUBLE_FIRST() {
        return DoubleFirstAggregator.builder();
    }

    public static DoubleLastAggregator.DoubleLastAggregatorBuilder DOUBLE_LAST() {
        return DoubleLastAggregator.builder();
    }

    public static DoubleMaxAggregator.DoubleMaxAggregatorBuilder DOUBLE_MAX() {
        return DoubleMaxAggregator.builder();
    }

    public static DoubleMinAggregator.DoubleMinAggregatorBuilder DOUBLE_MIN() {
        return DoubleMinAggregator.builder();
    }

    public static DoubleSumAggregator.DoubleSumAggregatorBuilder DOUBLE_SUM() {
        return DoubleSumAggregator.builder();
    }

    public static FilteredAggregator.FilteredAggregatorBuilder FILTERED() {
        return FilteredAggregator.builder();
    }

    public static HyperUniqueAggregator.HyperUniqueAggregatorBuilder HYPER_UNIQUE() {
        return HyperUniqueAggregator.builder();
    }

    public static LongFirstAggregator.LongFirstAggregatorBuilder LONG_FIRST() {
        return LongFirstAggregator.builder();
    }

    public static LongLastAggregator.LongLastAggregatorBuilder LONG_LAST() {
        return LongLastAggregator.builder();
    }

    public static LongMaxAggregator.LongMaxAggregatorBuilder LONG_MAX() {
        return LongMaxAggregator.builder();
    }

    public static LongMinAggregator.LongMinAggregatorBuilder LONG_MIN() {
        return LongMinAggregator.builder();
    }

    public static LongSumAggregator.LongSumAggregatorBuilder LONG_SUM() {
        return LongSumAggregator.builder();
    }

}
