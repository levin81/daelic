package com.github.levin81.daelic.druid.filter;

import com.github.levin81.daelic.druid.dimension.extractionfn.ExtractionFn;
import com.github.levin81.daelic.util.Properties;

/***
 * The simplest filter is a selector filter. The selector filter will match a specific dimension with a specific value.
 * Selector filters can be used as the base filters for more complex Boolean expressions of filters.
 *
 * This is the equivalent of WHERE &lt;dimension_string&gt; = '&lt;dimension_value_string&gt;'.
 */
public class SelectorFilter implements Filter {

    private final String type = "selector";

    private String dimension;
    private String value;
    private ExtractionFn extractionFn;

    SelectorFilter(String dimension, String value, ExtractionFn extractionFn) {
        Properties.assertRequired(dimension, "Dimension is a required property");
        Properties.assertRequired(value, "Value is a required property");

        this.dimension = dimension;
        this.value = value;
        this.extractionFn = extractionFn;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public String getValue() {
        return value;
    }

    public ExtractionFn getExtractionFn() {
        return extractionFn;
    }

    public static SelectorFilterBuilder builder() {
        return new SelectorFilterBuilder();
    }

    public static class SelectorFilterBuilder {

        private String dimension;
        private String value;
        private ExtractionFn extractionFn;

        SelectorFilterBuilder() {

        }

        public SelectorFilterBuilder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public SelectorFilterBuilder withValue(String value) {
            this.value = value;
            return this;
        }

        public SelectorFilterBuilder withExtractionFn(ExtractionFn extractionFn) {
            this.extractionFn = extractionFn;
            return this;
        }

        public SelectorFilter build() {
            return new SelectorFilter(dimension, value, extractionFn);
        }
    }
}
