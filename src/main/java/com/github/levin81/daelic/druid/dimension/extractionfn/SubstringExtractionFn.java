package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.fasterxml.jackson.annotation.JsonInclude;

/***
 * Returns a substring of the dimension value starting from the supplied index and of the desired length. Both index and length
 * are measured in the number of Unicode code units present in the string as if it were encoded in UTF-16. Note that some Unicode
 * characters may be represented by two code units. This is the same behavior as the Java String class's "substring" method.
 *
 * If the desired length exceeds the length of the dimension value, the remainder of the string starting at index will be returned.
 * If index is greater than the length of the dimension value, null will be returned.
 *
 * The length may be omitted for substring to return the remainder of the dimension value starting from index, or null if index
 * greater than the length of the dimension value.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubstringExtractionFn implements ExtractionFn {

    private final String type = "substring";

    private int index;
    // TODO: this is not a required property
    private int length;

    SubstringExtractionFn(int index, int length) {
        this.index = index;
        this.length = length;
    }

    @Override
    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public int getLength() {
        return length;
    }

    public static SubstringExtractionFnBuilder builder() {
        return new SubstringExtractionFnBuilder();
    }

    public static class SubstringExtractionFnBuilder {

        private int index;
        private int length;

        SubstringExtractionFnBuilder() {

        }

        public SubstringExtractionFnBuilder withIndex(int index) {
            this.index = index;
            return this;
        }

        public SubstringExtractionFnBuilder withLength(int length) {
            this.length = length;
            return this;
        }

        public SubstringExtractionFn build() {
            return new SubstringExtractionFn(index, length);
        }
    }
}
