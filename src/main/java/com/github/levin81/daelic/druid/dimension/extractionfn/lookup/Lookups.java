package com.github.levin81.daelic.druid.dimension.extractionfn.lookup;

public class Lookups {

    public static MapLookup.MapLookupBuilder MAP() {
        return MapLookup.builder();
    }

    public static NamespaceLookup.NamespaceLookupBuilder NAMESPACE() {
        return NamespaceLookup.builder();
    }
}
