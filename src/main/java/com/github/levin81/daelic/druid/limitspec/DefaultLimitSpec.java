package com.github.levin81.daelic.druid.limitspec;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultLimitSpec implements LimitSpec {

    private final String type = "default";

    private int limit;
    private List<OrderByColumn> columns;

    DefaultLimitSpec(int limit, List<OrderByColumn> columns) {
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

    public static DefaultLimitSpecBuilder builder() {
        return new DefaultLimitSpecBuilder();
    }

    public static class DefaultLimitSpecBuilder {

        private int limit;
        private List<OrderByColumn> columns;

        DefaultLimitSpecBuilder() {

        }

        public DefaultLimitSpecBuilder withLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public DefaultLimitSpecBuilder withColumns(List<OrderByColumn> columns) {
            this.columns = new ArrayList<>(columns);
            return this;
        }

        public DefaultLimitSpecBuilder addColumn(OrderByColumn column) {
            if (this.columns == null) {
                this.columns = new ArrayList<>();
            }

            this.columns.add(column);
            return this;
        }

        public DefaultLimitSpec build() {
            return new DefaultLimitSpec(limit, columns);
        }
    }
}
