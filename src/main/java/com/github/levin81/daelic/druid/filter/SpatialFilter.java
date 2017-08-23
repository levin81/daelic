package com.github.levin81.daelic.druid.filter;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpatialFilter implements Filter {

    private final String type = "spatial";

    @Override
    public String getType() {
        return type;
    }
}
