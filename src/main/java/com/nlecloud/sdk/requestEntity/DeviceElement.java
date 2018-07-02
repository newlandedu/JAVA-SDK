package com.nlecloud.sdk.requestEntity;

public class DeviceElement {
    private String Name;
    private String TransType;
    private String DataType;
    private String TypeAttrs;

    public DeviceElement(String name, String transType, String dataType, String typeAttrs) {
        Name = name;
        TransType = transType;
        DataType = dataType;
        TypeAttrs = typeAttrs;
    }

    public static class SensorDeviceElement extends DeviceElement {
        private String Unit;
        private String Precision;


        public SensorDeviceElement(String name, String transType, String dataType, String typeAttrs, String unit, String precision) {
            super(name, transType, dataType, typeAttrs);
            Unit = unit;
            Precision = precision;
        }
    }

    public static class ActuatorDeviceElement extends DeviceElement {
        private String OperType;
        private String OperTypeAttrs;
        private String SerialNumber;


        public ActuatorDeviceElement(String name, String transType, String dataType, String typeAttrs, String operType, String operTypeAttrs, String serialNumber) {
            super(name, transType, dataType, typeAttrs);
            OperType = operType;
            OperTypeAttrs = operTypeAttrs;
            SerialNumber = serialNumber;
        }
    }

    public static class CameraDeviceElement extends DeviceElement {
        private String HttpIp;
        private String HttpPort;
        private String UserName;
        private String Password;
        public CameraDeviceElement(String name, String transType, String dataType, String typeAttrs, String httpIp, String httpPort, String userName, String
                password) {
            super(name, transType, dataType, typeAttrs);
            HttpIp = httpIp;
            HttpPort = httpPort;
            UserName = userName;
            Password = password;
        }


    }
}