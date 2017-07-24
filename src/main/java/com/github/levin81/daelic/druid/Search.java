package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.context.Context;
import com.github.levin81.daelic.druid.datasource.DataSource;
import com.github.levin81.daelic.druid.datasource.TableDataSource;
import com.github.levin81.daelic.druid.dimension.DefaultDimension;
import com.github.levin81.daelic.druid.dimension.Dimension;
import com.github.levin81.daelic.druid.filter.Filter;
import com.github.levin81.daelic.druid.granularity.Granularity;
import com.github.levin81.daelic.druid.searchqueryspec.SearchQuerySpec;
import com.github.levin81.daelic.util.Properties;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Search {

    private final String queryType = "search";

    private DataSource dataSource;
    private List<Dimension> searchDimensions;
    private int limit;
    private Granularity granularity;
    private Filter filter;
    private List<Interval> intervals;
    private SearchQuerySpec query;
    private String sort;
    private Context context;

    Search(DataSource dataSource, List<Dimension> searchDimensions, int limit, Granularity granularity, Filter filter,
           List<Interval> intervals, SearchQuerySpec query, String sort, Context context) {
        Properties.assertRequired(dataSource, "DataSource is a required property");
        Properties.assertRequired(searchDimensions, "SearchDimensions is a required property");
        Properties.assertRequired(granularity, "Granularity is a required property");
        Properties.assertRequired(intervals, "Intervals is a required property");

        this.dataSource = dataSource;
        this.searchDimensions = searchDimensions;
        this.limit = limit;
        this.granularity = granularity;
        this.filter = filter;
        this.intervals = intervals;
        this.query = query;
        this.sort = sort;
        this.context = context;
    }

    public static SearchBuilder builder() {
        return new SearchBuilder();
    }

    public static class SearchBuilder {

        private DataSource dataSource;
        private List<Dimension> searchDimensions;
        private int limit;
        private Granularity granularity;
        private Filter filter;
        private List<Interval> intervals;
        private SearchQuerySpec query;
        private String sort;
        private Context context;

        SearchBuilder() {

        }

        public SearchBuilder withDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public SearchBuilder withDataSource(String dataSource) {
            this.dataSource = TableDataSource.builder().withName(dataSource).build();
            return this;
        }

        public SearchBuilder withSearchDimensions(List<Dimension> searchDimensions) {
            this.searchDimensions = searchDimensions;
            return this;
        }

        public SearchBuilder addSearchDimenson(Dimension searchDimension) {
            if (this.searchDimensions == null) {
                this.searchDimensions = new ArrayList<>();
            }

            this.searchDimensions.add(searchDimension);
            return this;
        }

        public SearchBuilder addSearchDimenson(String searchDimension) {
            if (this.searchDimensions == null) {
                this.searchDimensions = new ArrayList<>();
            }

            this.searchDimensions.add(DefaultDimension.builder().withDimension(searchDimension).build());
            return this;
        }

        public SearchBuilder withLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public SearchBuilder withGranularity(Granularity granularity) {
            this.granularity = granularity;
            return this;
        }

        public SearchBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public SearchBuilder withIntervals(List<Interval> intervals) {
            this.intervals = intervals;
            return this;
        }

        public SearchBuilder addInterval(Interval interval) {
            if (this.intervals == null) {
                this.intervals = new ArrayList<>();
            }

            this.intervals.add(interval);
            return this;
        }

        public SearchBuilder withQuery(SearchQuerySpec query) {
            this.query = query;
            return this;
        }

        public SearchBuilder withSort(String sort) {
            this.sort = sort;
            return this;
        }

        public SearchBuilder withContext(Context context) {
            this.context = context;
            return this;
        }

        public Search build() {
            return new Search(dataSource, searchDimensions, limit, granularity, filter, intervals, query,
                    sort, context);
        }
    }
}
