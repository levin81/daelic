package com.github.levin81.daelic.druid.havingspec;

import com.github.levin81.daelic.druid.filter.Filter;

public class QueryFilterHavingSpec implements HavingSpec {

    private final String type = "filter";

    private Filter filter;

    QueryFilterHavingSpec(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String getType() {
        return type;
    }

    public Filter getFilter() {
        return filter;
    }

    public static QueryFilterHavingSpecBuilder builder() {
        return new QueryFilterHavingSpecBuilder();
    }

    public static class QueryFilterHavingSpecBuilder {

        private Filter filter;

        QueryFilterHavingSpecBuilder() {

        }

        public QueryFilterHavingSpecBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public QueryFilterHavingSpec build() {
            return new QueryFilterHavingSpec(filter);
        }
    }
}
