package com.github.levin81.daelic.druid.dimension.extractionfn;

public final class ExtractionFns {

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

    public static void TIME_FORMAT() {

    }

    public static void TIME_PARSING() {

    }
}
