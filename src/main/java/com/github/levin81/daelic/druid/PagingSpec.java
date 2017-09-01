package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagingSpec {
    private Map<String, Integer> pagingIdentifiers;
    private int threshold;
    private Boolean fromNext;

    PagingSpec(Map<String, Integer> pagingIdentifiers, int threshold, Boolean fromNext) {
        this.pagingIdentifiers = pagingIdentifiers;
        this.threshold = threshold;
        this.fromNext = fromNext;
    }

    public Map<String, Integer> getPagingIdentifiers() {
        return pagingIdentifiers;
    }

    public int getThreshold() {
        return threshold;
    }

    public Boolean getFromNext() {
        return fromNext;
    }

    public static PagingSpecBuilder builder() {
        return new PagingSpecBuilder();
    }

    public static class PagingSpecBuilder {
        private Map<String, Integer> pagingIdentifiers;
        private int threshold;
        private Boolean fromNext;

        PagingSpecBuilder() {

        }

        public PagingSpecBuilder withPagingIdentifiers(Map<String, Integer> pagingIdentifiers) {
            this.pagingIdentifiers = new HashMap<>(pagingIdentifiers);
            return this;
        }

        public PagingSpecBuilder addPagingIdentifier(String segmentId, int offset) {
            if (this.pagingIdentifiers == null) {
                this.pagingIdentifiers = new HashMap<>();
            }

            this.pagingIdentifiers.put(segmentId, offset);
            return this;
        }

        public PagingSpecBuilder withThreshold(int threshold) {
            this.threshold = threshold;
            return this;
        }

        public PagingSpecBuilder withFromNext(Boolean fromNext) {
            this.fromNext = fromNext;
            return this;
        }

        public PagingSpec build() {
            return new PagingSpec(pagingIdentifiers, threshold, fromNext);
        }
    }
}
