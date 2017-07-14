package com.github.levin81.daelic.druid.granularity;

import com.fasterxml.jackson.annotation.JsonValue;

public class SimpleGranularity implements Granularity {

    private final String type = "simple";

    public static final SimpleGranularity NONE = new SimpleGranularity("none");
    public static final SimpleGranularity ALL = new SimpleGranularity("all");
    public static final SimpleGranularity SECOND = new SimpleGranularity("second");
    public static final SimpleGranularity MINUTE = new SimpleGranularity("minute");
    public static final SimpleGranularity FIFTEEN_MINUTE = new SimpleGranularity("fifteen_minute");
    public static final SimpleGranularity THIRTY_MINUTE = new SimpleGranularity("thirty_minute");
    public static final SimpleGranularity HOUR = new SimpleGranularity("hour");
    public static final SimpleGranularity DAY = new SimpleGranularity("day");
    public static final SimpleGranularity WEEK = new SimpleGranularity("week");
    public static final SimpleGranularity MONTH = new SimpleGranularity("month");
    public static final SimpleGranularity QUARTER = new SimpleGranularity("quarter");
    public static final SimpleGranularity YEAR = new SimpleGranularity("year");

    private final String granularity;

    private SimpleGranularity(String granularity) {
        this.granularity = granularity;
    }

    @Override
    public String getType() {
        return type;
    }

    @JsonValue
    public String getGranularity() {
        return granularity;
    }
}
