package com.github.levin81.daelic.druid.granularity;

public final class Granularities {

    public static DurationGranularity.DurationGranularityBuilder DURATION() {
        return DurationGranularity.builder();
    }

    public static PeriodGranularity.PeriodGranularityBuilder PERIOD() {
        return PeriodGranularity.builder();
    }

    public static SimpleGranularity SIMPLE_NONE() {
        return SimpleGranularity.NONE;
    }

    public static SimpleGranularity SIMPLE_ALL() {
        return SimpleGranularity.ALL;
    }

    public static SimpleGranularity SIMPLE_SECOND() {
        return SimpleGranularity.SECOND;
    }

    public static SimpleGranularity SIMPLE_MINUTE() {
        return SimpleGranularity.MINUTE;
    }

    public static SimpleGranularity SIMPLE_FIFTEEN_MINUTE() {
        return SimpleGranularity.FIFTEEN_MINUTE;
    }

    public static SimpleGranularity SIMPLE_THIRTY_MINUTE() {
        return SimpleGranularity.THIRTY_MINUTE;
    }

    public static SimpleGranularity SIMPLE_HOUR() {
        return SimpleGranularity.HOUR;
    }

    public static SimpleGranularity SIMPLE_DAY() {
        return SimpleGranularity.DAY;
    }

    public static SimpleGranularity SIMPLE_WEEK() {
        return SimpleGranularity.WEEK;
    }

    public static SimpleGranularity SIMPLE_MONTH() {
        return SimpleGranularity.MONTH;
    }

    public static SimpleGranularity SIMPLE_QUARTER() {
        return SimpleGranularity.QUARTER;
    }

    public static SimpleGranularity SIMPLE_YEAR() {
        return SimpleGranularity.YEAR;
    }
}
