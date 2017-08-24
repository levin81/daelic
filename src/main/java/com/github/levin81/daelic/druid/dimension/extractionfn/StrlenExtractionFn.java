package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.fasterxml.jackson.annotation.JsonInclude;

/***
 * Returns the length of dimension values, as measured in the number of Unicode code units present in the string as if it were encoded
 * in UTF-16. Note that some Unicode characters may be represented by two code units. This is the same behavior as the Java String
 * class's "length" method.
 *
 * null strings are considered as having zero length.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StrlenExtractionFn implements ExtractionFn {

    private final String type = "strlen";

    StrlenExtractionFn() {

    }

    @Override
    public String getType() {
        return type;
    }

    public static StrlenExtractionFn build() {
        return new StrlenExtractionFn();
    }
}
