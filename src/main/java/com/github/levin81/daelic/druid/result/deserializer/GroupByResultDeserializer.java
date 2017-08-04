package com.github.levin81.daelic.druid.result.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.levin81.daelic.druid.result.GroupByResult;
import com.github.levin81.daelic.druid.result.GroupByRowResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GroupByResultDeserializer extends StdDeserializer<GroupByResult> {

    public GroupByResultDeserializer() {
        this(null);
    }

    private GroupByResultDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public GroupByResult deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<GroupByRowResult> rows =
                Arrays.asList(p.getCodec().readValue(p, GroupByRowResult[].class));

        return new GroupByResult(rows);
    }
}
