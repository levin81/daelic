package com.github.levin81.daelic.core;

public class DruidConfiguration {

    private static final String DEFAULT_ENDPOINT = "druid/v2";
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8082;

    private final String host;
    private final int port;
    private final String url;

    public DruidConfiguration(String host, int port) {
        this.host = host;
        this.port = port;

        this.url = String.format("http://%s:%d/%s", host, port, DEFAULT_ENDPOINT);
    }

    public DruidConfiguration(String host) {
        this(host, DEFAULT_PORT);
    }

    public DruidConfiguration() {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUrl() {
        return url;
    }
}
