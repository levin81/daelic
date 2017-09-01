package com.github.levin81.daelic.druid.limitspec;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.druid.sorting.SortingOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderByColumn {

    private String dimension;
    private String direction;
    private SortingOrder dimensionOrder;

    OrderByColumn(String dimension, String direction, SortingOrder dimensionOrder) {
        this.dimension = dimension;
        this.direction = direction;
        this.dimensionOrder = dimensionOrder;
    }

    public String getDimension() {
        return dimension;
    }

    public String getDirection() {
        return direction;
    }

    public SortingOrder getDimensionOrder() {
        return dimensionOrder;
    }

    public static OrderByColumnBuilder builder() {
        return new OrderByColumnBuilder();
    }

    public static class OrderByColumnBuilder {

        private String dimension;
        private String direction;
        private SortingOrder dimensionOrder;

        public OrderByColumnBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public OrderByColumnBuilder withDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public OrderByColumnBuilder withDimensionOrder(SortingOrder dimensionOrder) {
            this.dimensionOrder = dimensionOrder;
            return this;
        }

        public OrderByColumn build() {
            return new OrderByColumn(dimension, direction, dimensionOrder);
        }
    }
}
