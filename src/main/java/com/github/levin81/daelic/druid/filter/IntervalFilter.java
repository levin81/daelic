package com.github.levin81.daelic.druid.filter;

public class IntervalFilter implements Filter {

    private final String type = "interval";

    @Override
    public String getType() {
        return type;
    }
}
