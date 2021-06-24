package com.hjf.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class TestRequetBody {


    /**
     * @JsonFormat用于后端传给前端的时间格式转换，
     * @DateTimeFormat用于前端传给后端的时间格式转换且是通过url?号方式
     *
     * 奇怪的是在请求进来的字符串json={"userName":"df","date":"2001-01-02 17:55:22"} 转
     * 日期对象类型时不加@JsonFormat会报错,这个注解网上一直说后端返回前端使用,但加了这个就不报错
     *
     * 第一种方式实体类通过日期类型接受把日期类型统一返回json格式;推荐
     * 第二种思路就是通过String类型接受和string类型返回,
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;



    private String userName;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
