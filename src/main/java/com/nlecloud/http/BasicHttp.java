package com.nlecloud.http;

import com.nlecloud.utils.Config;

import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class BasicHttp<T extends HttpRequestBase> {
    public abstract void instantHttpRequest();
    T httpRequest;
    private String baseUrl;
    private final Logger logger = LoggerFactory. getLogger(this. getClass());

    public BasicHttp() {
        instantHttpRequest();
        this.baseUrl = Config. getString("baseUrl");
    }

    public void setHeader(Map<String, Object> headers) {
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            this.httpRequest.setHeader(entry. getKey(), entry. getValue().toString());
        }
    }

    public void setHeader(String key, String value) {
        this.httpRequest.setHeader(key, value);
    }

    public void setUri(String uri) {
        try {
            this.httpRequest.setURI(new URI(baseUrl + uri));
        } catch (URISyntaxException e) {
            logger.error("url error", e. getMessage());

            e.printStackTrace();
        }
    }
}
