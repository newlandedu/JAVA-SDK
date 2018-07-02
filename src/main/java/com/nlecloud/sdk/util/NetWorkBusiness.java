package com.nlecloud.sdk.util;

import com.nlecloud.sdk.requestEntity.DeviceData;
import com.nlecloud.sdk.requestEntity.DeviceElement;
import com.nlecloud.sdk.requestEntity.SignInEntity;
import com.nlecloud.sdk.responseEntity.Device;
import com.nlecloud.sdk.responseEntity.DeviceState;
import com.nlecloud.sdk.responseEntity.ListItemOfDevice;
import com.nlecloud.sdk.responseEntity.TargetSensorInfo;
import com.nlecloud.sdk.responseEntity.User;
import com.nlecloud.sdk.responseEntity.base.BasePager;
import com.nlecloud.sdk.responseEntity.base.BaseResponseEntity;

import java.util.List;

import rx.Observer;

/**
 * Created by marco on 2017/8/21.
 * api调用逻辑
 */

public class NetWorkBusiness {
    private ApiService apiService;
    private String accessToken;

    public NetWorkBusiness(String accessToken, String baseUrl) {
        this.apiService = Tools.buildService(baseUrl);
        this.accessToken = accessToken;
    }

    public void signIn(SignInEntity signIn, Observer<BaseResponseEntity<User>> observer) {
        apiService.signIn(signIn).subscribe(observer);
    }

    public void getProject(String  projectId, Observer<BaseResponseEntity> callback) {
        apiService.getProject(projectId, accessToken).subscribe(callback);
    }

    public void getProjects(String Keyword, String ProjectTag, String NetWorkKind, String PageSize, String StartDate, String EndDate, String PageIndex,
            Observer<BaseResponseEntity> callback) {
        apiService.getProjects(Keyword, ProjectTag, NetWorkKind, PageSize, StartDate, EndDate, PageIndex, accessToken).subscribe(callback);
    }

    public void getAllSensors(String projectId, Observer<BaseResponseEntity<List<TargetSensorInfo>>> callback) {
        apiService.getAllSensors(projectId, accessToken).subscribe(callback);
    }

    public void getDevicesDatas(String deviceIds, Observer<BaseResponseEntity<List<ListItemOfDevice>>> callback) {
        apiService.getDevicesDatas(deviceIds, accessToken).subscribe(callback);
    }

    public void getBatchOnLine(String deviceIds, Observer<BaseResponseEntity<List<DeviceState>>> callback) {
        apiService.getBatchOnLine(deviceIds, accessToken).subscribe(callback);

    }

    public void getDeviceInfo(String deviceId, Observer<BaseResponseEntity<Device>> callback) {
        apiService.getDeviceInfo(deviceId, accessToken).subscribe(callback);
    }

    public void getDeviceFuzzy(String Keyword, String DeviceIds, String Tag, String IsOnline, String IsShare, String ProjectKeyWord, String PageSize, String StartDate, String
            EndDate, String PageIndex, Observer<BaseResponseEntity<BasePager<Device>>> callback) {
        apiService.getDeviceFuzzy(Keyword, DeviceIds, Tag, IsOnline, IsShare, ProjectKeyWord, PageSize, StartDate, EndDate, PageIndex, accessToken).subscribe(callback);
    }

    public void postAddDevice(Device device, Observer<BaseResponseEntity> callback) {
        apiService.postAddDevice(device, accessToken).subscribe(callback);
    }

    public void updateDevice(String deviceId, Device device, Observer<BaseResponseEntity<Object>> callback) {
        apiService.updateDevice(deviceId, device, accessToken).subscribe(callback);
    }

    public void deleteDevice(String deviceId, Observer<BaseResponseEntity> callback) {
        apiService.deleteDevice(deviceId, accessToken).subscribe(callback);
    }

    public void getSensor(String deviceId, String apiTag, Observer<BaseResponseEntity> callback) {
        apiService.getSensor(deviceId, apiTag, accessToken).subscribe(callback);
    }

    public void getSensors(String deviceId, Observer<BaseResponseEntity> callback) {
        apiService.getSensors(deviceId, accessToken).subscribe(callback);
    }

    public void addSensor(String deviceId, DeviceElement deviceElement, Observer<BaseResponseEntity> callback) {
        apiService.addSensor(deviceId, deviceElement, accessToken).subscribe(callback);
    }

    public void updateSensor(String deviceId, String apiTag, DeviceElement.SensorDeviceElement deviceElement, Observer<BaseResponseEntity> callback) {
        apiService.updateSensor(deviceId, apiTag, deviceElement, accessToken).subscribe(callback);
    }

    public void updateActuator(String deviceId, String apiTag, DeviceElement.ActuatorDeviceElement deviceElement, Observer<BaseResponseEntity> callback) {
        apiService.updateSensor(deviceId, apiTag, deviceElement, accessToken).subscribe(callback);
    }

    public void updateCamera(String deviceId, String apiTag, DeviceElement.CameraDeviceElement deviceElement, Observer<BaseResponseEntity> callback) {
        apiService.updateSensor(deviceId, apiTag, deviceElement, accessToken).subscribe(callback);
    }

    public void deleteDeviceElement(String deviceId, String apiTag, Observer<BaseResponseEntity> callback) {
        apiService.deleteDeviceElement(deviceId, apiTag, accessToken).subscribe(callback);
    }

    public void addSensorData(String deviceId, DeviceData datasDTO, Observer<BaseResponseEntity> callback) {
        apiService.addSensorData(deviceId, datasDTO, accessToken).subscribe(callback);
    }

    public void getSensorData(String deviceId, String ApiTags, String Method, String TimeAgo, String StartDate, String EndDate, String Sort, String PageSize, String PageIndex,
            Observer<BaseResponseEntity> callback) {
        apiService.getSensorData(deviceId, ApiTags, Method, TimeAgo, StartDate, EndDate, Sort, PageSize, PageIndex, accessToken).subscribe(callback);
    }

    public void control(String deviceId, String apiTag, Object data, Observer<BaseResponseEntity> callback) {
        apiService.control(deviceId, apiTag, data, accessToken).subscribe(callback);
    }


}
