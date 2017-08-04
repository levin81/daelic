# daelic

A library for easy query object building and query result parsing for Apache Druid.

## Dependencies

```XML
<dependencies>
    <dependency>
        <!-- Lombok will be removed in the future -->
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.16.16</version>
        <scope>provided</scope>
    </dependency>
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
</dependencies>
```

## TODO
- Javadocs
- Assertions
- Contexts
- ~~ExtractionFns - Time Parsing, Time Format~~
- ~~Lookups - Namespace~~
- Filters - ~~Bound, Interval, Search,~~ Spatial
- SortingOrder
- Queries - ~~Search,~~ Select, ~~Timeseries~~
- Query Result deserialization
- Tests
- Bug Fixes