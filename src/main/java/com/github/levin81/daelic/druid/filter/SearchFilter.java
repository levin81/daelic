package com.github.levin81.daelic.druid.filter;

public class SearchFilter implements Filter {

    private final String type = "search";

    @Override
    public String getType() {
        return type;
    }
}
