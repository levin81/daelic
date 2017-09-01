package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.datasource.DataSource;
import com.github.levin81.daelic.druid.datasource.TableDataSource;
import com.github.levin81.daelic.druid.dimension.DefaultDimension;
import com.github.levin81.daelic.druid.dimension.Dimension;
import com.github.levin81.daelic.druid.granularity.Granularity;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Select {

    private final String type = "select";

    private DataSource dataSource;
    private Boolean descending;
    private List<Dimension> dimensions;
    private List<String> metrics;
    private Granularity granularity;
    private List<Interval> intervals;
    private PagingSpec pagingSpec;

    Select(DataSource dataSource, Boolean descending, List<Dimension> dimensions, List<String> metrics,
           Granularity granularity, List<Interval> intervals, PagingSpec pagingSpec) {
        this.dataSource = dataSource;
        this.descending = descending;
        this.dimensions = dimensions;
        this.metrics = metrics;
        this.granularity = granularity;
        this.intervals = intervals;
        this.pagingSpec = pagingSpec;
    }

    public String getType() {
        return type;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Boolean getDescending() {
        return descending;
    }

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public List<String> getMetrics() {
        return metrics;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public PagingSpec getPagingSpec() {
        return pagingSpec;
    }

    public static SelectBuilder builder() {
        return new SelectBuilder();
    }

    public static class SelectBuilder {
        private DataSource dataSource;
        private Boolean descending;
        private List<Dimension> dimensions;
        private List<String> metrics;
        private Granularity granularity;
        private List<Interval> intervals;
        private PagingSpec pagingSpec;

        SelectBuilder() {

        }

        public SelectBuilder withDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public SelectBuilder withDataSource(String dataSource) {
            this.dataSource = TableDataSource.builder().withName(dataSource).build();
            return this;
        }

        public SelectBuilder withDescending(Boolean descending) {
            this.descending = descending;
            return this;
        }

        public SelectBuilder withDimensions(List<Dimension> dimensions) {
            this.dimensions = new ArrayList<>(dimensions);
            return this;
        }

        public SelectBuilder addDimension(Dimension dimension) {
            if (this.dimensions == null) {
                this.dimensions = new ArrayList<>();
            }

            this.dimensions.add(dimension);
            return this;
        }

        public SelectBuilder addDimension(String dimension) {
            if (this.dimensions == null) {
                this.dimensions = new ArrayList<>();
            }

            this.dimensions.add(DefaultDimension.builder().withDimension(dimension).build());
            return this;
        }

        public SelectBuilder withMetrics(List<String> metrics) {
            this.metrics = new ArrayList<>(metrics);
            return this;
        }

        public SelectBuilder addMetric(String metric) {
            if (this.metrics == null) {
                this.metrics = new ArrayList<>();
            }

            this.metrics.add(metric);
            return this;
        }

        public SelectBuilder withGranularity(Granularity granularity) {
            this.granularity = granularity;
            return this;
        }

        public SelectBuilder withIntervals(List<Interval> intervals) {
            this.intervals = new ArrayList<>(intervals);
            return this;
        }

        public SelectBuilder addInterval(Interval interval) {
            if (this.intervals == null) {
                this.intervals = new ArrayList<>();
            }

            this.intervals.add(interval);
            return this;
        }

        public SelectBuilder withPagingSpec(PagingSpec pagingSpec) {
            this.pagingSpec = pagingSpec;
            return this;
        }

        public Select build() {
            return new Select(dataSource, descending, dimensions, metrics, granularity, intervals, pagingSpec);
        }
    }
}
