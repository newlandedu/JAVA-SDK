package com.nlecloud.sdk;

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
import com.nlecloud.sdk.util.MyObserver;
import com.nlecloud.sdk.util.NetWorkBusiness;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 除login外其他api接口都需要设置accessToken为头信息，其值为登陆成功后的accessToken值
 */
@SuppressWarnings("unchecked")
public class ApiTest {
    private static NetWorkBusiness netWorkBusiness;

    /**
     * 登陆
     */
    @BeforeClass
    public static void login() {
        final String baseUrl = "http://api.nlecloud.com/";
        NetWorkBusiness loginNetWorkBs = new NetWorkBusiness("", baseUrl);
        loginNetWorkBs.signIn(new SignInEntity("请填写用户名", "请填写密码"), new MyObserver<User>() {
            @Override
            public void onNext(BaseResponseEntity<User> baseResponseEntity) {
                String token = baseResponseEntity.getResultObj().getAccessToken();
                netWorkBusiness = new NetWorkBusiness(token, baseUrl);
            }
        });
    }

    @Test
    public void getProject() {
        netWorkBusiness.getProject("请填写项目ID", new MyObserver());
    }

    @Test
    public void getProjects() {
        netWorkBusiness.getProjects("", "", "", "", "", "", "", new MyObserver());
    }

    @Test
    public void getSensors() {
        netWorkBusiness.getAllSensors("", new MyObserver<List<TargetSensorInfo>>());
    }

    @Test
    public void getDeviceNewsData() {
        netWorkBusiness.getDevicesDatas("", new MyObserver<List<ListItemOfDevice>>());
    }

    @Test
    public void getDeviceStates() {
        netWorkBusiness.getBatchOnLine("", new MyObserver<List<DeviceState>>());
    }

    @Test
    public void getDevice() {
        netWorkBusiness.getDeviceInfo("", new MyObserver<Device>());
    }

    @Test
    public void getDevices() {
        netWorkBusiness.getDeviceFuzzy("", "", "", ":", "", "", "", "", "", "", new MyObserver<BasePager<Device>>());
    }

    @Test
    public void postAddDevice() {
        Device device = new Device("", "", "", "", "", "", "", "", "", "");
        netWorkBusiness.postAddDevice(device, new MyObserver());
    }

    @Test
    public void putUpdateDevice() {
        Device device = new Device("", "", "", "", "", "", "", "", "", "");
        netWorkBusiness.updateDevice("", device, new MyObserver<Object>());
    }

    @Test
    public void deleteDevice() {
        netWorkBusiness.deleteDevice("", new MyObserver());
    }

    @Test
    public void getSensor() {
        netWorkBusiness.getSensor("", "", new MyObserver());
    }

    @Test
    public void getSensorsByDevice() {
        netWorkBusiness.getSensors("", new MyObserver());
    }

    @Test
    public void postAddSensor() {
        DeviceElement deviceElement = new DeviceElement.SensorDeviceElement("", "", "", "", "", "");
        DeviceElement deviceElement1 = new DeviceElement.ActuatorDeviceElement("", "", "", "", "", "", "");
        DeviceElement deviceElement2 = new DeviceElement.CameraDeviceElement("", "", "", "", "", "", "", "");
        netWorkBusiness.addSensor("", deviceElement, new MyObserver());
    }

    @Test
    public void putUpdateSensor() {
        DeviceElement.SensorDeviceElement deviceElement = new DeviceElement.SensorDeviceElement("", "", "", "", "", "");
//        DeviceElement deviceElement1 = new DeviceElement.ActuatorDeviceElement("", "", "", "", "", "", "");
//        DeviceElement deviceElement2 = new DeviceElement.CameraDeviceElement("", "", "", "", "", "", "", "");
        netWorkBusiness.updateSensor("", "", deviceElement, new MyObserver());
    }

    @Test
    public void deleteSensor() {
        netWorkBusiness.deleteDeviceElement("", "", new MyObserver());
    }

    @Test
    public void postAddSensorData() {
        List<DeviceData.DatasDTO> datasDTOS = new ArrayList<>();
        List<DeviceData.PointDTO> pointDTOS = new ArrayList<>();
        pointDTOS.add(new DeviceData.PointDTO("", ""));
        datasDTOS.add(new DeviceData.DatasDTO("", pointDTOS));
        DeviceData deviceData = new DeviceData(datasDTOS);
        netWorkBusiness.addSensorData("", deviceData, new MyObserver());
    }

    @Test
    public void getSensorDataGrouping() {
        netWorkBusiness.getSensorDataGrouping("12852", "alarm", "2", "", "2018-06-19", "2018-06-21", new MyObserver());
    }

    @Test
    public void getSensorData() {
        netWorkBusiness.getSensorData("", "", "", "", "", "", "", "", "", new MyObserver());
    }

    @Test
    public void control() {
        netWorkBusiness.control("", "", "", new MyObserver());
    }
}