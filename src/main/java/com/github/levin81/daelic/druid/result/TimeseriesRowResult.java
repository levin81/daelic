package com.github.levin81.daelic.druid.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Map;

public class TimeseriesRowResult {

    private final ZonedDateTime timestamp;
    private final Map<String, Object> data;

    @JsonCreator
    public TimeseriesRowResult(@JsonProperty("timestamp") ZonedDateTime timestamp,
                               @JsonProperty("result") Map<String, Object> data) {
        this.timestamp = timestamp;
        this.data = data;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
