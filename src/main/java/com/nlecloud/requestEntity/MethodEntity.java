package com.nlecloud.requestEntity;

public class MethodEntity {
    private int Method;//1，2，3，4，5对应分钟，小时，天，周，月
    private int TimeAgo;//前几

    public MethodEntity(int method, int timeAgo) {
        Method = method;
        TimeAgo = timeAgo;
    }
}
