package com.nlecloud.api;

import com.google.gson.Gson;
import com.nlecloud.http.NleHttpGet;
import com.nlecloud.response.gateWayOnOffLine.GateWayOnOffLineResponse;
import com.nlecloud.utils.Config;
import com.nlecloud.utils.UrlFormater;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GateWayOnOffLineApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GateWayOnOffLineResponse executeApi(String gateWayTag, String accessToken) {
        NleHttpGet baseHttp = new NleHttpGet();
        String conversionUri = UrlFormater.format(Config.getString("GateWayState"), gateWayTag);
        baseHttp.setUri(conversionUri);
        baseHttp.setHeader("AccessToken", accessToken);
        HttpResponse httpResponse = baseHttp.execute();
        try {
            Gson gson = new Gson();
            return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), GateWayOnOffLineResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("json error {}", e.getMessage());
        }
        try {
            baseHttp.close();
        } catch (Exception e) {
            logger.error("http close error: {}", e.getMessage());
        }
        return null;
    }
}
