package com.github.levin81.daelic.druid.sorting;

public class SearchSortSpec {
    private SortingOrder type;

    public SearchSortSpec(SortingOrder type) {
        this.type = type;
    }

    public SortingOrder getType() {
        return type;
    }
}
