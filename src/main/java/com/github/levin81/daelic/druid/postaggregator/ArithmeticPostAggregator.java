package com.github.levin81.daelic.druid.postaggregator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.aggregator.Aggregator;

import java.util.ArrayList;
import java.util.List;

/**
 * The arithmetic post-aggregator applies the provided function to the given fields from left to right. The fields can be aggregators or other post aggregators.
 *
 * Supported functions are +, -, *, /, and quotient.
 *
 * Note:
 *
 * / division always returns 0 if dividing by 0, regardless of the numerator.
 * quotient division behaves like regular floating point division
 * Arithmetic post-aggregators may also specify an ordering, which defines the order of resulting values when sorting results (this can be useful for topN queries
 * for instance):
 *
 * If no ordering (or null) is specified, the default floating point ordering is used.
 * numericFirst ordering always returns finite values first, followed by NaN, and infinite values last.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    ArithmeticPostAggregator(String name, String fn, List<Aggregator> fields, String ordering) {
        this.name = name;
        this.fn = fn;
        this.fields = fields;
        this.ordering = ordering;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getFn() {
        return fn;
    }

    public List<Aggregator> getFields() {
        return fields;
    }

    public String getOrdering() {
        return ordering;
    }

    public static ArithmeticPostAggregatorBuilder builder() {
        return new ArithmeticPostAggregatorBuilder();
    }

    public static class ArithmeticPostAggregatorBuilder {

        private String name;
        private String fn;
        private List<Aggregator> fields;
        private String ordering;

        ArithmeticPostAggregatorBuilder() {

        }

        public ArithmeticPostAggregatorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ArithmeticPostAggregatorBuilder withFn(String fn) {
            this.fn = fn;
            return this;
        }

        public ArithmeticPostAggregatorBuilder withFields(List<Aggregator> fields) {
            this.fields = new ArrayList<>(fields);
            return this;
        }

        public ArithmeticPostAggregatorBuilder addField(Aggregator field) {
            if (this.fields == null) {
                this.fields = new ArrayList<>();
            }

            this.fields.add(field);
            return this;
        }

        public ArithmeticPostAggregatorBuilder withOrdering(String ordering) {
            this.ordering = ordering;
            return this;
        }

        public ArithmeticPostAggregator build() {
            return new ArithmeticPostAggregator(name, fn, fields, ordering);
        }
    }
}
