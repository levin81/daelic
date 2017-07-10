package com.github.levin81.daelic.druid.dimension.extractionfn.lookup;

import com.github.levin81.daelic.util.Properties;

import java.util.Map;

public class MapLookup implements Lookup {

    private final String type = "map";

    private Map<String, String> map;

    MapLookup(Map<String, String> map) {
        Properties.assertRequired(map, "Map is a required property");

        this.map = map;
    }

    @Override
    public String getType() {
        return type;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public static MapLookupBuilder builder() {
        return new MapLookupBuilder();
    }

    public static class MapLookupBuilder {
        private Map<String, String> map;

        MapLookupBuilder() {

        }

        public MapLookupBuilder withMap(Map<String, String> map) {
            this.map = map;
            return this;
        }

        public MapLookup build() {
            return new MapLookup(map);
        }
    }
}
