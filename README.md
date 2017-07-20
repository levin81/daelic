# daelic

A library for easy query object building and query result parsing for Apache Druid.

## Dependencies

```XML
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.8.9</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>2.8.9</version>
</dependency>
```

## TODO
- Javadocs
- Assertions
- Contexts
- ~~ExtractionFns - Time Parsing, Time Format~~
- ~~Lookups - Namespace~~
- Filters - Bound, Interval, Search, Spatial
- SortingOrder
- Queries - Search, Select, Timeseries
- Query Result deserialization
- Bug Fixes