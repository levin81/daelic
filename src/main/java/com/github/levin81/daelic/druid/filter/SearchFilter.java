package com.github.levin81.daelic.druid.filter;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;
import com.github.levin81.daelic.druid.searchqueryspec.SearchQuerySpec;

public class SearchFilter implements Filter {

    private final String type = "search";

    private String dimension;
    private SearchQuerySpec query;
    private ExtractionFn extractionFn;

    SearchFilter(String dimension, SearchQuerySpec query, ExtractionFn extractionFn) {
        this.dimension = dimension;
        this.query = query;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public SearchQuerySpec getQuery() {
        return query;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static SearchFilterBuilder builder() {
        return new SearchFilterBuilder();
    }

    public static class SearchFilterBuilder {

        private String dimension;
        private SearchQuerySpec query;
        private ExtractionFn extractionFn;

        SearchFilterBuilder() {

        }

        public SearchFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public SearchFilterBuilder withQuery(SearchQuerySpec query) {
            this.query = query;
            return this;
        }

        public SearchFilterBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public SearchFilter build() {
            return new SearchFilter(dimension, query, extractionFn);
        }
    }
}
