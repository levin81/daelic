package com.github.levin81.daelic.druid.granularity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.levin81.daelic.util.Properties;

import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Period granularities are specified as arbitrary period combinations of years, months, weeks, hours, minutes and
 * seconds (e.g. P2W, P3M, PT1H30M, PT0.750S) in ISO8601 format. They support specifying a time zone which determines
 * where period boundaries start as well as the timezone of the returned timestamps. By default, years start on the
 * first of January, months start on the first of the month and weeks start on Mondays unless an origin is specified.
 *
 * Time zone is optional (defaults to UTC). Origin is optional (defaults to 1970-01-01T00:00:00 in the given time zone).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PeriodGranularity implements Granularity {

    private final String type = "period";

    private Period period;
    private ZoneId timeZone;
    private OffsetDateTime origin;

    PeriodGranularity(Period period, ZoneId timeZone, OffsetDateTime origin) {
        Properties.assertRequired(period, "Period is a required property");

        this.period = period;
        this.timeZone = timeZone;
        this.origin = origin;
    }

    @Override
    public String getType() {
        return type;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public Period getPeriod() {
        return period;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public ZoneId getTimeZone() {
        return timeZone;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public OffsetDateTime getOrigin() {
        return origin;
    }

    public static PeriodGranularityBuilder builder() {
        return new PeriodGranularityBuilder();
    }

    public static class PeriodGranularityBuilder {

        private Period period;
        private ZoneId timeZone;
        private OffsetDateTime origin;

        PeriodGranularityBuilder() {

        }

        public PeriodGranularityBuilder withPeriod(Period period) {
            this.period = period;
            return this;
        }

        public PeriodGranularityBuilder withTimeZone(String timeZone) {
            this.timeZone = ZoneId.of(timeZone);
            return this;
        }

        public PeriodGranularityBuilder withTimeZone(ZoneId timeZone) {
            this.timeZone = timeZone;
            return this;
        }

        public PeriodGranularityBuilder withOriginAndTimeZone(ZonedDateTime origin) {
            this.origin = OffsetDateTime.from(origin);
            this.timeZone = origin.getZone();
            return this;
        }

        public PeriodGranularityBuilder withOrigin(OffsetDateTime origin) {
            this.origin = origin;
            return this;
        }

        public PeriodGranularity build() {
            return new PeriodGranularity(period, timeZone, origin);
        }
    }
}
