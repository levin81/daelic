package com.github.levin81.daelic.druid.filter;

public class SpatialFilter implements Filter {

    private final String type = "spatial";

    @Override
    public String getType() {
        return type;
    }
}
