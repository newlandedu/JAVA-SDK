package com.nlecloud.sdk.util;

import com.google.gson.Gson;
import com.nlecloud.sdk.responseEntity.base.BaseResponseEntity;

import rx.Observer;
public  class MyObserver<T> implements Observer<BaseResponseEntity<T>> {
    public void onCompleted() {
    }

    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    public void onNext(BaseResponseEntity<T> baseResponseEntity) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(baseResponseEntity));
    }
}
