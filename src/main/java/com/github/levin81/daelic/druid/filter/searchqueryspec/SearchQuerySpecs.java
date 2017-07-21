package com.github.levin81.daelic.druid.filter.searchqueryspec;

public final class SearchQuerySpecs {

    public static ContainsSearchQuerySpec.ContainsSearchQuerySpecBuilder CONTAINS() {
        return ContainsSearchQuerySpec.builder();
    }

    public static FragmentSearchQuerySpec.FragmentSearchQuerySpecBuilder FRAGMENT() {
        return FragmentSearchQuerySpec.builder();
    }

    public static InsensitiveContainsSearchQuerySpec.InsensitiveContainsSearchQuerySpecBuilder INSENSITIVE_CONTAINS() {
        return InsensitiveContainsSearchQuerySpec.builder();
    }
}
