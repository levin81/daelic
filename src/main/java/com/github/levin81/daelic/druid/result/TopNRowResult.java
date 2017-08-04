package com.github.levin81.daelic.druid.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class TopNRowResult {

    private final ZonedDateTime timestamp;
    private final List<Map<String, Object>> data;

    @JsonCreator
    public TopNRowResult(@JsonProperty("timestamp") ZonedDateTime timestamp,
                         @JsonProperty("result") List<Map<String, Object>> data) {
        this.timestamp = timestamp;
        this.data = data;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }
}
