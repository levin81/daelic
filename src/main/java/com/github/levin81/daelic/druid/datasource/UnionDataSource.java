package com.github.levin81.daelic.druid.datasource;

import com.github.levin81.daelic.util.Properties;

import java.util.List;

/***
 * This data source unions two or more table data sources.
 */
public class UnionDataSource implements DataSource {

    private final String type = "union";

    private List<String> dataSources;

    UnionDataSource(List<String> dataSources) {
        Properties.assertRequired(dataSources, "DataSources is a required property");
        this.dataSources = dataSources;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<String> getDataSources() {
        return dataSources;
    }

    public static UnionDataSourceBuilder builder() {
        return new UnionDataSourceBuilder();
    }

    public static class UnionDataSourceBuilder {
        private List<String> dataSources;

        UnionDataSourceBuilder() {

        }

        public UnionDataSourceBuilder withDataSources(List<String> dataSources) {
            this.dataSources = dataSources;
            return this;
        }

        public UnionDataSource build() {
            return new UnionDataSource(dataSources);
        }
    }

}
