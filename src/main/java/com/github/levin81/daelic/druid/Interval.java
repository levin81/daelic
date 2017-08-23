package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Interval {

    private OffsetDateTime start;
    private OffsetDateTime end;

    Interval(OffsetDateTime start, OffsetDateTime end) {
        this.start = start;
        this.end = end;
    }

    @JsonValue
    @Override
    public String toString() {
        return start.toString() + "/" + end.toString();
    }

    public static IntervalBuilder builder() {
        return new IntervalBuilder();
    }

    public static class IntervalBuilder {

        private OffsetDateTime start;
        private OffsetDateTime end;

        IntervalBuilder() {

        }

        public IntervalBuilder withStart(ZonedDateTime start) {
            this.start = OffsetDateTime.from(start);
            return this;
        }

        public IntervalBuilder withEnd(ZonedDateTime end) {
            this.end = OffsetDateTime.from(end);
            return this;
        }

        public IntervalBuilder withStart(OffsetDateTime start) {
            this.start = start;
            return this;
        }

        public IntervalBuilder withEnd(OffsetDateTime end) {
            this.end = end;
            return this;
        }

        public Interval build() {
            return new Interval(start, end);
        }
    }
}
