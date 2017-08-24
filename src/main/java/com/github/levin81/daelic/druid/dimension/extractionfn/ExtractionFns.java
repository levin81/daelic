package com.github.levin81.daelic.druid.dimension.extractionfn;

public final class ExtractionFns {

    public static CascadeExtractionFn.CascadeExtractionFnBuilder CASCADE() {
        return CascadeExtractionFn.builder();
    }

    public static JavascriptExtractionFn.JavascriptExtractionFnBuilder JAVASCRIPT() {
        return JavascriptExtractionFn.builder();
    }

    public static LookupExtractionFn.LookupExtractionFnBuilder LOOKUP() {
        return LookupExtractionFn.builder();
    }

    public static PartialExtractionFn.PartialExtractionFnBuilder PARTIAL() {
        return PartialExtractionFn.builder();
    }

    public static RegexExtractionFn.RegexExtractionFnBuilder REGEX() {
        return RegexExtractionFn.builder();
    }

    public static StrlenExtractionFn STRLEN() {
        return StrlenExtractionFn.build();
    }

    public static SubstringExtractionFn.SubstringExtractionFnBuilder SUBSTRING() {
        return SubstringExtractionFn.builder();
    }

    public static TimeFormatExtractionFn.TimeFormatExtractionFnBuilder TIME_FORMAT() {
        return TimeFormatExtractionFn.builder();
    }

    public static TimeParsingExtractionFn.TimeParsingExtractionFnBuilder TIME_PARSING() {
        return TimeParsingExtractionFn.builder();
    }
}
