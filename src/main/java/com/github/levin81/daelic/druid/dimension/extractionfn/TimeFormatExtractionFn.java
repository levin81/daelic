package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.levin81.daelic.druid.granularity.Granularity;

import java.time.ZoneId;
import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeFormatExtractionFn implements ExtractionFn {

    private final String type = "timeFormat";

    private String format;
    private ZoneId timeZone;
    private Locale locale;
    private Granularity granularity;
    private boolean asMillis;

    TimeFormatExtractionFn(String format, ZoneId timeZone, Locale locale, Granularity granularity, boolean asMillis) {
        this.format = format;
        this.timeZone = timeZone;
        this.locale = locale;
        this.granularity = granularity;
        this.asMillis = asMillis;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getFormat() {
        return format;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public ZoneId getTimeZone() {
        return timeZone;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public Locale getLocale() {
        return locale;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public boolean isAsMillis() {
        return asMillis;
    }

    public static TimeFormatExtractionFnBuilder builder() {
        return new TimeFormatExtractionFnBuilder();
    }

    public static class TimeFormatExtractionFnBuilder {

        private String format;
        private ZoneId timeZone;
        private Locale locale;
        private Granularity granularity;
        private boolean asMillis;

        TimeFormatExtractionFnBuilder() {

        }

        public TimeFormatExtractionFnBuilder withFormat(String format) {
            this.format = format;
            return this;
        }

        public TimeFormatExtractionFnBuilder withTimeZone(String timeZone) {
            this.timeZone = ZoneId.of(timeZone);
            return this;
        }

        public TimeFormatExtractionFnBuilder withTimeZone(ZoneId timeZone) {
            this.timeZone = timeZone;
            return this;
        }

        public TimeFormatExtractionFnBuilder withLocale(String locale) {
            this.locale = Locale.forLanguageTag(locale);
            return this;
        }

        public TimeFormatExtractionFnBuilder withLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public TimeFormatExtractionFnBuilder withGranularity(Granularity granularity) {
            this.granularity = granularity;
            return this;
        }

        public TimeFormatExtractionFnBuilder withAsMillis(boolean asMillis) {
            this.asMillis = asMillis;
            return this;
        }

        public TimeFormatExtractionFn build() {
            return new TimeFormatExtractionFn(format, timeZone, locale, granularity, asMillis);
        }
    }
}
