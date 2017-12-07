package com.nlecloud.api;

import com.google.gson.Gson;
import com.nlecloud.http.NleHttpGet;
import com.nlecloud.requestEntity.PageEntity;
import com.nlecloud.response.actuatorPageData.ActuatorPageDataResponse;
import com.nlecloud.utils.Config;
import com.nlecloud.utils.UrlFormater;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActuatorPageDataApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ActuatorPageDataResponse executeApi(String gatewayTag, String apiTag, PageEntity pageEntity, String accessToken) {
        NleHttpGet baseHttp = new NleHttpGet();

        String conversionUri = UrlFormater.format(Config.getString("PageActuatorData"), gatewayTag, apiTag);
        String fullUri = conversionUri + String
                .format("?StartDate=%s&EndDate=%s&PageIndex=%s&PageSize=%s", pageEntity.StartDate, pageEntity.EndDate, pageEntity.PageIndex, pageEntity.PageSize);
        baseHttp.setUri(fullUri);
        baseHttp.setHeader("AccessToken", accessToken);
     // baseHttp.setProxy("192.168.0.110", 8888);
        HttpResponse httpResponse = baseHttp.execute();
        try {
            Gson gson = new Gson();
            return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), ActuatorPageDataResponse.class);

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
