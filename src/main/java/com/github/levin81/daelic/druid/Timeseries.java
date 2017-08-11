package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.aggregator.Aggregator;
import com.github.levin81.daelic.druid.context.Context;
import com.github.levin81.daelic.druid.datasource.DataSource;
import com.github.levin81.daelic.druid.datasource.TableDataSource;
import com.github.levin81.daelic.druid.filter.Filter;
import com.github.levin81.daelic.druid.granularity.Granularity;
import com.github.levin81.daelic.druid.postaggregator.PostAggregator;
import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Timeseries {

    private final String queryType = "timeseries";

    private DataSource dataSource;
    private Granularity granularity;
    private Filter filter;
    private List<Aggregator> aggregations;
    private List<PostAggregator> postAggregations;
    private List<Interval> intervals;
    private Context context;
    private boolean descending;

    Timeseries(DataSource dataSource, Granularity granularity, Filter filter, List<Aggregator> aggregations,
               List<PostAggregator> postAggregations, List<Interval> intervals, Context context, boolean descending) {
        Properties.assertRequired(dataSource, "DataSource is a required property");
        Properties.assertRequired(granularity, "Granularity is a required property");
        Properties.assertRequired(intervals, "Intervals is a required property");

        Properties.assertRequiredDependency(postAggregations, aggregations,
                "Aggregations is a required property when PostAggregations are defined");

        this.dataSource = dataSource;
        this.granularity = granularity;
        this.filter = filter;
        this.aggregations = aggregations;
        this.postAggregations = postAggregations;
        this.intervals = intervals;
        this.context = context;
        this.descending = descending;
    }

    public String getQueryType() {
        return queryType;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public Filter getFilter() {
        return filter;
    }

    public List<Aggregator> getAggregations() {
        return aggregations;
    }

    public List<PostAggregator> getPostAggregations() {
        return postAggregations;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public Context getContext() {
        return context;
    }

    public boolean isDescending() {
        return descending;
    }

    public static TimeseriesBuilder builder() {
        return new TimeseriesBuilder();
    }

    public static class TimeseriesBuilder {

        private DataSource dataSource;
        private Granularity granularity;
        private Filter filter;
        private List<Aggregator> aggregations;
        private List<PostAggregator> postAggregations;
        private List<Interval> intervals;
        private Context context;
        private boolean descending;

        TimeseriesBuilder() {

        }

        public TimeseriesBuilder withDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public TimeseriesBuilder withDataSource(String dataSource) {
            this.dataSource = TableDataSource.builder().withName(dataSource).build();
            return this;
        }

        public TimeseriesBuilder withGranularity(Granularity granularity) {
            this.granularity = granularity;
            return this;
        }

        public TimeseriesBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public TimeseriesBuilder withAggregations(List<Aggregator> aggregations) {
            this.aggregations = aggregations;
            return this;
        }

        public TimeseriesBuilder addAggregator(Aggregator aggregator) {
            if (this.aggregations == null) {
                this.aggregations = new ArrayList<>();
            }

            this.aggregations.add(aggregator);
            return this;
        }

        public TimeseriesBuilder withPostAggregations(List<PostAggregator> postAggregations) {
            this.postAggregations = postAggregations;
            return this;
        }

        public TimeseriesBuilder addPostAggregator(PostAggregator postAggregator) {
            if (this.postAggregations == null) {
                this.postAggregations = new ArrayList<>();
            }

            this.postAggregations.add(postAggregator);
            return this;
        }

        public TimeseriesBuilder withIntervals(List<Interval> intervals) {
            this.intervals = intervals;
            return this;
        }

        public TimeseriesBuilder addInterval(Interval interval) {
            if (this.intervals == null) {
                this.intervals = new ArrayList<>();
            }

            this.intervals.add(interval);
            return this;
        }

        public TimeseriesBuilder withContext(Context context) {
            this.context = context;
            return this;
        }

        public TimeseriesBuilder withDescending(boolean descending) {
            this.descending = descending;
            return this;
        }

        public Timeseries build() {
            return new Timeseries(dataSource, granularity, filter, aggregations, postAggregations, intervals,
                    context, descending);
        }
    }
}
