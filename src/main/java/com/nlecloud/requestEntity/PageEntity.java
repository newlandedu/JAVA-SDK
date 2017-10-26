package com.nlecloud.requestEntity;

public class PageEntity {
    private String StartDate;
    private String EndDate;
    private int  PageIndex;
    private int  PageSize;

    public PageEntity(String startDate, String endDate, int pageIndex, int pageSize) {
        StartDate = startDate;
        EndDate = endDate;
        PageIndex = pageIndex;
        PageSize = pageSize;
    }
}
