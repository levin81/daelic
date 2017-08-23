package com.github.levin81.daelic.druid.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.ZonedDateTime;
import java.util.Map;

public class GroupByRowResult {

    private final String version;
    private final ZonedDateTime timestamp;
    private final Map<String, Object> data;

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

    @JsonSerialize(using = ToStringSerializer.class)
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
