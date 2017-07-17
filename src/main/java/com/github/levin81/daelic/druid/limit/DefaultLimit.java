package com.github.levin81.daelic.druid.limit;

import java.util.ArrayList;
import java.util.List;

public class DefaultLimit implements Limit {

    private final String type = "default";

    private int limit;
    private List<OrderByColumn> columns;

    DefaultLimit(int limit, List<OrderByColumn> columns) {
        this.limit = limit;
        this.columns = columns;
    }

    @Override
    public String getType() {
        return type;
    }

    public int getLimit() {
        return limit;
    }

    public List<OrderByColumn> getColumns() {
        return columns;
    }

    public static DefaultLimitBuilder builder() {
        return new DefaultLimitBuilder();
    }

    public static class DefaultLimitBuilder {

        private int limit;
        private List<OrderByColumn> columns;

        DefaultLimitBuilder() {

        }

        public DefaultLimitBuilder withLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public DefaultLimitBuilder withColumns(List<OrderByColumn> columns) {
            this.columns = columns;
            return this;
        }

        public DefaultLimitBuilder addColumn(OrderByColumn column) {
            if (this.columns == null) {
                this.columns = new ArrayList<>();
            }

            this.columns.add(column);
            return this;
        }

        public DefaultLimit build() {
            return new DefaultLimit(limit, columns);
        }
    }
}
