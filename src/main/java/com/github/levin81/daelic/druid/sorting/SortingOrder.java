package com.github.levin81.daelic.druid.sorting;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SortingOrder {

    /**
     * Sorts values by converting Strings to their UTF-8 byte array representations and comparing lexicgraphically,
     * byte-by-byte.
     */
    LEXICOGRAPHIC("lexicographic"),

    /**
     * Suitable for strings with both numeric and non-numeric content, e.g.: "file12 sorts after file2"
     * <p>
     * See <a href="https://github.com/amjjd/java-alphanum">https://github.com/amjjd/java-alphanum</a> for more details
     * on how this ordering sorts values.
     * <p>
     * This ordering is not suitable for numbers with decimal points or negative numbers. For example, "1.3" precedes
     * "1.15" in this ordering because "15" has more significant digits than "3". Negative numbers are sorted after
     * positive numbers (because numeric characters precede the "-" in the negative numbers).
     */
    ALPHANUMERIC("alphanumeric"),

    /**
     * Sorts values as numbers, supports integers and floating point values. Negative values are supported.
     * <p>
     * This sorting order will try to parse all string values as numbers. Unparseable values are treated as nulls, and
     * nulls precede numbers.
     * <p>
     * When comparing two unparseable values (e.g., "hello" and "world"), this ordering will sort by comparing the
     * unparsed strings lexicographically.
     */
    NUMERIC("numeric"),

    /**
     * Sorts values by the their string lengths. When there is a tie, this comparator falls back to using the String
     * compareTo method.
     */
    STRLEN("strlen");

    private final String value;

    SortingOrder(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
