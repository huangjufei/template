package com.hjf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 添加了参数效验
 */
@ApiModel(value = "t_user", description = "用户")
public class UserDomain {

    @ApiModelProperty(value = "用户Id")
    private Integer userId;
    @NotBlank(message = "名字不能为空")
    @ApiModelProperty(value = "名字")
    private String userName;
    @ApiParam(value = "密码", allowEmptyValue = false)
    private String password;
    @Size(min = 11, max = 11, message = "手机号码必须是11位")
    @ApiParam(value = "手机", allowEmptyValue = true)
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
