package com.github.levin81.daelic.druid.having;

import com.github.levin81.daelic.druid.filter.Filter;

public class QueryFilterHaving implements Having {

    private final String type = "filter";

    private Filter filter;

    QueryFilterHaving(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String getType() {
        return type;
    }

    public Filter getFilter() {
        return filter;
    }

    public static QueryFilterHavingBuilder builder() {
        return new QueryFilterHavingBuilder();
    }

    public static class QueryFilterHavingBuilder {

        private Filter filter;

        QueryFilterHavingBuilder() {

        }

        public QueryFilterHavingBuilder withFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public QueryFilterHaving build() {
            return new QueryFilterHaving(filter);
        }
    }
}
