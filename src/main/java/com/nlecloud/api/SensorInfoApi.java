package com.nlecloud.api;

import com.google.gson.Gson;
import com.nlecloud.http.NleHttpGet;
import com.nlecloud.response.sensorInfo.SensorInfoResponse;
import com.nlecloud.utils.Config;
import com.nlecloud.utils.UrlFormater;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensorInfoApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public SensorInfoResponse executeApi(String gatewayTag, String apiTag, String accessToken) {
        NleHttpGet nleHttpGet = new NleHttpGet();
        String conversionUri = UrlFormater.format(Config.getString("SensorInfo"), gatewayTag, apiTag);
        nleHttpGet.setUri(conversionUri);
        nleHttpGet.setHeader("AccessToken", accessToken);
        HttpResponse httpResponse = nleHttpGet.execute();
        try {
            Gson gson = new Gson();
            return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), SensorInfoResponse.class);

        } catch (Exception e) {
            logger.error("json error {}", e.getMessage());
        }
        try {
            nleHttpGet.close();
        } catch (Exception e) {
            logger.error("http close error: {}", e.getMessage());
        }
        return null;
    }
}

