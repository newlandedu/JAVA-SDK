package com.nlecloud.utils;

public class UrlFormater {
    public static String format(String url, String gatewayTag, String apiTag, int data) {
        String result = url.replace("{gatewayTag}", gatewayTag);
        result = result.replace("{apiTag}", apiTag);
        result = result.replace("{data}", data + "");
        return result;
    }

    public static String format(String url, String gatewayTag, String apiTag) {
        return format(url, gatewayTag, apiTag, 0);
    }

    public static String format(String url, String gatewayTag) {
        return format(url, gatewayTag, "");
    }
}
