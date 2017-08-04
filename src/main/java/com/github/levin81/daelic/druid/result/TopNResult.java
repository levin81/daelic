package com.github.levin81.daelic.druid.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.levin81.daelic.druid.result.deserializer.TopNResultDeserializer;

import java.util.List;

@JsonDeserialize(using = TopNResultDeserializer.class)
public class TopNResult {

    private final List<TopNRowResult> rows;

    public TopNResult(List<TopNRowResult> rows) {
        this.rows = rows;
    }

    public List<TopNRowResult> getRows() {
        return rows;
    }
}
