package com.github.levin81.daelic.druid.result.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.levin81.daelic.druid.result.TopNResult;
import com.github.levin81.daelic.druid.result.TopNRowResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TopNResultDeserializer extends StdDeserializer<TopNResult> {

    public TopNResultDeserializer() {
        this(null);
    }

    private TopNResultDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TopNResult deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<TopNRowResult> rows =
                Arrays.asList(p.getCodec().readValue(p, TopNRowResult[].class));

        return new TopNResult(rows);
    }
}
