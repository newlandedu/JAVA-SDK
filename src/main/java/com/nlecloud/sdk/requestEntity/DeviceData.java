package com.nlecloud.sdk.requestEntity;

import java.util.List;

public class DeviceData {

    private List<DatasDTO> DatasDTO;

    public DeviceData(List<DeviceData.DatasDTO> datasDTO) {
        DatasDTO = datasDTO;
    }

    public static class DatasDTO {
        private String ApiTag;
        private List<PointDTO> pointDTO;

        public DatasDTO(String apiTag, List<PointDTO> pointDTO) {
            ApiTag = apiTag;
            this.pointDTO = pointDTO;
        }
    }
    public static class PointDTO {
        private Object Value;
        private String RecordTime;
        public PointDTO(Object value, String recordTime) {
            Value = value;
            RecordTime = recordTime;
        }


    }
}
