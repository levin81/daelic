package com.github.levin81.daelic.druid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

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

    /**
     * Returns an Interval for the last amount of hours, inclusive of the current hour. Defaults to UTC.
     * <p>
     * Example for {@code lastHoursInclusive(4)}:
     * <p>
     * <code>[ "2017-09-01T15:27:25.167Z/2017-09-01T19:27:25.167Z" ]</code>
     * @param hours
     *         positive amount of hours to subtract from now
     * @return An Interval from (now - hours) until now
     */
    public static Interval lastHoursInclusive(long hours) {
        return last(hours, ChronoUnit.HOURS);
    }

    /**
     * Returns an Interval for the last amount of hours, exclusive of the current hour. Defaults to UTC.
     * <p>
     * Example for {@code lastHoursExclusive(4)}:
     * <p>
     * <code>[ "2017-09-01T15:00Z/2017-09-01T19:00Z" ]</code>
     * @param hours
     *         positive amount of hours to subtract from now
     * @return An Interval from (now - hours) until now (truncated to hours)
     */
    public static Interval lastHoursExclusive(long hours) {
        return last(hours, ChronoUnit.HOURS, ChronoUnit.HOURS);
    }

    /**
     * Returns an Interval for the last amount of days, inclusive of the current day. Defaults to UTC.
     * <p>
     * Example for {@code lastDaysInclusive(7)}:
     * <p>
     * <code>[ "2017-08-25T19:27:25.167Z/2017-09-01T19:27:25.167Z" ]</code>
     * @param days
     *         positive amount of days to subtract from now
     * @return An Interval from (now - days) until now
     */
    public static Interval lastDaysInclusive(long days) {
        return last(days, ChronoUnit.DAYS);
    }

    /**
     * Returns an Interval for the last amount of days, exclusive of the current day. Defaults to UTC.
     * <p>
     * Example for {@code lastDaysExclusive(7)}:
     * <p>
     * <code>[ "2017-08-25T00:00Z/2017-09-01T00:00Z" ]</code>
     * @param days
     *         positive amount of days to subtract from now
     * @return An Interval from (now - days) until now (truncated to days)
     */
    public static Interval lastDaysExclusive(long days) {
        return last(days, ChronoUnit.DAYS, ChronoUnit.DAYS);
    }

    public static Interval last(long amount, TemporalUnit unit, Clock clock) {
        OffsetDateTime end = OffsetDateTime.now(clock);
        OffsetDateTime start = end.minus(amount, unit);
        return new Interval(start, end);
    }

    public static Interval last(long amount, TemporalUnit unit, TemporalUnit truncatedTo, Clock clock) {
        OffsetDateTime end = OffsetDateTime.now(clock).truncatedTo(truncatedTo);
        OffsetDateTime start = end.minus(amount, unit);
        return new Interval(start, end);
    }

    public static Interval last(long amount, TemporalUnit unit) {
        return last(amount, unit, Clock.systemUTC());
    }

    public static Interval last(long amount, TemporalUnit unit, TemporalUnit truncatedTo) {
        return last(amount, unit, truncatedTo, Clock.systemUTC());
    }

    public static Interval last(long amount, TemporalUnit unit, ZoneId zone) {
        return last(amount, unit, Clock.system(zone));
    }

    public static Interval last(long amount, TemporalUnit unit, TemporalUnit truncatedTo, ZoneId zone) {
        return last(amount, unit, truncatedTo, Clock.system(zone));
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
