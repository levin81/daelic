package com.github.levin81.daelic.druid.dimension.extractionfn;

// TODO: implement this
public class TimeParsingExtractionFn implements ExtractionFn {

    private final String type = "time";

    @Override
    public String getType() {
        return type;
    }
}
