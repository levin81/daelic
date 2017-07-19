package com.github.levin81.daelic.druid.postaggregator;

public final class PostAggregators {

    public static ArithmeticPostAggregator.ArithmeticPostAggregatorBuilder ARITHMETIC() {
        return ArithmeticPostAggregator.builder();
    }

    public static ConstantPostAggregator.ConstantPostAggregatorBuilder CONSTANT() {
        return ConstantPostAggregator.builder();
    }

    public static DoubleGreatestPostAggregator.DoubleGreatestPostAggregatorBuilder DOUBLE_GREATEST() {
        return DoubleGreatestPostAggregator.builder();
    }

    public static DoubleLeastPostAggregator.DoubleLeastPostAggregatorBuilder DOUBLE_LEAST() {
        return DoubleLeastPostAggregator.builder();
    }

    public static FieldAccessPostAggregator.FieldAccessPostAggregatorBuilder FIELD_ACCESS() {
        return FieldAccessPostAggregator.builder();
    }

    public static HyperUniqueCardinalityPostAggregator.HyperUniqueCardinalityPostAggregatorBuilder HYPER_UNIQUE_CARDINALITY() {
        return HyperUniqueCardinalityPostAggregator.builder();
    }

    public static JavascriptPostAggregator.JavascriptPostAggregatorBuilder JAVASCRIPT() {
        return JavascriptPostAggregator.builder();
    }

    public static LongGreatestPostAggregator.LongGreatestPostAggregatorBuilder LONG_GREATEST() {
        return LongGreatestPostAggregator.builder();
    }

    public static LongLeastPostAggregator.LongLeastPostAggregatorBuilder LONG_LEAST() {
        return LongLeastPostAggregator.builder();
    }

}
