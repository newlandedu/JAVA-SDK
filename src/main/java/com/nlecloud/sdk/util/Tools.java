package com.nlecloud.sdk.util;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marco on 2017/8/21.
 * 工具类
 */

public class Tools {
    public static ApiService buildService(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        return retrofit.create(ApiService.class);

    }

}
