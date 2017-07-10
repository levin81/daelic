package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.aggregator.Aggregator;
import com.github.levin81.daelic.druid.datasource.DataSource;
import com.github.levin81.daelic.druid.dimension.DefaultDimension;
import com.github.levin81.daelic.druid.datasource.TableDataSource;
import com.github.levin81.daelic.druid.dimension.Dimension;
import com.github.levin81.daelic.druid.filter.Filter;
import com.github.levin81.daelic.druid.granularity.Granularity;
import com.github.levin81.daelic.druid.metric.NumericTopNMetric;
import com.github.levin81.daelic.druid.metric.TopNMetric;
import com.github.levin81.daelic.druid.postaggregator.PostAggregator;
import com.github.levin81.daelic.util.Properties;
import lombok.Getter;

import java.util.List;

@Getter
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

    TopN(DataSource dataSource, Dimension dimension, int threshold, TopNMetric metric, Granularity granularity, Filter filter,
         List<Aggregator> aggregations, List<PostAggregator> postAggregations, List<Interval> intervals) {
        Properties.assertRequired(dataSource, "DataSource is a required property");
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(metric, "SortingOrder is a required property");
        Properties.assertRequired(granularity, "Granularity is a required property");
        Properties.assertRequired(intervals, "Intervals is a required property");

        Properties.assertRequiredDependency(postAggregations, aggregations,
                "Aggregations is a required property when PostAggregations are defined");

        Properties.assertValid(threshold, t -> t > 0,
                "Threshold property must be greater than zero");

        this.dataSource = dataSource;
        this.dimension = dimension;
        this.threshold = threshold;
        this.metric = metric;
        this.granularity = granularity;
        this.filter = filter;
        this.aggregations = aggregations;
        this.postAggregations = postAggregations;
        this.intervals = intervals;
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
            this.aggregations = aggregations;
            return this;
        }

        public TopNBuilder withPostAggregations(List<PostAggregator> postAggregations) {
            this.postAggregations = postAggregations;
            return this;
        }

        public TopNBuilder withIntervals(List<Interval> intervals) {
            this.intervals = intervals;
            return this;
        }

        public TopN build() {
            return new TopN(dataSource, dimension, threshold, metric, granularity, filter, aggregations,
                    postAggregations, intervals);
        }
    }
}
