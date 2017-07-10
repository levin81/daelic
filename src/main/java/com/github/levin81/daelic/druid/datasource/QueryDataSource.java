package com.github.levin81.daelic.druid.datasource;

// TODO: implement this
public class QueryDataSource implements DataSource {

    private final String type = "query";

    @Override
    public String getType() {
        return type;
    }

}
