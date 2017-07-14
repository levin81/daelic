package com.github.levin81.daelic.druid.aggregator;

import com.github.levin81.daelic.druid.filter.Filter;
import com.github.levin81.daelic.util.Properties;

/**
 * A filtered aggregator wraps any given aggregator, but only aggregates the values for which the given dimension
 * filter matches.
 *
 * This makes it possible to compute the results of a filtered and an unfiltered aggregation simultaneously, without
 * having to issue multiple queries, and use both results as part of post-aggregations.
 *
 * Note: If only the filtered results are required, consider putting the filter on the query itself, which will be
 * much faster since it does not require scanning all the data.
 */
public class FilteredAggregator implements Aggregator {

    private final String type = "filtered";

    private Filter filter;
    private Aggregator aggregator;

    FilteredAggregator(Filter filter, Aggregator aggregator) {
        Properties.assertRequired(filter, "Filter is a required property");
        Properties.assertRequired(aggregator, "Aggregator is a required property");

        this.filter = filter;
        this.aggregator = aggregator;
    }

    @Override
    public String getType() {
        return type;
    }

    public Filter getFilter() {
        return filter;
    }

    public Aggregator getAggregator() {
        return aggregator;
    }

    public static FilteredAggregatorBuilder builder() {
        return new FilteredAggregatorBuilder();
    }

    public static class FilteredAggregatorBuilder {

        private Filter filter;
        private Aggregator aggregator;

        FilteredAggregatorBuilder() {

        }

        public FilteredAggregatorBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public FilteredAggregatorBuilder withAggregator(Aggregator aggregator) {
            this.aggregator = aggregator;
            return this;
        }

        public FilteredAggregator build() {
            return new FilteredAggregator(filter, aggregator);
        }
    }
}
