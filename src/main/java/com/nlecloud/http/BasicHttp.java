package com.nlecloud.http;

import com.nlecloud.utils.Config;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class BasicHttp<T extends HttpRequestBase> {
    public abstract void instantHttpRequest();

    protected CloseableHttpClient httpClient = HttpClients.createDefault();

    T httpRequest;
    private String baseUrl;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BasicHttp() {
        instantHttpRequest();
        this.baseUrl = Config.getString("baseUrl");
    }

    public void setHeader(Map<String, Object> headers) {
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            this.httpRequest.setHeader(entry.getKey(), entry.getValue().toString());
        }
    }

    public void setHeader(String key, String value) {
        this.httpRequest.setHeader(key, value);
    }

    public void setUri(String uri) {
        try {
            this.httpRequest.setURI(new URI(baseUrl + uri));
        } catch (URISyntaxException e) {
            logger.error("url error", e.getMessage());

            e.printStackTrace();
        }
    }
    public void setProxy(String ip, int port) {
        HttpHost proxy = new HttpHost(ip, port, "http");
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        httpRequest.setConfig(config);
    }

    public HttpResponse execute() {
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpRequest);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK && statusCode != 221) {
                logger.error("request failed: {}", statusCode);
            }
        } catch (Exception e) {
            logger.error("error:" + e.getMessage());
        }
        return httpResponse;

    }

    public void close() throws IOException {
        httpClient.close();
    }
}
