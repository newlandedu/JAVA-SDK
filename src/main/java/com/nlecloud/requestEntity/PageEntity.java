package com.nlecloud.requestEntity;

public class PageEntity {
    public String StartDate;
    public String EndDate;
    public int  PageIndex;
    public int  PageSize;

    public PageEntity(String startDate, String endDate, int pageIndex, int pageSize) {
        StartDate = startDate;
        EndDate = endDate;
        PageIndex = pageIndex;
        PageSize = pageSize;
    }
}
