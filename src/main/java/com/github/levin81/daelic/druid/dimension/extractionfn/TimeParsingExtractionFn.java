package com.github.levin81.daelic.druid.dimension.extractionfn;

public class TimeParsingExtractionFn implements ExtractionFn {

    private final String type = "time";

    private String timeFormat;
    private String resultFormat;

    TimeParsingExtractionFn(String timeFormat, String resultFormat) {
        this.timeFormat = timeFormat;
        this.resultFormat = resultFormat;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public String getResultFormat() {
        return resultFormat;
    }

    public static TimeParsingExtractionFnBuilder builder() {
        return new TimeParsingExtractionFnBuilder();
    }

    public static class TimeParsingExtractionFnBuilder {

        private String timeFormat;
        private String resultFormat;

        TimeParsingExtractionFnBuilder() {

        }

        public TimeParsingExtractionFnBuilder withTimeFormat(String timeFormat) {
            this.timeFormat = timeFormat;
            return this;
        }

        public TimeParsingExtractionFnBuilder withResultFormat(String resultFormat) {
            this.resultFormat = resultFormat;
            return this;
        }

        public TimeParsingExtractionFn build() {
            return new TimeParsingExtractionFn(timeFormat, resultFormat);
        }
    }
}
