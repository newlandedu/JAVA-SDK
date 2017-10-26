package com.nlecloud.utils;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final static Properties properties;
    private static org.slf4j.Logger logger = LoggerFactory. getLogger(Config.class);

    static {
        InputStream in = Config.class. getClassLoader(). getResourceAsStream("config.properties");
        properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            logger.error("init config error", e);
        }
    }

    public static String  getString(String conf) {
        return properties. getProperty(conf);
    }

    public static void setAccessToken(String value) {
        properties.setProperty("accessToken", value);
    }

}
