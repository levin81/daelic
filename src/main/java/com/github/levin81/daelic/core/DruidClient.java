package com.github.levin81.daelic.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.levin81.daelic.druid.GroupBy;
import com.github.levin81.daelic.druid.Select;
import com.github.levin81.daelic.druid.Timeseries;
import com.github.levin81.daelic.druid.TopN;
import com.github.levin81.daelic.druid.result.GroupByResult;
import com.github.levin81.daelic.druid.result.SelectResult;
import com.github.levin81.daelic.druid.result.TimeseriesResult;
import com.github.levin81.daelic.druid.result.TopNResult;
import com.github.levin81.daelic.exception.DruidException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

public class DruidClient {

    private final DruidConfiguration configuration;
    private final ObjectMapper mapper;

    public DruidClient() {
        this(new DruidConfiguration());
    }

    public DruidClient(DruidConfiguration configuration) {
        this(configuration, new ObjectMapper().findAndRegisterModules());
    }

    public DruidClient(DruidConfiguration configuration, ObjectMapper mapper) {
        this.configuration = configuration;
        this.mapper = mapper;
    }

    public GroupByResult query(GroupBy groupBy) throws IOException, DruidException {
        return query(groupBy, GroupByResult.class);
    }

    public SelectResult select(Select select) throws IOException, DruidException {
        return query(select, SelectResult.class);
    }

    public SelectResult select(Select select, Map<String, Integer> pagingIdentifier) {
        return null;
    }

    public TopNResult query(TopN topN) throws IOException, DruidException {
        return query(topN, TopNResult.class);
    }

    public TimeseriesResult query(Timeseries timeseries) throws IOException, DruidException {
        return query(timeseries, TimeseriesResult.class);
    }

    private <REQ, RESP> RESP query(REQ request, Class<RESP> clazz) throws IOException, DruidException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(configuration.getUrl());

        StringEntity entity = new StringEntity(mapper.writeValueAsString(request));
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        String content = EntityUtils.toString(response.getEntity());

        try {
            return mapper.readValue(content, clazz);
        } catch (Exception ex) {
            throw new DruidException(content);
        } finally {
            client.close();
        }
    }
}
