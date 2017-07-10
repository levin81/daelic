package com.github.levin81.daelic.druid;

import com.github.levin81.daelic.druid.aggregator.Aggregator;
import com.github.levin81.daelic.druid.postaggregator.PostAggregator;
import com.github.levin81.daelic.druid.dimension.Dimension;
import com.github.levin81.daelic.druid.filter.Filter;
import lombok.ToString;

import java.util.List;

@ToString
public class GroupBy {

    private final String queryType = "topN";
    private String dataSource;
    private Dimension dimension;
    private int threshold;
    private String metric;
    private String granularity;
    private Filter filter;
    private List<Aggregator> aggregations;
    private List<PostAggregator> postAggregations;
    private List<Interval> intervals;

    GroupBy(String dataSource, Dimension dimension, int threshold, String metric, String granularity, Filter filter,
            List<Aggregator> aggregations, List<PostAggregator> postAggregations, List<Interval> intervals)
    {
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

    public static GroupByBuilder builder() {
        return new GroupByBuilder();
    }

    public static class GroupByBuilder {

        private String dataSource;
        private Dimension dimension;
        private int threshold;
        private String metric;
        private String granularity;
        private Filter filter;
        private List<Aggregator> aggregations;
        private List<PostAggregator> postAggregations;
        private List<Interval> intervals;

        public GroupByBuilder withDataSource(String dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public GroupByBuilder withDimension(Dimension dimension) {
            this.dimension = dimension;
            return this;
        }

        public GroupByBuilder withThreshold(int threshold) {
            this.threshold = threshold;
            return this;
        }

        public GroupByBuilder withMetric(String metric) {
            this.metric = metric;
            return this;
        }

        public GroupByBuilder withGranularity(String granularity) {
            this.granularity = granularity;
            return this;
        }

        public GroupByBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public GroupByBuilder withAggregations(List<Aggregator> aggregations) {
            this.aggregations = aggregations;
            return this;
        }

        public GroupByBuilder withPostAggregations(List<PostAggregator> postAggregations) {
            this.postAggregations = postAggregations;
            return this;
        }

        public GroupByBuilder withIntervals(List<Interval> intervals) {
            this.intervals = intervals;
            return this;
        }

        public GroupBy build() {
            return new GroupBy(dataSource, dimension, threshold, metric, granularity, filter, aggregations, postAggregations, intervals);
        }
    }
}
