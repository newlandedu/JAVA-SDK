package com.nlecloud.sdk.responseEntity;

import java.util.List;

public class Device {
    private String Name;
    private String Tag;
    private String Protocol;
    private String LastOnlineIP;
    private String LastOnlineTime;
    private String Coordinate;
    private String CreateDate;
    private String  IsShare;
    private String IsTrans;
    private String DeviceID;
    private String ProjectID;
    private String IsOnline;
    private List<ListItemOfSensor> Sensors;
    private String  ProjectIdOrTag;
private String DeviceImg;
    public Device() {
    }

    public Device(String name, String tag, String protocol,String coordinate, String isShare, String isTrans,
             String projectID, String isOnline,String ProjectIdOrTag,String deviceImg) {
        Name = name;
        Tag = tag;
        Protocol = protocol;
        Coordinate = coordinate;
        IsShare = isShare;
        IsTrans = isTrans;
        ProjectID = projectID;
        IsOnline = isOnline;
        this.ProjectIdOrTag = ProjectIdOrTag;
        DeviceImg=deviceImg;
    }

}
