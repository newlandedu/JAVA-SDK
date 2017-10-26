package com.nlecloud.api;

import com.google.gson.Gson;
import com.nlecloud.http.NleHttpPost;
import com.nlecloud.response.actuatorNewData.ActuatorNewDataResponse;
import com.nlecloud.utils.Config;
import com.nlecloud.utils.UrlFormater;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActuatorNewDataApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ActuatorNewDataResponse executeApi(String gatewayTag, String apiTag, String accessToken) {
        NleHttpPost nleHttpPost = new NleHttpPost();
        String conversionUri = UrlFormater.format(Config.getString("ActuatorNewestData"), gatewayTag, apiTag);
        nleHttpPost.setUri(conversionUri);
        nleHttpPost.setHeader("AccessToken", accessToken);
        HttpResponse httpResponse = nleHttpPost.execute();
        try {
            Gson gson = new Gson();
            return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), ActuatorNewDataResponse.class);

        } catch (Exception e) {
            logger.error("json error {}", e.getMessage());
        }
        try {
            nleHttpPost.close();
        } catch (Exception e) {
            logger.error("http close error: {}", e.getMessage());
        }
        return null;
    }

}