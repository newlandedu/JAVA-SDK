package com.nlecloud.api;

import com.google.gson.Gson;
import com.nlecloud.http.NleHttpGet;
import com.nlecloud.requestEntity.MethodEntity;
import com.nlecloud.response.actuatorHistoryData.ActuatorHistoryDataResponse;
import com.nlecloud.utils.Config;
import com.nlecloud.utils.UrlFormater;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActuatorHistoryDataApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ActuatorHistoryDataResponse executeApi(String gatewayTag,String apiTag, MethodEntity methodEntity, String accessToken) {
        NleHttpGet baseHttp = new NleHttpGet();
        baseHttp.setProxy("192.168.0.110",8888);
        String conversionUri = UrlFormater.format(Config.getString("ActuatorHistoryData"), gatewayTag,apiTag);
        String fullUri = conversionUri + String.format("?Method=%s&TimeAgo=%s", methodEntity.Method, methodEntity.TimeAgo);
        baseHttp.setUri(fullUri);
        baseHttp.setHeader("AccessToken", accessToken);
        HttpResponse httpResponse = baseHttp.execute();
        try {
            Gson gson = new Gson();
            return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), ActuatorHistoryDataResponse.class);

        } catch (Exception e) {
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
