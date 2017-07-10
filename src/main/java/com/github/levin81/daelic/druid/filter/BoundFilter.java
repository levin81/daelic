package com.github.levin81.daelic.druid.filter;

public class BoundFilter implements Filter {

    private final String type = "bound";

    @Override
    public String getType() {
        return type;
    }
}
