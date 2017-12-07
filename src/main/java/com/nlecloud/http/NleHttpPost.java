package com.nlecloud.http;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NleHttpPost extends BasicHttp<HttpPost> {
    public void instantHttpRequest() {
        this.httpRequest = new HttpPost();
        httpRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
    }


    public void setEntity(Object object) {
        StringEntity stringEntity;
        if (object instanceof String) {
            stringEntity = new StringEntity((String) object, Charset.forName("UTF-8"));
        } else {
            try {
                stringEntity = new StringEntity(new Gson().toJson(object), Charset.forName("UTF-8"));
            } catch (Exception e) {
                logger.error("json parse error", e.getMessage());
                return;
            }
        }
        httpRequest.setEntity(stringEntity);
    }

    public void setEntity(Map<String, String> stringMap) {
        // TODO Auto-generated method stub
        Set<Map.Entry<String, StringBody>> stringBodySet = null;
        if (stringMap != null) {
            Set<Map.Entry<String, String>> stringSet = stringMap.entrySet();
            Map<String, StringBody> stringEntityMap = new HashMap<String, StringBody>();
            for (Map.Entry<String, String> entry : stringSet) {
                try {
                    stringEntityMap.put(entry.getKey(), new StringBody(entry.getValue(), Charset.forName("UTF-8")));
                } catch (UnsupportedEncodingException e) {
                    logger.error("error:" + e.getMessage());
                }
            }
            stringBodySet = stringEntityMap.entrySet();
        }

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        if (stringBodySet != null) {
            for (Map.Entry<String, StringBody> entry : stringBodySet) {
                builder.addPart(entry.getKey(), entry.getValue());
            }
        }

        HttpEntity reqEntity = builder.build();
        httpRequest.setEntity(reqEntity);
    }


}
