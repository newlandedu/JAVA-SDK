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

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by marco on 2017/8/21.
 * api请求接口
 */

public interface ApiService {
    /**
     * 登陆
     */
    @POST("Users/Login")
    Observable<BaseResponseEntity<User>> signIn(@Body SignInEntity signInEntity);

    /**
     * 查询单个项目
     */
    @GET("Projects/{projectId}")
    Observable<BaseResponseEntity> getProject(@Path("projectId") String  projectId, @Header("AccessToken") String accessToken);

    /**
     * 模糊查询项目
     */
    @GET("Projects")
    Observable<BaseResponseEntity> getProjects(@Query("Keyword") String Keyword, @Query("ProjectTag") String ProjectTag, @Query("NetWorkKind") String
            NetWorkKind, @Query("PageSize") String PageSize, @Query("StartDate") String StartDate, @Query("EndDate") String EndDate, @Query("PageIndex") String PageIndex,
            @Header("AccessToken") String accessToken);

    /**
     * 查询项目所有设备的传感器
     */
    @GET("Projects/{projectId}/Sensors")
    Observable<BaseResponseEntity<List<TargetSensorInfo>>> getAllSensors(@Path("projectId") String projectId, @Header("AccessToken") String accessToken);

    /**
     * 批量查询设备最新数据
     */
    @GET("Devices/Datas")
    Observable<BaseResponseEntity<List<ListItemOfDevice>>> getDevicesDatas(@Query("devIds") String devIds, @Header("AccessToken") String accessToken);

    /**
     * 批量查询设备的在线状态
     */
    @GET("Devices/Status")
    Observable<BaseResponseEntity<List<DeviceState>>> getBatchOnLine(@Query("devIds") String devIds, @Header("AccessToken") String accessToken);

    /**
     * 查询单个设备
     */
    @GET("Devices/{deviceId}")
    Observable<BaseResponseEntity<Device>> getDeviceInfo(@Path("deviceId") String deviceId, @Header("AccessToken") String accessToken);

    /**
     * 模糊查询设备
     */
    @GET("Devices")
    Observable<BaseResponseEntity<BasePager<Device>>> getDeviceFuzzy(@Query("Keyword") String Keyword, @Query("DeviceIds") String DeviceIds, @Query("Tag") String Tag, @Query
            ("IsOnline") String IsOnline, @Query("IsShare") String IsShare, @Query("ProjectKeyWord") String ProjectKeyWord, @Query("PageSize") String PageSize, @Query
            ("StartDate") String StartDate, @Query("EndDate") String EndDate, @Query("PageIndex") String PageIndex, @Header("AccessToken") String accessToken);

    /**
     * 添加1个新设备
     */
    @POST("Devices")
    Observable<BaseResponseEntity> postAddDevice(@Body Device device, @Header("AccessToken") String accessToken);

    /**
     * 更新某个设备
     */
    @PUT("Devices/{deviceId}")
    Observable<BaseResponseEntity<Object>> updateDevice(@Path("deviceId") String deviceId, @Body Device device, @Header("AccessToken") String accessToken);

    /**
     * 删除设备
     */
    @DELETE("Devices/{deviceId}")
    Observable<BaseResponseEntity> deleteDevice(@Path("deviceId") String deviceId, @Header("AccessToken") String accessToken);

    /**
     * 查询单个传感器
     */
    @GET("devices/{deviceId}/Sensors/{apiTag}")
    Observable<BaseResponseEntity> getSensor(@Path("deviceId") String deviceId, @Path("apiTag") String apiTag, @Header("AccessToken") String accessToken);

    /**
     * 模糊查询传感器
     */
    @GET("devices/{deviceId}/Sensors")
    Observable<BaseResponseEntity> getSensors(@Path("deviceId") String deviceId, @Header("AccessToken") String accessToken);

    /**
     * 添加1个新传感器
     */
    @POST("devices/{deviceId}/Sensors")
    Observable<BaseResponseEntity> addSensor(@Path("deviceId") String deviceId, @Body DeviceElement deviceElement, @Header("AccessToken") String accessToken);

    /**
     * 更新某个传感器
     */
    @PUT("devices/{deviceId}/Sensors/{apiTag}")
    Observable<BaseResponseEntity> updateSensor(@Path("deviceId") String deviceId, @Path("apiTag") String apiTag, @Body DeviceElement.SensorDeviceElement deviceElement, @Header
            ("AccessToken") String accessToken);

    /**
     * 更新某个执行器
     */
    @PUT("devices/{deviceId}/Sensors/{apiTag}")
    Observable<BaseResponseEntity> updateSensor(@Path("deviceId") String deviceId, @Path("apiTag") String apiTag, @Body DeviceElement.ActuatorDeviceElement deviceElement, @Header
            ("AccessToken") String accessToken);

    /**
     * 更新某个摄像头
     */
    @PUT("devices/{deviceId}/Sensors/{apiTag}")
    Observable<BaseResponseEntity> updateSensor(@Path("deviceId") String deviceId, @Path("apiTag") String apiTag, @Body DeviceElement.CameraDeviceElement deviceElement, @Header
            ("AccessToken") String accessToken);

    /**
     * /**
     * 删除某个传感器
     */
    @DELETE("devices/{deviceId}/Sensors/{apiTag}")
    Observable<BaseResponseEntity> deleteDeviceElement(@Path("deviceId") String deviceId, @Path("apiTag") String apiTag, @Header("AccessToken") String accessToken);

    /**
     * 新增传感数据
     */
    @POST("devices/{deviceId}/Datas")
    Observable<BaseResponseEntity> addSensorData(@Path("deviceId") String deviceId, @Body DeviceData datasDTO, @Header("AccessToken") String accessToken);

    /**
     * 查询传感数据
     */
    @GET("devices/{deviceId}/Datas")
    Observable<BaseResponseEntity> getSensorData(@Path("deviceId") String deviceId, @Query("ApiTags") String ApiTags, @Query("Method") String Method, @Query("TimeAgo") String TimeAgo,
            @Query("StartDate") String StartDate, @Query("EndDate") String EndDate, @Query("Sort") String Sort, @Query("PageSize") String PageSize, @Query("PageIndex") String
            PageIndex, @Header("AccessToken") String accessToken);

    /**
     * 发送命令/控制设备
     */
    @POST("Cmds")
    Observable<BaseResponseEntity> control(@Query("deviceId") String deviceId, @Query("apiTag") String apiTag, @Body Object data, @Header("AccessToken") String accessToken);

}
