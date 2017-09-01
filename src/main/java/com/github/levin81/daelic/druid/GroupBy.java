package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.aggregator.Aggregator;
import com.github.levin81.daelic.druid.context.Context;
import com.github.levin81.daelic.druid.datasource.DataSource;
import com.github.levin81.daelic.druid.datasource.TableDataSource;
import com.github.levin81.daelic.druid.dimension.DefaultDimension;
import com.github.levin81.daelic.druid.dimension.Dimension;
import com.github.levin81.daelic.druid.filter.Filter;
import com.github.levin81.daelic.druid.granularity.Granularity;
import com.github.levin81.daelic.druid.havingspec.HavingSpec;
import com.github.levin81.daelic.druid.limitspec.LimitSpec;
import com.github.levin81.daelic.druid.postaggregator.PostAggregator;
import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupBy {

    private final String queryType = "groupBy";

    private DataSource dataSource;
    private List<Dimension> dimensions;
    private LimitSpec limitSpec;
    private Granularity granularity;
    private Filter filter;
    private List<Aggregator> aggregations;
    private List<PostAggregator> postAggregations;
    private HavingSpec having;
    private List<Interval> intervals;
    private Context context;

    GroupBy(DataSource dataSource, List<Dimension> dimensions, LimitSpec limitSpec, Granularity granularity, Filter filter,
            List<Aggregator> aggregations, List<PostAggregator> postAggregations, HavingSpec having, List<Interval> intervals,
            Context context) {
        Properties.assertRequired(dataSource, "DataSource is a required property");
        Properties.assertRequired(dimensions, "Dimensions is a required property");
        Properties.assertRequired(granularity, "Granularity is a required property");
        Properties.assertRequired(intervals, "Intervals is a required property");

        Properties.assertRequiredDependency(postAggregations, aggregations,
                "Aggregations is a required property when PostAggregations are defined");

        this.dataSource = dataSource;
        this.dimensions = dimensions;
        this.limitSpec = limitSpec;
        this.granularity = granularity;
        this.filter = filter;
        this.aggregations = aggregations;
        this.postAggregations = postAggregations;
        this.intervals = intervals;
        this.having = having;
        this.context = context;
    }

    public String getQueryType() {
        return queryType;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public LimitSpec getLimitSpec() {
        return limitSpec;
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

    public HavingSpec getHaving() {
        return having;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public Context getContext() {
        return context;
    }

    public static GroupByBuilder builder() {
        return new GroupByBuilder();
    }

    public static class GroupByBuilder {

        private DataSource dataSource;
        private List<Dimension> dimensions;
        private LimitSpec limitSpec;
        private Granularity granularity;
        private Filter filter;
        private List<Aggregator> aggregations;
        private List<PostAggregator> postAggregations;
        private HavingSpec having;
        private List<Interval> intervals;
        private Context context;

        GroupByBuilder() {

        }

        public GroupByBuilder withDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public GroupByBuilder withDataSource(String dataSource) {
            this.dataSource = TableDataSource.builder().withName(dataSource).build();
            return this;
        }

        public GroupByBuilder withDimensions(List<Dimension> dimensions) {
            this.dimensions = new ArrayList<>(dimensions);
            return this;
        }

        public GroupByBuilder addDimension(Dimension dimension) {
            if (this.dimensions == null) {
                this.dimensions = new ArrayList<>();
            }

            this.dimensions.add(dimension);
            return this;
        }

        public GroupByBuilder addDimension(String dimension) {
            if (this.dimensions == null) {
                this.dimensions = new ArrayList<>();
            }

            this.dimensions.add(DefaultDimension.builder().withDimension(dimension).build());
            return this;
        }

        public GroupByBuilder withLimitSpec(LimitSpec limitSpec) {
            this.limitSpec = limitSpec;
            return this;
        }

        public GroupByBuilder withGranularity(Granularity granularity) {
            this.granularity = granularity;
            return this;
        }

        public GroupByBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public GroupByBuilder withAggregations(List<Aggregator> aggregations) {
            this.aggregations = new ArrayList<>(aggregations);
            return this;
        }

        public GroupByBuilder addAggregator(Aggregator aggregator) {
            if (this.aggregations == null) {
                this.aggregations = new ArrayList<>();
            }

            this.aggregations.add(aggregator);
            return this;
        }

        public GroupByBuilder withPostAggregations(List<PostAggregator> postAggregations) {
            this.postAggregations = new ArrayList<>(postAggregations);
            return this;
        }

        public GroupByBuilder addPostAggregator(PostAggregator postAggregator) {
            if (this.postAggregations == null) {
                this.postAggregations = new ArrayList<>();
            }

            this.postAggregations.add(postAggregator);
            return this;
        }

        public GroupByBuilder withHavingSpec(HavingSpec having) {
            this.having = having;
            return this;
        }

        public GroupByBuilder withIntervals(List<Interval> intervals) {
            this.intervals = new ArrayList<>(intervals);
            return this;
        }

        public GroupByBuilder addInterval(Interval interval) {
            if (this.intervals == null) {
                this.intervals = new ArrayList<>();
            }

            this.intervals.add(interval);
            return this;
        }

        public GroupByBuilder withContext(Context context) {
            this.context = context;
            return this;
        }

        public GroupBy build() {
            return new GroupBy(dataSource, dimensions, limitSpec, granularity, filter, aggregations,
                    postAggregations, having, intervals, context);
        }
    }
}
