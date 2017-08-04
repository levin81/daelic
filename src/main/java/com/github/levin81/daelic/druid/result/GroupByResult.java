package com.github.levin81.daelic.druid.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.levin81.daelic.druid.result.deserializer.GroupByResultDeserializer;

import java.util.List;

@JsonDeserialize(using = GroupByResultDeserializer.class)
public class GroupByResult {

    private List<GroupByRowResult> rows;

    public GroupByResult(List<GroupByRowResult> rows) {
        this.rows = rows;
    }

    public List<GroupByRowResult> getRows() {
        return rows;
    }
}
