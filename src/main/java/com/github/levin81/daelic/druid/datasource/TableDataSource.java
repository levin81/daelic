package com.github.levin81.daelic.druid.datasource;

import com.github.levin81.daelic.util.Properties;

/***
 * The table data source is the most common type
 */
public class TableDataSource implements DataSource {

    private final String type = "table";

    private String name;

    TableDataSource(String name) {
        Properties.assertRequired(name, "Name is a required property");
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static TableDataSourceBuilder builder() {
        return new TableDataSourceBuilder();
    }

    public static class TableDataSourceBuilder {
        private String name;

        TableDataSourceBuilder() {

        }

        public TableDataSourceBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TableDataSource build() {
            return new TableDataSource(name);
        }
    }
}
