package com.nlecloud.http;

import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NleHttpGet extends BasicHttp<HttpGet> {
    private final Logger logger = LoggerFactory. getLogger(this. getClass());



    public void instantHttpRequest() {
        this.httpRequest = new HttpGet();
        httpRequest.setHeader("Content-Type","application/json; charset=UTF-8");
    }

}
