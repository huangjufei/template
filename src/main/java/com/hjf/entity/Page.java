package com.hjf.entity;

import java.util.List;

public class Page<T> {
    /**
     * 降序排序
     */
    public static final String DESC = "DESC";
    /**
     * 升序排序
     */
    public static final String ASC = "ASC";

    /**
     * 页码
     */
    private int pageNum = 1;

    /**
     * 每页显示条数
     */
    private int pageSize = 10;
    /**
     * 排序类型DESC ASC
     */
    private String sortType;

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 总页数
     */
    private int totalPage;


    /**
     * 总页数
     */
    private int totalNumber;


    //对象
    private List<T> t;


    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}