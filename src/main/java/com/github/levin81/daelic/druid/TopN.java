package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.aggregator.Aggregator;
import com.github.levin81.daelic.druid.context.Context;
import com.github.levin81.daelic.druid.datasource.DataSource;
import com.github.levin81.daelic.druid.datasource.QueryDataSource;
import com.github.levin81.daelic.druid.datasource.TableDataSource;
import com.github.levin81.daelic.druid.dimension.DefaultDimension;
import com.github.levin81.daelic.druid.dimension.Dimension;
import com.github.levin81.daelic.druid.filter.Filter;
import com.github.levin81.daelic.druid.granularity.Granularity;
import com.github.levin81.daelic.druid.metric.NumericTopNMetric;
import com.github.levin81.daelic.druid.metric.TopNMetric;
import com.github.levin81.daelic.druid.postaggregator.PostAggregator;
import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopN {

    private final String queryType = "topN";
    private DataSource dataSource;
    private Dimension dimension;
    private int threshold;
    private TopNMetric metric;
    private Granularity granularity;
    private Filter filter;
    private List<Aggregator> aggregations;
    private List<PostAggregator> postAggregations;
    private List<Interval> intervals;
    private Context context;

    TopN(DataSource dataSource, Dimension dimension, int threshold, TopNMetric metric, Granularity granularity,
         Filter filter, List<Aggregator> aggregations, List<PostAggregator> postAggregations, List<Interval> intervals,
         Context context) {
        Properties.assertRequired(dataSource, "DataSource is a required property");
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(metric, "Metric is a required property");
        Properties.assertRequired(granularity, "Granularity is a required property");
        Properties.assertRequired(intervals, "Intervals is a required property");

        Properties.assertRequiredDependency(postAggregations, aggregations,
                "Aggregations is a required property when PostAggregations are defined");

        Properties.assertValid(threshold, t -> t > 0,
                "Threshold property must be greater than zero");

        Properties.assertValid(dataSource, d -> !(d instanceof QueryDataSource),
                "QueryDataSource only supported by GroupBy query");

        this.dataSource = dataSource;
        this.dimension = dimension;
        this.threshold = threshold;
        this.metric = metric;
        this.granularity = granularity;
        this.filter = filter;
        this.aggregations = aggregations;
        this.postAggregations = postAggregations;
        this.intervals = intervals;
        this.context = context;
    }

    public String getQueryType() {
        return queryType;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public int getThreshold() {
        return threshold;
    }

    public TopNMetric getMetric() {
        return metric;
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

    public static TopNBuilder builder() {
        return new TopNBuilder();
    }

    public static class TopNBuilder {

        private DataSource dataSource;
        private Dimension dimension;
        private int threshold;
        private TopNMetric metric;
        private Granularity granularity;
        private Filter filter;
        private List<Aggregator> aggregations;
        private List<PostAggregator> postAggregations;
        private List<Interval> intervals;
        private Context context;

        TopNBuilder() {

        }

        public TopNBuilder withDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public TopNBuilder withDataSource(String dataSource) {
            this.dataSource = TableDataSource.builder().withName(dataSource).build();
            return this;
        }

        public TopNBuilder withDimension(Dimension dimension) {
            this.dimension = dimension;
            return this;
        }

        public TopNBuilder withDimension(String dimension) {
            this.dimension = DefaultDimension.builder().withDimension(dimension).build();
            return this;
        }

        public TopNBuilder withThreshold(int threshold) {
            this.threshold = threshold;
            return this;
        }

        public TopNBuilder withMetric(TopNMetric metric) {
            this.metric = metric;
            return this;
        }

        public TopNBuilder withMetric(String metric) {
            this.metric = NumericTopNMetric.builder().withMetric(metric).build();
            return this;
        }

        public TopNBuilder withGranularity(Granularity granularity) {
            this.granularity = granularity;
            return this;
        }

        public TopNBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public TopNBuilder withAggregations(List<Aggregator> aggregations) {
            this.aggregations = new ArrayList<>(aggregations);
            return this;
        }

        public TopNBuilder addAggregator(Aggregator aggregator) {
            if (this.aggregations == null) {
                this.aggregations = new ArrayList<>();
            }

            this.aggregations.add(aggregator);
            return this;
        }

        public TopNBuilder withPostAggregations(List<PostAggregator> postAggregations) {
            this.postAggregations = new ArrayList<>(postAggregations);
            return this;
        }

        public TopNBuilder addPostAggregator(PostAggregator postAggregator) {
            if (this.postAggregations == null) {
                this.postAggregations = new ArrayList<>();
            }

            this.postAggregations.add(postAggregator);
            return this;
        }

        public TopNBuilder withIntervals(List<Interval> intervals) {
            this.intervals = new ArrayList<>(intervals);
            return this;
        }

        public TopNBuilder addInterval(Interval interval) {
            if (this.intervals == null) {
                this.intervals = new ArrayList<>();
            }

            this.intervals.add(interval);
            return this;
        }

        public TopNBuilder withContext(Context context) {
            this.context = context;
            return this;
        }

        public TopN build() {
            return new TopN(dataSource, dimension, threshold, metric, granularity, filter, aggregations,
                    postAggregations, intervals, context);
        }
    }
}
