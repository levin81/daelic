package com.github.levin81.daelic.druid.granularity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.levin81.daelic.util.Properties;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DurationGranularity implements Granularity {

    private final String type = "duration";

    private long duration;
    private OffsetDateTime origin;

    DurationGranularity(long duration, OffsetDateTime origin) {
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

    @JsonSerialize(using = ToStringSerializer.class)
    public OffsetDateTime getOrigin() {
        return origin;
    }

    public static DurationGranularityBuilder builder() {
        return new DurationGranularityBuilder();
    }

    public static class DurationGranularityBuilder {

        private long duration;
        private OffsetDateTime origin;

        DurationGranularityBuilder() {

        }

        public DurationGranularityBuilder withDuration(long duration) {
            this.duration = duration;
            return this;
        }

        public DurationGranularityBuilder withOrigin(ZonedDateTime origin) {
            this.origin = OffsetDateTime.from(origin);
            return this;
        }

        public DurationGranularityBuilder withOrigin(OffsetDateTime origin) {
            this.origin = origin;
            return this;
        }

        public DurationGranularity build() {
            return new DurationGranularity(duration, origin);
        }
    }
}
