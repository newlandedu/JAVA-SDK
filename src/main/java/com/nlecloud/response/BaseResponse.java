package com.nlecloud.response;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseResponse {
    public String ErrorObj;
    public int Status;
    public int StatusCode;
    public String Message;
    public String Msg;
    private transient final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getJsonStr() {
        Gson gson = new Gson();
        try {
            return gson.toJson(this);
        } catch (Exception e) {
            logger.error("json parse error", e.getMessage());

        }
        return "";
    }


}
