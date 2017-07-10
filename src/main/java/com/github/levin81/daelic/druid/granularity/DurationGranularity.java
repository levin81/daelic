package com.github.levin81.daelic.druid.granularity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.levin81.daelic.util.Properties;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DurationGranularity implements Granularity {

    private final String type = "duration";
    private long duration;
    private ZonedDateTime origin;

    DurationGranularity(long duration, ZonedDateTime origin) {
        Properties.assertRequired(duration, "Duration is a required property");

        this.duration = duration;
        this.origin = origin;
    }

    @Override
    public String getType() {
        return type;
    }

    public long getDuration() {
        return duration;
    }

    public ZonedDateTime getOrigin() {
        return origin;
    }

    public static DurationGranularityBuilder builder() {
        return new DurationGranularityBuilder();
    }

    public static class DurationGranularityBuilder {

        private long duration;
        private ZonedDateTime origin;

        DurationGranularityBuilder() {

        }

        public DurationGranularityBuilder withDuration(long duration) {
            this.duration = duration;
            return this;
        }

        public DurationGranularityBuilder withOrigin(ZonedDateTime origin) {
            this.origin = origin;
            return this;
        }

        public DurationGranularity build() {
            return new DurationGranularity(duration, origin);
        }
    }
}
