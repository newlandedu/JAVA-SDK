package com.nlecloud.api;

import com.google.gson.Gson;
import com.nlecloud.http.NleHttpPost;
import com.nlecloud.requestEntity.LoginEntity;
import com.nlecloud.response.login.LoginResponse;
import com.nlecloud.utils.Config;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginApi {
    private final Logger logger = LoggerFactory. getLogger(this. getClass());

    public LoginResponse executeApi(LoginEntity loginEntity) {
        NleHttpPost nleHttpPost = new NleHttpPost();

        nleHttpPost.setUri(Config. getString("login"));
        nleHttpPost.setEntity(loginEntity);
        HttpResponse httpResponse = nleHttpPost.execute();
        try {
            Gson gson = new Gson();
           return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), LoginResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("json error {}", e. getMessage());
        }
        try {
            nleHttpPost.close();
        } catch (Exception e) {
            logger.error("http close error: {}", e. getMessage());
        }
        return null;
    }
}
