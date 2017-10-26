package com.nlecloud.sdk;

import com.nlecloud.api.ActuatorControlApi;
import com.nlecloud.api.ActuatorInfoApi;
import com.nlecloud.api.ActuatorNewDataApi;
import com.nlecloud.api.CameraInfoApi;
import com.nlecloud.api.GWHistoryOnOffApi;
import com.nlecloud.api.GateWayInfoApi;
import com.nlecloud.api.GateWayOnOffLineApi;
import com.nlecloud.api.GateWaySensorListApi;
import com.nlecloud.api.GateWayStatusApi;
import com.nlecloud.api.GatewayActuatorListApi;
import com.nlecloud.api.GatewayCameraListApi;
import com.nlecloud.api.LoginApi;
import com.nlecloud.api.NewDatasApi;
import com.nlecloud.api.SensorHistoryDataApi;
import com.nlecloud.api.SensorInfoApi;
import com.nlecloud.api.SensorNewDataApi;
import com.nlecloud.api.SensorPageDataApi;
import com.nlecloud.requestEntity.LoginEntity;
import com.nlecloud.requestEntity.MethodEntity;
import com.nlecloud.requestEntity.PageEntity;
import com.nlecloud.response.actuatorControl.ActuatorControlResponse;
import com.nlecloud.response.actuatorNewData.ActuatorNewDataResponse;
import com.nlecloud.response.cameraInfo.CameraInfoResponse;
import com.nlecloud.response.gateWayActuatorList.GateWayActuatorListResponse;
import com.nlecloud.response.gateWayCameraList.GateWayCameraListResponse;
import com.nlecloud.response.gateWayHistoryPageOnOff.GWHistoryPageOnOffResponse;
import com.nlecloud.response.gateWayInfo.GateWayInfoResponse;
import com.nlecloud.response.gateWaySensorList.GateWaySensorListResponse;
import com.nlecloud.response.login.LoginResponse;
import com.nlecloud.response.SensorHistoryData.SensorHistoryDataResponse;
import com.nlecloud.response.sensorNewData.SensorNewDataResponse;
import com.nlecloud.response.actuatorInfo.ActuatorInfoResponse;
import com.nlecloud.response.gateWayOnOffLine.GateWayOnOffLineResponse;
import com.nlecloud.response.gateWayStatus.GateWayStatusResponse;
import com.nlecloud.response.newDatas.NewDatasResponse;
import com.nlecloud.response.sensorInfo.SensorInfoResponse;
import com.nlecloud.response.sensorPageData.SensorPageDataResponse;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 除login外其他api接口都需要设置accessToken为头信息，其值为登陆成功后的accessToken值
 */
public class ApiTest {
    private static String token;

    /**
     * 登陆
     */
    @BeforeClass
    public static void login() {
        LoginEntity loginEntity = new LoginEntity("15859195263", "pxl123");
        LoginApi loginApi = new LoginApi();
        LoginResponse loginResponse = loginApi.executeApi(loginEntity);
        token = loginResponse.ResultObj.AccessToken;
    }

    /**
     * 网关信息
     */
    @Test
    public void getGateWayInfo() {
        GateWayInfoApi gateWayInfoApi = new GateWayInfoApi();
        GateWayInfoResponse gateWayInfoResponse = gateWayInfoApi.executeApi("P97E1000486", token);
        System.out.println(gateWayInfoResponse.getJsonStr());
    }

    /**
     * 获取传感器列表
     */
    @Test
    public void gateWaySensorList() {
        GateWaySensorListApi gateWaySensorListApi = new GateWaySensorListApi();
        GateWaySensorListResponse gateWaySensorListResponse = gateWaySensorListApi.executeApi("P97E1000486", token);
        System.out.println(gateWaySensorListResponse.getJsonStr());
    }

    /**
     * 获取某个传感器的信息
     */
    @Test
    public void sensorInfo() {
        SensorInfoApi sensorInfoApi = new SensorInfoApi();
        SensorInfoResponse sensorInfoResponse = sensorInfoApi.executeApi("P97E1000486", "8771FFDB6A70", token);
        System.out.println(sensorInfoResponse.getJsonStr());
    }

    /**
     * 控制器列表
     */
    @Test
    public void gateWayActuatorList() {
        GatewayActuatorListApi gatewayActuatorListApi = new GatewayActuatorListApi();
        GateWayActuatorListResponse gateWayActuatorListResponse = gatewayActuatorListApi.executeApi("P97E1000486", token);
        System.out.println(gateWayActuatorListResponse.getJsonStr());
    }

    /**
     * 获取某个控制器的信息
     */
    @Test
    public void actuatorInfo() {
        ActuatorInfoApi actuatorInfoApi = new ActuatorInfoApi();
        ActuatorInfoResponse actuatorInfoResponse = actuatorInfoApi.executeApi("P97E1000486", "0FA6C8C1C28E", token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 摄像头列表
     */
    @Test
    public void GateWayCameraList() {
        GatewayCameraListApi cameraListApi = new GatewayCameraListApi();
        GateWayCameraListResponse gateWayActuatorListResponse = cameraListApi.executeApi("P97E1000486", token);
        System.out.println(gateWayActuatorListResponse.getJsonStr());
    }

    /**
     * 获取某个摄像头的信息
     */
    @Test
    public void cameraInfo() {
        CameraInfoApi cameraInfoApi = new CameraInfoApi();
        CameraInfoResponse actuatorInfoResponse = cameraInfoApi.executeApi("P97E1000486", "EE0792DABF0D", token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 获取某个网关在线/离线状态
     */
    @Test
    public void gateWayOnOffLine() {
        GateWayOnOffLineApi gateWayOnOffLineApi = new GateWayOnOffLineApi();
        GateWayOnOffLineResponse actuatorInfoResponse = gateWayOnOffLineApi.executeApi("fe34faa536", token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 获取某个网关在线/离线状态列表
     */
    @Test
    public void gateWayHistoryOnOff() {
        GWHistoryOnOffApi gwHistoryOnOffApi = new GWHistoryOnOffApi();
        PageEntity pageEntity = new PageEntity("2017-1-1", "2017-12-12", 1, 3);
        GWHistoryPageOnOffResponse gwHistoryPageOnOffResponse = gwHistoryOnOffApi.executeApi("P97E1000486", pageEntity, token);
        System.out.println(gwHistoryPageOnOffResponse.getJsonStr());
    }

    /**
     * 获取某个网关启用/禁用状态
     */
    @Test
    public void gateWayStatus() {
        GateWayStatusApi gateWayStatusApi = new GateWayStatusApi();
        GateWayStatusResponse actuatorInfoResponse = gateWayStatusApi.executeApi("P97E1000486", token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 获取某个网关的所有传感器、执行器最新值
     */
    @Test
    public void newDatas() {
        NewDatasApi newDatasApi = new NewDatasApi();
        NewDatasResponse newDatasResponse = newDatasApi.executeApi("P97E1000486", token);
        System.out.println(newDatasResponse.getJsonStr());
    }

    /**
     * 获取某个传感器的最新值
     */
    @Test
    public void sensorNewData() {
        SensorNewDataApi sensorNewDataApi = new SensorNewDataApi();
        SensorNewDataResponse actuatorInfoResponse = sensorNewDataApi.executeApi("P97E1000486", "922FC7932C9D", token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 获取某个传感器的历史数据
     */
    @Test
    public void sensorHistoryData() {
        SensorHistoryDataApi sensorHistoryDataApi = new SensorHistoryDataApi();
        MethodEntity methodEntity = new MethodEntity(3, 7);//7天前
        SensorHistoryDataResponse actuatorInfoResponse = sensorHistoryDataApi.executeApi("V97E1000000", "4A1CC88D5D5D", methodEntity, token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 获取某个传感器的历史分页数据
     */
    @Test
    public void sensorHistoryPageData() {
        SensorPageDataApi sensorPageDataApi = new SensorPageDataApi();
        PageEntity pageEntity = new PageEntity("2017-1-1", "2017-11-11", 1, 10);
        SensorPageDataResponse actuatorInfoResponse = sensorPageDataApi.executeApi("V97E1000000", "4A1CC88D5D5D", pageEntity, token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 获取某个控制器的最新值
     */
    @Test
    public void actuatorNewData() {
        ActuatorNewDataApi actuatorNewDataApi = new ActuatorNewDataApi();
        ActuatorNewDataResponse actuatorNewDataResponse = actuatorNewDataApi.executeApi("V97E1000000", "44846F0ADB29", token);
        System.out.println(actuatorNewDataResponse.getJsonStr());
    }


    /**
     * 获取某个控制器的历史数据
     */
    @Test
    public void actuatorHistoryData() {
        SensorHistoryDataApi sensorHistoryDataApi = new SensorHistoryDataApi();
        MethodEntity methodEntity = new MethodEntity(3, 7);//7天前
        SensorHistoryDataResponse actuatorInfoResponse = sensorHistoryDataApi.executeApi("V97E1000000", "44846F0ADB29", methodEntity, token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    /**
     * 获取某个控制器的历史分页数据
     */
    @Test
    public void actuatorHistoryPageData() {
        SensorPageDataApi sensorPageDataApi = new SensorPageDataApi();
        PageEntity pageEntity = new PageEntity("2017-1-1", "2017-11-11", 1, 10);
        SensorPageDataResponse actuatorInfoResponse = sensorPageDataApi.executeApi("V97E1000000", "17735E88099A", pageEntity, token);
        System.out.println(actuatorInfoResponse.getJsonStr());
    }

    @Test
    public void actuatorControl() {
        ActuatorControlApi actuatorControlApi = new ActuatorControlApi();
        ActuatorControlResponse aclActuatorControlResponse = actuatorControlApi.executeApi("V97E1000000", "44846F0ADB29", 1, token);
        System.out.println(aclActuatorControlResponse.getJsonStr());
    }
}
