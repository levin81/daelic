package com.github.levin81.daelic.druid.postaggregator;

import com.github.levin81.daelic.druid.aggregator.Aggregator;

import java.util.List;

/***
 * The arithmetic post-aggregator applies the provided function to the given fields from left to right. The fields can be aggregators or other post aggregators.
 *
 * Supported functions are +, -, *, /, and quotient.
 *
 * Note:
 *
 * / division always returns 0 if dividing by 0, regardless of the numerator.
 * quotient division behaves like regular floating point division
 * Arithmetic post-aggregators may also specify an ordering, which defines the order of resulting values when sorting results (this can be useful for topN queries for instance):
 *
 * If no ordering (or null) is specified, the default floating point ordering is used.
 * numericFirst ordering always returns finite values first, followed by NaN, and infinite values last.
 */
public class ArithmeticPostAggregator implements PostAggregator {

    public final static String ADDITION_FN = "+";
    public final static String SUBTRACTION_FN = "-";
    public final static String MULTIPLICATION_FN = "*";
    public final static String DIVISON_FN = "/";
    public final static String QUOTIENT_FN = "quotient";

    private final String type = "arithmetic";

    private String name;
    private String fn;
    private List<Aggregator> fields;
    private String ordering;

    @Override
    public String getType() {
        return type;
    }
}
