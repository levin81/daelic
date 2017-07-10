package com.github.levin81.daelic.druid.dimension.extractionfn;

import com.github.levin81.daelic.util.Properties;

/***
 * Returns the dimension value unchanged if the regular expression matches, otherwise returns null.
 */
public class PartialExtractionFn implements ExtractionFn {

    private final String type = "partial";

    private String expr;

    PartialExtractionFn(String expr) {
        Properties.assertRequired(expr, "Expr is a required property");

        this.expr = expr;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getExpr() {
        return expr;
    }

    public static PartialExtractionFnBuilder builder() {
        return new PartialExtractionFnBuilder();
    }

    public static class PartialExtractionFnBuilder {

        private String expr;

        PartialExtractionFnBuilder() {

        }

        public PartialExtractionFnBuilder withExpr(String expr) {
            this.expr = expr;
            return this;
        }

        public PartialExtractionFn build() {
            return new PartialExtractionFn(expr);
        }
    }
}
