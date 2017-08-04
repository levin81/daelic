package com.github.levin81.daelic.druid.result.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.levin81.daelic.druid.result.TimeseriesResult;
import com.github.levin81.daelic.druid.result.TimeseriesRowResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TimeseriesResultDeserializer extends StdDeserializer<TimeseriesResult> {

    public TimeseriesResultDeserializer() {
        this(null);
    }

    private TimeseriesResultDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TimeseriesResult deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<TimeseriesRowResult> rows =
                Arrays.asList(p.getCodec().readValue(p, TimeseriesRowResult[].class));

        return new TimeseriesResult(rows);
    }
}
