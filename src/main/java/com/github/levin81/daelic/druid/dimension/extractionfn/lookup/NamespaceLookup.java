package com.github.levin81.daelic.druid.dimension.extractionfn.lookup;

public class NamespaceLookup implements Lookup {

    private final String type = "namespace";

    private String namespace;

    NamespaceLookup(String namespace) {
        this.namespace = namespace;
    }

    @Override
    public String getType() {
        return null;
    }

    public String getNamespace() {
        return namespace;
    }

    public static NamespaceLookupBuilder builder() {
        return new NamespaceLookupBuilder();
    }

    public static class NamespaceLookupBuilder {

        private String namespace;

        NamespaceLookupBuilder() {

        }

        public NamespaceLookupBuilder withNamespace(String namespace) {
            this.namespace = namespace;
            return this;
        }

        public NamespaceLookup build() {
            return new NamespaceLookup(namespace);
        }
    }
}
