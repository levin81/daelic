package com.github.levin81.daelic.druid.datasource;

import com.github.levin81.daelic.util.Properties;

import java.util.ArrayList;
import java.util.List;

/***
 * This data source unions two or more table data sources.
 */
public class UnionDataSource implements DataSource {

    private final String type = "union";

    private List<DataSource> dataSources;

    UnionDataSource(List<DataSource> dataSources) {
        Properties.assertRequired(dataSources, "DataSources is a required property");

        this.dataSources = dataSources;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<DataSource> getDataSources() {
        return dataSources;
    }

    public static UnionDataSourceBuilder builder() {
        return new UnionDataSourceBuilder();
    }

    public static class UnionDataSourceBuilder {
        private List<DataSource> dataSources;

        UnionDataSourceBuilder() {

        }

        public UnionDataSourceBuilder withDataSources(List<DataSource> dataSources) {
            this.dataSources = dataSources;
            return this;
        }

        public UnionDataSourceBuilder addDataSource(DataSource dataSource) {
            if (this.dataSources == null) {
                this.dataSources = new ArrayList<>();
            }

            this.dataSources.add(dataSource);
            return this;
        }

        public UnionDataSource build() {
            return new UnionDataSource(dataSources);
        }
    }

}
