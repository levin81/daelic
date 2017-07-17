package com.github.levin81.daelic.druid.datasource;

public final class DataSources {

    public static QueryDataSource.QueryDataSourceBuilder QUERY() {
        return QueryDataSource.builder();
    }

    public static TableDataSource.TableDataSourceBuilder TABLE() {
        return TableDataSource.builder();
    }

    public static UnionDataSource.UnionDataSourceBuilder UNION() {
        return UnionDataSource.builder();
    }
}
