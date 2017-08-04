package com.github.levin81.daelic.druid.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.levin81.daelic.druid.result.deserializer.TimeseriesResultDeserializer;

import java.util.List;

@JsonDeserialize(using = TimeseriesResultDeserializer.class)
public class TimeseriesResult {

    private final List<TimeseriesRowResult> rows;

    public TimeseriesResult(List<TimeseriesRowResult> rows) {
        this.rows = rows;
    }

    public List<TimeseriesRowResult> getRows() {
        return rows;
    }
}
