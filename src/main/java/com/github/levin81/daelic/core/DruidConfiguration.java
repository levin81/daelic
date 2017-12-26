package com.github.levin81.daelic.core;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class DruidConfiguration {

    private static final String DEFAULT_ENDPOINT = "druid/v2";
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8082;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private final String host;
    private final int port;
    private final String url;
    private final Charset charset;

    public DruidConfiguration(String host, int port, Charset charset) {
        this.host = host;
        this.port = port;

        this.url = String.format("http://%s:%d/%s", host, port, DEFAULT_ENDPOINT);

        this.charset = charset;
    }

    public DruidConfiguration(String host, int port) {
        this(host, port, DEFAULT_CHARSET);
    }

    public DruidConfiguration(String host) {
        this(host, DEFAULT_PORT, DEFAULT_CHARSET);
    }

    public DruidConfiguration() {
        this(DEFAULT_HOST, DEFAULT_PORT, DEFAULT_CHARSET);
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

    public Charset getCharset() {
        return charset;
    }
}
