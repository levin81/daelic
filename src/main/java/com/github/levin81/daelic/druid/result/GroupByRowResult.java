package com.github.levin81.daelic.druid.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Map;

public class GroupByRowResult {

    private String version;
    private ZonedDateTime timestamp;
    private Map<String, Object> data;

    @JsonCreator
    public GroupByRowResult(@JsonProperty("version") String version,
                            @JsonProperty("timestamp") ZonedDateTime timestamp,
                            @JsonProperty("event") Map<String, Object> data) {
        this.version = version;
        this.timestamp = timestamp;
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
