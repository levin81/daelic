package com.github.levin81.daelic.druid.limitspec;

public class OrderByColumn {

    private String dimension;
    private String direction;
    private String dimensionOrder;

    OrderByColumn(String dimension, String direction, String dimensionOrder) {
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

    public String getDimensionOrder() {
        return dimensionOrder;
    }

    public static OrderByColumnBuilder builder() {
        return new OrderByColumnBuilder();
    }

    public static class OrderByColumnBuilder {

        private String dimension;
        private String direction;
        private String dimensionOrder;

        public OrderByColumnBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public OrderByColumnBuilder withDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public OrderByColumnBuilder withDimensionOrder(String dimensionOrder) {
            this.dimensionOrder = dimensionOrder;
            return this;
        }

        public OrderByColumn build() {
            return new OrderByColumn(dimension, direction, dimensionOrder);
        }
    }
}
