package com.github.levin81.daelic.druid.datasource;

import com.github.levin81.daelic.druid.GroupBy;
import com.github.levin81.daelic.util.Properties;

public class QueryDataSource implements DataSource {

    private final String type = "query";

    private GroupBy query;

    QueryDataSource(GroupBy query) {
        Properties.assertRequired(query, "Query is a required property");

        this.query = query;
    }

    @Override
    public String getType() {
        return type;
    }

    public GroupBy getQuery() {
        return query;
    }

    public static QueryDataSourceBuilder builder() {
        return new QueryDataSourceBuilder();
    }

    public static class QueryDataSourceBuilder {

        private GroupBy query;

        QueryDataSourceBuilder() {

        }

        public QueryDataSourceBuilder withQuery(GroupBy query) {
            this.query = query;
            return this;
        }

        public QueryDataSource build() {
            return new QueryDataSource(query);
        }
    }
}
